package com.canadalife.automation.grsoe.api.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailMessage {
    private final Message message;

    public MailMessage(Message message) {
        this.message = message;
    }

    private String parseAddresses(Address[] address) {
        StringBuilder listAddress = new StringBuilder();

        if (address != null) {
            for (Address addr : address) {
                if (addr instanceof InternetAddress) {
                    listAddress.append(((InternetAddress) addr).getAddress()).append(", ");
                } else {
                    listAddress.append(addr.toString()).append(", ");
                }
            }
        }

        if (listAddress.length() > 1) {
            listAddress = new StringBuilder(listAddress.substring(0, listAddress.length() - 2));
        }

        return listAddress.toString();
    }


    public void printMessage() {
        try {
            String from = parseAddresses(message.getFrom());
            String toList = parseAddresses(message.getRecipients(Message.RecipientType.TO));
            String ccList = parseAddresses(message.getRecipients(Message.RecipientType.CC));
            String subject = message.getSubject();
            String sentDate = message.getSentDate().toString();

            StringBuilder messageContent = new StringBuilder("\n");

            List<String> content = getMessageContent();
            int c = 0;
            for (String cont : content) {
                c++;
                if (content.size() > 1) {
                    messageContent.append("----------- PART #").append(c).append(" -----------\n");
                }
                messageContent.append(cont).append("\n");
            }

            System.out.println("Message :");
            System.out.println("\t From: " + from);
            System.out.println("\t To: " + toList);
            System.out.println("\t CC: " + ccList);
            System.out.println("\t Subject: " + subject);
            System.out.println("\t Sent Date: " + sentDate);
            System.out.println("\t Message: " + messageContent);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<String> getMessageContent() {
        List<String> content;
        try {
            content = parseMessageContent(message.getContent(), null);
        } catch (MessagingException | IOException e) {
            throw new RuntimeException(e);
        }
        return content;
    }

    private List<String> parseMessageContent(Object content, List<String> text) {
        List<String> fullText = text;
        if (fullText == null) {
            fullText = new ArrayList<>();
        }
        if (content instanceof MimeMultipart) {
            MimeMultipart mimeParts = (MimeMultipart) content;
            int count;
            try {
                count = mimeParts.getCount();
                for (int i = 0; i < count; i++) {
                    BodyPart bodyPart = mimeParts.getBodyPart(i);
                    parseMessageContent(bodyPart.getContent(), fullText);
                }
            } catch (MessagingException | IOException e) {
                e.printStackTrace();
            }

        } else if (content instanceof String) {
            fullText.add((String) content);
        }
        return fullText;
    }

    private String getActUrl(String urlPattern) {
        String msgUrl = null;
        String content = getMessageContent().get(0);
        Pattern pattern = Pattern.compile(urlPattern);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            msgUrl = matcher.group(1);
        }
        return msgUrl;
    }

   public String getUserActivationUrl() {
        String urlPattern = ".*(https://.*)";
        return getActUrl(urlPattern);
    }

}
