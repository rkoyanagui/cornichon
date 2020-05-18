package br.com.rkoyanagui.cornichon.runners.google;

import static br.com.rkoyanagui.cornichon.screen.interactions.Waitable.willWait;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import br.com.rkoyanagui.cornichon.pages.GooglePage;
import br.com.rkoyanagui.cornichon.screen.interactions.ScreenshotTaker;
import br.com.rkoyanagui.cornichon.screen.selenium.WebDriverStarter;
import br.com.rkoyanagui.cornichon.utils.Context;
import io.cucumber.java8.Pt;
import org.springframework.beans.factory.annotation.Autowired;

public final class GoogleVerificationSteps implements Pt {

  @Autowired
  private Context context;
  @Autowired
  private WebDriverStarter webDriverStarter;
  @Autowired
  private ScreenshotTaker screenshotTaker;

  private GooglePage googlePage;

  public GoogleVerificationSteps() {

    Entao("Google deve exibir os resultados da busca", () -> {

      String searchTerm = context.<String>get("search_term")
          .orElseThrow(() -> new IllegalStateException("Missing what the last 'search_term' was!"));

      googlePage = new GooglePage(webDriverStarter.getFirstBrowserWebDriverContainer());
      willWait().until(() -> googlePage.getTitle(),
          is(allOf(notNullValue(), containsString(searchTerm))));
      screenshotTaker.takeScreenshot();
    });
  }
}
