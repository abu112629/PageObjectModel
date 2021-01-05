package com.canadalife.automation.grsoe.support;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.utils.WebHelper;

public class AppHelper {

    public static void waitForXHR(int times) {
        for (int i = 0; i<times; i++) {
            WebHelper.sleep(200);
            try {
                WebHelper.waitForXHR();
            } catch (Exception ignore){}
        }
    }

    @SuppressWarnings("unused")
    @Step("{1}")
    public static void virtualStep(Runnable r, String msg) {
        r.run();
    }

    public static void scrollToView(WebElement el) {
        ((JavascriptExecutor) WebHelper.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", el);
        WebHelper.sleep(500); // Wait for scroll to complete
    }


}
