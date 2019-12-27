package com.saucelabs.simplesauce;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.UnexpectedAlertBehaviour.DISMISS;

public class SauceOptionsTest extends BaseConfigurationTest{
    @Test
    public void usesLatestChromeWindowsVersions() {
        assertEquals(BrowserType.CHROME, sauceOptions.getBrowserName());
        assertEquals("Windows 10", sauceOptions.getPlatformName());
        assertEquals("latest", sauceOptions.getBrowserVersion());
    }

    @Test
    public void updatesBrowserBrowserVersionPlatformVersionValues() {
        sauceOptions.setBrowserName(BrowserType.FIREFOX);
        sauceOptions.setPlatformName(Platforms.MAC_OS_HIGH_SIERRA.getOsVersion());
        sauceOptions.setBrowserVersion("68");

        assertEquals(BrowserType.FIREFOX, sauceOptions.getBrowserName());
        assertEquals("68", sauceOptions.getBrowserVersion());
        assertEquals("macOS 10.13", sauceOptions.getPlatformName());
    }

    @Test
    @Ignore("Not Implemented Yet")
    public void acceptsOtherW3CValues() {
    }

    @Test
    @Ignore("Not Implemented Yet")
    public void acceptsSauceLabsSettings() {
    }

    @Test
    public void acceptsSeleniumBrowserOptionsClass() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--foo");
        firefoxOptions.addPreference("foo", "bar");
        firefoxOptions.setUnhandledPromptBehaviour(DISMISS);

        sauceOptions = new SauceOptions(firefoxOptions);

        assertEquals("firefox", sauceOptions.getBrowserName());
        assertEquals(firefoxOptions, sauceOptions.getSeleniumCapabilities());
    }

    @Test
    public void acceptsSeleniumMutableCapabilitiesClass() {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("browserName", "firefox");
        SauceOptions sauceOptions = new SauceOptions(caps);
        assertEquals(caps, sauceOptions.getSeleniumCapabilities());

        caps.setCapability("browserName", "chrome");
        assertEquals("firefox", sauceOptions.getSeleniumCapabilities().getBrowserName());
    }

    @Test
    @Ignore("Not Implemented Yet")
    public void setsCapabilitiesFromMap() {
    }

    @Test
    @Ignore("Not Implemented Yet")
    public void allowsBuildToBeSet() {
    }

    @Test
    @Ignore("Not Implemented Yet")
    public void createsDefaultBuildName() {
    }

    @Test
    @Ignore("Not Implemented Yet")
    public void parsesW3CAndSauceAndSeleniumSettings() {
    }
}
