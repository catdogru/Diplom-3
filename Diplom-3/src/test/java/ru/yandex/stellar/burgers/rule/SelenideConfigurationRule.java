package ru.yandex.stellar.burgers.rule;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.rules.ExternalResource;
import ru.yandex.stellar.burgers.constants.Constants.Browser;

import static com.codeborne.selenide.Configuration.*;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static java.lang.System.getProperty;
import static ru.yandex.stellar.burgers.constants.Constants.Browser.CHROME_BROWSER;
import static ru.yandex.stellar.burgers.constants.Constants.Browser.FIREFOX_BROWSER;
import static ru.yandex.stellar.burgers.constants.Constants.SystemProperties.*;

public class SelenideConfigurationRule extends ExternalResource {
    @Override
    protected void before() {
        applySelenideConfiguration();
    }

    public void applySelenideConfiguration() {
        // common configuration properties
        screenshots = false;
        pageLoadTimeout = 90_000; // 30000 by default
        timeout = 15_000; // 4000 by default

        // browser configuration properties
        switch (Browser.getBrowserByValue(getProperty(BROWSER_PROPERTY))) {
            case YANDEX_BROWSER:
                browser = CHROME_BROWSER.getValue();
                browserBinary = getProperty(DRIVER_BINARY_PROPERTY);
                chromedriver().driverVersion(getProperty(DRIVER_VERSION_PROPERTY)).setup();
                break;
            case FIREFOX_BROWSER:
                browser = FIREFOX_BROWSER.getValue();
                break;
            default:
                browser = CHROME_BROWSER.getValue();
                break;
        }
    }

    @Override
    public void after() {
        WebDriverRunner.driver().close();
    }
}