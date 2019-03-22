package appium.cucumber.utils;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Capabilities {

    private DesiredCapabilities capabilities = new DesiredCapabilities();

    private Capabilities() {}

    private static Capabilities forAndroid() {
        Capabilities caps = new Capabilities();
        caps.capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        return caps;
    }

    private static Capabilities forIOS() {
        Capabilities caps = new Capabilities();
        caps.capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        caps.capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.1");
        caps.capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8");
//        caps.capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Xʀ");
        caps.capabilities.setCapability(MobileCapabilityType.UDID, "173A218B-BA1D-4CA4-8A95-0B123207B925");
        caps.capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        caps.capabilities.setCapability("showXcodeLog", true);
        return caps;
    }

    private Capabilities withBrowser(String browser) {
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browser);
        return this;
    }

    public static DesiredCapabilities forAndroidBrowser(String browser) {
        return forAndroid().withBrowser(browser).capabilities;
    }

    public static DesiredCapabilities forIOSBrowser(String browser) {
        return forIOS().withBrowser(browser).capabilities;
    }
}
