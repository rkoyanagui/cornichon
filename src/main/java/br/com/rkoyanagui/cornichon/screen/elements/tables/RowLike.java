package br.com.rkoyanagui.cornichon.screen.elements.tables;

import br.com.rkoyanagui.cornichon.screen.elements.ScreenElement;
import br.com.rkoyanagui.cornichon.screen.elements.Text;
import br.com.rkoyanagui.cornichon.screen.interactions.Clickable;
import br.com.rkoyanagui.cornichon.screen.interactions.Locatable;
import br.com.rkoyanagui.cornichon.screen.interactions.Sizeable;
import br.com.rkoyanagui.cornichon.screen.selenium.driver_containers.WebDriverContainer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class RowLike<R extends RowLike<R>> extends ScreenElement<R> implements
    Clickable<R>, Sizeable {

  public RowLike(
      @NonNull WebDriverContainer webDriverContainer,
      Locatable parent,
      @NonNull By locator) {
    super(webDriverContainer, parent, locator);
  }

  public List<Text> getCells(By by) {
    List<WebElement> webElementList = locate()
        .map(headerWebElement -> headerWebElement.findElements(by))
        .orElseGet(ArrayList::new);
    return IntStream.rangeClosed(1, webElementList.size())
        .mapToObj(this::getCell)
        .collect(Collectors.toList());
  }

  public List<Text> getCells() {
    return getCells(By.xpath("./*"));
  }

  public Text getCell(int column) {
    return getCell(By.xpath("./*[" + column + "]"));
  }

  public Text getCell(By by) {
    return new Text(getWebDriverContainer(), this, by);
  }

  @Override
  public int size() {
    return getCells().size();
  }
}
