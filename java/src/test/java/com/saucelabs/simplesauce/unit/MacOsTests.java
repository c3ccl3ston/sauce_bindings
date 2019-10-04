package com.saucelabs.simplesauce.unit;

import com.saucelabs.simplesauce.Platforms;
import com.saucelabs.simplesauce.SafariVersion;
import com.saucelabs.simplesauce.SauceOptions;
import com.saucelabs.simplesauce.SauceSession;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.junit.Assert.assertEquals;

public class MacOsTests extends BaseConfigurationTest{
    @Test
    public void withMacOsMojave_returnsMacOs1014() {
        SauceOptions sauceOptions = new SauceOptions();
        sauceOptions.withMacOsMojave();
        mockSauceSession = new SauceSession(sauceOptions, fakeRemoteDriver, fakeEnvironmentManager);

        mockSauceSession.start();
        String actualOsThatWasSet = mockSauceSession.sauceSessionCapabilities.getPlatform().toString();
        assertEquals("macOS 10.14", actualOsThatWasSet);
    }
    @Test
    public void withMacOsHighSierra_returnsMacOs1013() {
        mockSauceSession.withMacOsHighSierra();
        mockSauceSession.start();
        String actualOsThatWasSet = mockSauceSession.sauceSessionCapabilities.getPlatform().toString();
        assertEquals("macOS 10.13", actualOsThatWasSet);
    }
    @Test
    public void withMacOsSierra_returnsMacOs1012() {
        mockSauceSession.withMacOsSierra();
        mockSauceSession.start();
        String actualOsThatWasSet = mockSauceSession.sauceSessionCapabilities.getPlatform().toString();
        assertEquals("macOS 10.12", actualOsThatWasSet);
    }
    @Test
    public void withMacOsElCapitan_returnsMacOs1011() {
        mockSauceSession.withMacOsXElCapitan();
        mockSauceSession.start();
        String actualOsThatWasSet = mockSauceSession.sauceSessionCapabilities.getPlatform().toString();
        assertEquals("OS X 10.11", actualOsThatWasSet);
    }
    @Test
    public void withMacOsYosemite_returnsMacOsX1010() {
        mockSauceSession.withMacOsXYosemite();
        mockSauceSession.start();
        String actualOsThatWasSet = mockSauceSession.sauceSessionCapabilities.getPlatform().toString();
        assertEquals("OS X 10.10", actualOsThatWasSet);
    }
    @Test
    public void defaultSafari_browserVersionIs12_0() {
        SauceOptions sauceOptions = new SauceOptions();
        sauceOptions.withSafari();
        mockSauceSession = new SauceSession(sauceOptions, fakeRemoteDriver, fakeEnvironmentManager);

        mockSauceSession.start();

        String safariVersionSetThroughSauceSession = mockSauceSession.sauceSessionCapabilities.getVersion();
        assertEquals("12.0", safariVersionSetThroughSauceSession);
    }
    @Test
    public void defaultSafari_macOsVersionIsMojave() {
        SauceOptions sauceOptions = new SauceOptions();
        sauceOptions.withSafari();
        mockSauceSession = new SauceSession(sauceOptions, fakeRemoteDriver, fakeEnvironmentManager);

        mockSauceSession.start();

        String safariVersionSetThroughSauceSession = mockSauceSession.sauceSessionCapabilities.getPlatform().toString();
        assertThat(Platforms.MAC_OS_MOJAVE, equalToIgnoringCase(safariVersionSetThroughSauceSession));
    }
    @Test
    public void withSafari_browserName_setToSafari() {
        mockSauceSession.withSafari(SafariVersion._8);
        mockSauceSession.start();

        String actualBrowserNameSetThroughSauceSession = mockSauceSession.sauceSessionCapabilities.getBrowserName();
        assertEquals("safari", actualBrowserNameSetThroughSauceSession);
    }
    @Test
    public void withSafari_versionChangedFromDefault_returnsCorrectVersion() {
        mockSauceSession.withSafari(SafariVersion._8);
        mockSauceSession.start();

        String actualBrowserVersionSetThroughSauceSession = mockSauceSession.sauceSessionCapabilities.getVersion();
        assertEquals("8.0", actualBrowserVersionSetThroughSauceSession);
    }
}
