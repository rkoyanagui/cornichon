package br.com.rkoyanagui.cornichon.screen.elements;

import br.com.rkoyanagui.cornichon.screen.interactions.CloseableWindow;
import br.com.rkoyanagui.cornichon.screen.interactions.HasTitle;
import br.com.rkoyanagui.cornichon.screen.interactions.Loadable;
import br.com.rkoyanagui.cornichon.screen.interactions.Locatable;
import br.com.rkoyanagui.cornichon.screen.interactions.Maximisable;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;
import lombok.NonNull;
import org.openqa.selenium.By;

public abstract class Page<P extends Page<P>> extends ScreenElement<P> implements CloseableWindow,
    HasTitle, Loadable<P>,
    Maximisable<P> {

  public Page(
      @NonNull WebDriverContainer webDriverContainer,
      Locatable parent,
      @NonNull By locator) {

    super(webDriverContainer, parent, locator);
  }

  public Page(@NonNull WebDriverContainer webDriverContainer) {
    super(webDriverContainer, null, By.xpath("./html"));
  }
}
