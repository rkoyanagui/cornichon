package br.com.rkoyanagui.cornichon.screen.elements.tables;

import static java.util.Objects.nonNull;

import br.com.rkoyanagui.cornichon.screen.elements.ScreenElement;
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

public abstract class TableLike<T extends TableLike<T, H, R>, H extends RowLike<H>, R extends RowLike<R>> extends
    ScreenElement<T> implements Clickable<T>, Sizeable {

  public TableLike(
      @NonNull WebDriverContainer webDriverContainer,
      Locatable parent,
      @NonNull By locator) {
    super(webDriverContainer, parent, locator);
  }

  public H getHeader(By by) {
    return (H) new RowLike<H>(getWebDriverContainer(), this, by) {
    };
  }

  public H getHeader() {
    return getHeader(By.xpath("./thead/tr"));
  }

  public List<R> getRows() {
    return getRows(By.xpath("./tbody/tr"));
  }

  public List<R> getRows(By by) {
    List<WebElement> webElementList = locate()
        .map(tableWebElement -> tableWebElement.findElements(by))
        .orElseGet(ArrayList::new);
    return IntStream.rangeClosed(1, webElementList.size())
        .mapToObj(this::getRow)
        .collect(Collectors.toList());
  }

  public R getRow(int index) {
    return getRow(By.xpath("./tbody/tr[" + index + "]"));
  }

  public R getRow(By by) {
    return (R) new RowLike<R>(getWebDriverContainer(), this, by) {
    };
  }

  @Override
  public int size() {
    return getRows().size();
  }

  @Override
  public T scrollDownTo() {
    List<R> rows = getRows();
    if (!rows.isEmpty()) {
      getVisibleProcessor().scrollDownTo(rows.get(rows.size() - 1));

    } else {
      getVisibleProcessor().scrollDownTo(this);
    }
    return (T) this;
  }

  @Override
  public T scrollUpTo() {
    H header = getHeader();
    if (nonNull(header) && header.hasBeenFound()) {
      getVisibleProcessor().scrollUpTo(header);

    } else {

      List<R> rows = getRows();
      if (!rows.isEmpty()) {
        getVisibleProcessor().scrollUpTo(rows.get(0));

      } else {
        getVisibleProcessor().scrollUpTo(this);
      }
    }
    return (T) this;
  }
}
