package br.com.rkoyanagui.cornichon.screen.interactions.menus;

import br.com.rkoyanagui.cornichon.screen.interactions.Readable;
import java.util.List;
import java.util.function.Predicate;

public interface MultipleChoiceMenu<M extends MultipleChoiceMenu<M, O>, O extends Readable<O>> extends
    SingleChoiceMenu<M, O> {

  M selectIf(Predicate<O> predicate);

  M selectRangeClosed(int firstInclusive, int lastInclusive);

  M selectMultiple(int... index);

  List<O> getSelectedOptions();
}
