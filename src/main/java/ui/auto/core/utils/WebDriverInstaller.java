package ui.auto.core.utils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverInstaller {

    public void installDriver(String driverName, String driverPropertyName) {
        System.setProperty("webdriver.edge.driver","/Users/braimm/edge/msedgedriver");
        switch (driverName) {
            case "chromedriver" :
                WebDriverManager.chromedriver().setup();
                break;
            case "geckodriver":
                WebDriverManager.firefoxdriver().setup();
                break;
        }
    }


}
