package org.wikipedia.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.wikipedia.drivers.BrowserstackMobileDriver;
import org.wikipedia.drivers.LocalMobileDriver;
import org.wikipedia.helpers.Attach;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;
import static org.wikipedia.helpers.Attach.sessionId;

public class TestBase {
    static String host = System.getProperty("host", "bs");

    @BeforeAll
    public static void setup() {
        if (host.equals("local")) {
            Configuration.browser = LocalMobileDriver.class.getName();
        } else if (host.equals("bs")) {
            Configuration.browser = BrowserstackMobileDriver.class.getName();
        } else {
            Configuration.browser = BrowserstackMobileDriver.class.getName();
        }
        Configuration.browserSize = null;
    }


    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = sessionId();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        step("Close driver", Selenide::closeWebDriver);
        if (host.equals("bs")) {
            Attach.video(sessionId);
        }
    }
}