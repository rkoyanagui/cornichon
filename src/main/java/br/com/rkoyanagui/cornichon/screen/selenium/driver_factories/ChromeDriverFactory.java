package br.com.rkoyanagui.cornichon.screen.selenium.driver_factories;

import static java.util.Objects.nonNull;

import br.com.rkoyanagui.cornichon.config.WebDriverProperties;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeDriverFactory implements WebDriverFactory {

  @Override
  public WebDriver getWebDriver(
      URL url,
      DesiredCapabilities capabilities,
      WebDriverProperties properties) {

    System.setProperty("webdriver.chrome.driver",
        new File(properties.getExecutables().getChrome()).getAbsolutePath());

    Map<String, Object> preferences = new HashMap<>();
    preferences.put("profile.password_manager_enabled", false);
    preferences.put("download.default_directory",
        new File(properties.getDownloadFolder()).getAbsolutePath());

    ChromeOptions options = new ChromeOptions();
    options.merge(capabilities)
        .addArguments("--no-default-browser-check")
        .setExperimentalOption("prefs", preferences);

    if (properties.isHeadless()) {

      options = options.setHeadless(true).addArguments("window-size=1366,768");
    }

    if (nonNull(url)) {

      return new RemoteWebDriver(url, options);

    } else {

      return new ChromeDriver(options);
    }
  }
}
