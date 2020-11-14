package br.com.rkoyanagui.cornichon.screen.elements.menus;

import static br.com.rkoyanagui.cornichon.screen.interactions.Clickable.clickable;
import static br.com.rkoyanagui.cornichon.screen.interactions.Waitable.willWait;
import static org.hamcrest.Matchers.is;

import br.com.rkoyanagui.cornichon.screen.elements.ScreenElement;
import br.com.rkoyanagui.cornichon.screen.elements.Text;
import br.com.rkoyanagui.cornichon.screen.interactions.Locatable;
import br.com.rkoyanagui.cornichon.screen.interactions.menus.SingleChoiceMenu;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public final class SimpleSelectTag extends ScreenElement<SimpleSelectTag> implements
    SingleChoiceMenu<SimpleSelectTag, Text> {

  private static final String BASE_OPTION_XPATH = "./option";

  public SimpleSelectTag(
      @NonNull WebDriverContainer webDriverContainer,
      Locatable parent,
      @NonNull By locator) {
    super(webDriverContainer, parent, locator);
  }

  @Override
  public SimpleSelectTag select(int index) {
    willWait()
        .until(() -> this, is(clickable()))
        .locate()
        .ifPresent(selectTagWebElement -> new Select(selectTagWebElement).selectByIndex(index));

    return this;
  }

  @Override
  public SimpleSelectTag select(String visibleText) {
    select(webElement -> Objects.equals(webElement.getText(), visibleText));
    return this;
  }

  @Override
  public SimpleSelectTag select(@NonNull String attributeName, String expectedValue) {
    Predicate<WebElement> predicate = webElement ->
        Objects.equals(webElement.getAttribute(attributeName), expectedValue);

    select(predicate);
    return this;
  }

  @Override
  public SimpleSelectTag select(Predicate<WebElement> predicate) {

    willWait()
        .until(() -> this, is(clickable()))
        .locate()
        .ifPresent(selectTagWebElement -> {

          Select selectTag = new Select(selectTagWebElement);

          willWait().until(() -> selectTag.getOptions()
              .stream()
              .anyMatch(predicate));

          int i = 0;
          for (WebElement option : selectTag.getOptions()) {

            if (predicate.test(option)) {

              selectTag.selectByIndex(i);
              break;
            }
            i++;
          }
        });

    return this;
  }

  @Override
  public List<Text> getOptions() {
    return getOptions(By.xpath(BASE_OPTION_XPATH));
  }

  @Override
  public List<Text> getOptions(By by) {
    List<WebElement> webElementList = willWait()
        .until(() -> this, is(clickable()))
        .locate()
        .map(selectWebElement -> selectWebElement.findElements(by))
        .orElseGet(ArrayList::new);

    return IntStream.rangeClosed(1, webElementList.size())
        .mapToObj(this::getOption)
        .collect(Collectors.toList());
  }

  @Override
  public Text getOption(int index) {
    return getOption(By.xpath(BASE_OPTION_XPATH + "[" + index + "]"));
  }

  @Override
  public Text getOption(By by) {
    return new Text(getWebDriverContainer(), this, by);
  }

  @Override
  public Optional<Text> getSelectedOption() {
    return getOptions()
        .stream()
        .filter(text -> text.locate().map(WebElement::isSelected).orElse(false))
        .findFirst();
  }

  @Override
  public int size() {
    return getOptions().size();
  }
}