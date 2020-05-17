package br.com.rkoyanagui.cornichon.spring;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

import br.com.rkoyanagui.cornichon.screen.selenium.driver_factories.ChromeDriverFactory;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_factories.WebDriverFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class WebDriverConfig {

  @Bean
  @ConditionalOnProperty(prefix = "webdriver", name = "browser", havingValue = "chrome", matchIfMissing = true)
  @Scope(SCOPE_CUCUMBER_GLUE)
  public WebDriverFactory chrome(@Value("${webdriver.browser}") String browserName) {

    return new ChromeDriverFactory();
  }
}
