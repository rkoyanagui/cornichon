package br.com.rkoyanagui.cornichon.screen.elements;

import br.com.rkoyanagui.cornichon.screen.interactions.CloseableWindow;
import br.com.rkoyanagui.cornichon.screen.interactions.HasTitle;
import br.com.rkoyanagui.cornichon.screen.interactions.Loadable;
import br.com.rkoyanagui.cornichon.screen.interactions.Locatable;
import br.com.rkoyanagui.cornichon.screen.interactions.Maximisable;
import br.com.rkoyanagui.cornichon.screen.processors.closeable_window.CloseableWindowProcessor;
import br.com.rkoyanagui.cornichon.screen.processors.has_title.PageTitleProcessor;
import br.com.rkoyanagui.cornichon.screen.processors.loadable.LoadableProcessor;
import br.com.rkoyanagui.cornichon.screen.processors.maximisable.MaximisableProcessor;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;
import java.util.Optional;
import lombok.Getter;
import lombok.NonNull;
import org.openqa.selenium.By;

@Getter
public abstract class Page<P extends Page<P>> implements CloseableWindow, HasTitle, Loadable<P>,
    Maximisable<P> {

  private WebDriverContainer webDriverContainer;
  private Locatable parent;
  private By locator;
  private CloseableWindowProcessor closeableWindowProcessor;
  private PageTitleProcessor pageTitleProcessor;
  private LoadableProcessor loadableProcessor;
  private MaximisableProcessor maximisableProcessor;

  public Page(@NonNull WebDriverContainer webDriverContainer,
      Locatable parent,
      By locator) {

    this.webDriverContainer = webDriverContainer;
    this.parent = parent;
    this.locator = locator;
    this.closeableWindowProcessor = CloseableWindowProcessor.getChain();
    this.loadableProcessor = LoadableProcessor.getChain();
    this.maximisableProcessor = MaximisableProcessor.getChain();
    this.pageTitleProcessor = PageTitleProcessor.getChain();
  }

  public Page(@NonNull WebDriverContainer webDriverContainer) {
    this(webDriverContainer, null, By.xpath("./html"));
  }

  @Override
  public Optional<Locatable> getParent() {
    return Optional.ofNullable(parent);
  }
}
