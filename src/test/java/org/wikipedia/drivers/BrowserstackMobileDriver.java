package org.wikipedia.drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.wikipedia.configs.BrowserstackConfig;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {
    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", browserstackConfig.browserstackUser());
        mutableCapabilities.setCapability("browserstack.key", browserstackConfig.browserstackKey());
        // Set URL of the application under test
        mutableCapabilities.setCapability("app", browserstackConfig.appURL());
        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", browserstackConfig.device());
        mutableCapabilities.setCapability("os_version", browserstackConfig.osVersion());
        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", "wikipedia tests example");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "selenide android test");
        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }
}
