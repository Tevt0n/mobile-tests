package org.wikipedia.drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.wikipedia.helpers.DriverConfig;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class, System.getProperties());
        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", driverConfig.browserstackUser());
        mutableCapabilities.setCapability("browserstack.key", driverConfig.browserstackKey());

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", driverConfig.appURL());

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", driverConfig.device());
        mutableCapabilities.setCapability("os_version", driverConfig.osVersion());

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", "wikipedia tests example");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "selenide android test");
        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
