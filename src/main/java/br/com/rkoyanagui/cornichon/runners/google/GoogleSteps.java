package br.com.rkoyanagui.cornichon.runners.google;

import static br.com.rkoyanagui.cornichon.screen.interactions.Loadable.loaded;
import static br.com.rkoyanagui.cornichon.screen.interactions.Waitable.willWait;
import static org.hamcrest.Matchers.is;

import br.com.rkoyanagui.cornichon.pages.GooglePage;
import br.com.rkoyanagui.cornichon.screen.interactions.ScreenshotTaker;
import br.com.rkoyanagui.cornichon.screen.selenium.WebDriverStarter;
import br.com.rkoyanagui.cornichon.utils.Context;
import io.cucumber.java8.Pt;
import org.springframework.beans.factory.annotation.Autowired;

public final class GoogleSteps implements Pt {

  @Autowired
  private Context context;
  @Autowired
  private WebDriverStarter webDriverStarter;
  @Autowired
  private ScreenshotTaker screenshotTaker;

  private GooglePage googlePage;

  public GoogleSteps() {

    Dado("que estou na página inicial do Google", () -> {

      googlePage = new GooglePage(webDriverStarter.getFirstBrowserWebDriverContainer());
      googlePage.load(GooglePage.URL);
      willWait().until(() -> googlePage, is(loaded()))
          .maximise();
    });

    Quando("preencho o campo de busca com {string}", (String searchTerm) -> {

      context.put("search_term", searchTerm);
      googlePage.getFldQueryBar()
          .write(searchTerm)
          .submit();
    });
  }
}
