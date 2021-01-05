package com.canadalife.automation.grsoe.api.mail;


import ui.auto.core.support.EnvironmentsSetup;
import ui.auto.core.support.TestContext;
import ui.auto.core.utils.WebHelper;

import javax.mail.*;
import java.util.Properties;

public class MailClient {
    private final Store store;
    private Folder currentFolder;

    public MailClient() {
        EnvironmentsSetup.Environment env = TestContext.getTestProperties().getTestEnvironment();
        String[] s = env.getCustom("mail-server").split(":");
        String protocol = s[0];
        String host = s[1];
        String port = s[2];
        String userName = env.getCustom("mail-user");
        String password = env.getCustom("mail-password");
        Properties properties = new Properties();
        properties.put(String.format("mail.%s.host", protocol), host);
        properties.put(String.format("mail.%s.port", protocol), port);
        properties.setProperty(String.format("mail.%s.socketFactory.class", protocol), "javax.net.ssl.SSLSocketFactory");
        properties.setProperty(String.format("mail.%s.socketFactory.fallback", protocol), "false");
        properties.setProperty(String.format("mail.%s.socketFactory.port", protocol), String.valueOf(port));
        Session session = Session.getDefaultInstance(properties);
        try {
            store = session.getStore(protocol);
            store.connect(userName, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        closeFolder();
        try {
            store.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void closeFolder() {
        try {
            currentFolder.close(false);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public Message[] getInboxMessages() {
        try {
            currentFolder = store.getFolder("INBOX");
            currentFolder.open(Folder.READ_ONLY);
            return currentFolder.getMessages();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public MailMessage getMessage(String recipient) {
        Message[] messages = getInboxMessages();
        for (Message message : messages) {
            try {
                Address[] addresses =  message.getRecipients(Message.RecipientType.TO);
                if (addresses != null) {
                    for (Address address : addresses) {
                        if (address.toString().contains(recipient)) {
                            return new MailMessage(message);
                        }
                    }
                }
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public MailMessage waitForMessage(String recipient, long waitTime) {
        long to = System.currentTimeMillis() + waitTime;
        do {
            MailMessage msg = getMessage(recipient);
            if (msg != null) {
                return msg;
            } else {
                WebHelper.sleep(1000);
            }
        } while (System.currentTimeMillis() < to);
        return null;
    }

    public static void main(String[] args) {
        MailClient mailClient = new MailClient();
        for (Message msg : mailClient.getInboxMessages()) {
            new MailMessage(msg).printMessage();
        }
        mailClient.close();
    }

}
