package br.com.rkoyanagui.cornichon.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = {"classpath:features"},
    plugin = {
        "pretty",
        "json:target/cucumber-report/GoogleTest.json"
    }
)
public class FullTest extends AbstractTestNGCucumberTests {

  @DataProvider(parallel = true)
  @Override
  public Object[][] scenarios() {
    return super.scenarios();
  }
}
