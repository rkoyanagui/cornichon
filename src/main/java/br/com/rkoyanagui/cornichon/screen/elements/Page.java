package br.com.rkoyanagui.cornichon.screen.elements;

import br.com.rkoyanagui.cornichon.screen.interactions.CloseableWindow;
import br.com.rkoyanagui.cornichon.screen.interactions.HasTitle;
import br.com.rkoyanagui.cornichon.screen.interactions.Loadable;
import br.com.rkoyanagui.cornichon.screen.interactions.Locatable;
import br.com.rkoyanagui.cornichon.screen.interactions.Maximisable;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;
import java.util.Optional;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.By;

@Getter
public abstract class Page<P extends Page<P>> implements CloseableWindow, HasTitle, Loadable<P>,
    Maximisable<P> {

  private final WebDriverContainer webDriverContainer;
  private final Locatable parent;
  private final By locator;

  public Page(@NonNull WebDriverContainer webDriverContainer,
      Locatable parent,
      By locator) {

    this.webDriverContainer = webDriverContainer;
    this.parent = parent;
    this.locator = locator;
  }

  public Page(@NonNull WebDriverContainer webDriverContainer) {
    this(webDriverContainer, null, By.xpath("./html"));
  }

  @Override
  public Optional<Locatable> getParent() {
    return Optional.ofNullable(parent);
  }
}
