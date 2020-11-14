package br.com.rkoyanagui.cornichon.screen.interactions;

import static java.util.Objects.nonNull;

import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface Locatable {

  /**
   * Returns the container of the {@link WebDriver} used to interact with the screen.
   *
   * @return the container of the {@link WebDriver} used to interact with the screen.
   */
  WebDriverContainer getWebDriverContainer();

  /**
   * Returns an {@code Optional} containing this element's parent, if any, or an empty {@code
   * Optional}.
   *
   * @return an {@code Optional} containing this element's parent, if any, or an empty {@code
   * Optional}.
   */
  Optional<Locatable> getParent();

  /**
   * Returns the {@link By} object used to find this element on the screen.
   *
   * @return the {@link By} object used to find this element on the screen.
   */
  By getLocator();

  /**
   * Gets the {@link WebDriver}, then gets all of this element's ancestors, cycles through all of
   * them, finding them one by one, until it gets to and finds this element itself.
   *
   * @return an {@code Optional} containing this {@link WebElement}, or an empty {@code Optional} if
   * this element or any of its ancestors could not be found.
   */
  default Optional<WebElement> locate() {

    WebDriver webDriver = getWebDriverContainer().getWebDriver();

    List<By> locatorChain = getParentChain()
        .stream()
        .map(Locatable::getLocator)
        .collect(Collectors.toList());

    Optional<WebElement> webElement = Optional.empty();

    for (By by : locatorChain) {

      if (webElement.isPresent()) {
        webElement = webElement.flatMap(element -> element.findElements(by).stream().findFirst());

      } else {
        webElement = webDriver.findElements(by).stream().findFirst();
      }

      if (!webElement.isPresent()) {
        break;
      }
    }
    return webElement;
  }

  /**
   * Returns a stack of all screen elements of which this element is a descendant, in descending
   * order. For example, a Cell in a Table in a Page generates this stack: (HEAD) Page - Table -
   * (TAIL) Cell.
   *
   * @return Returns a stack of all screen elements of which this element is a descendant, in
   * descending order.
   */
  default Deque<Locatable> getParentChain() {

    Deque<Locatable> deque = new ArrayDeque<>();
    deque.push(this);
    Optional<Locatable> locatable = this.getParent();

    while (locatable.isPresent()) {

      deque.push(locatable.get());
      locatable = locatable.get().getParent();
    }
    return deque;
  }

  /**
   * Returns {@code true} if this element was found on the screen, otherwise {@code false}.
   *
   * @return {@code true} if this element was found on the screen, otherwise {@code false}
   */
  default boolean hasBeenFound() {
    return locate().isPresent();
  }

  static LocatableMatcher found() {
    return new LocatableMatcher();
  }

  class LocatableMatcher extends BaseMatcher<Locatable> {

    @Override
    public boolean matches(Object actual) {
      if (nonNull(actual) && actual instanceof Locatable) {
        return ((Locatable) actual).hasBeenFound();
      }
      return false;
    }

    @Override
    public void describeTo(Description description) {
      description.appendText("a screen element successfully found in the page document");
    }
  }
}
