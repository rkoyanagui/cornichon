package br.com.rkoyanagui.cornichon.screen.interactions.menus;

import br.com.rkoyanagui.cornichon.screen.interactions.Clickable;
import br.com.rkoyanagui.cornichon.screen.interactions.Readable;
import br.com.rkoyanagui.cornichon.screen.interactions.Sizeable;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface SingleChoiceMenu<S extends SingleChoiceMenu<S, O>, O extends Readable<O>> extends
    Clickable<S>, Sizeable {

  S select(int index);

  S select(String visibleText);

  S select(String attributeName, String expectedValue);

  S select(Predicate<WebElement> predicate);

  List<O> getOptions();

  List<O> getOptions(By by);

  O getOption(int index);

  O getOption(By by);

  Optional<O> getSelectedOption();
}
