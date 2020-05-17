package br.com.rkoyanagui.cornichon.screen.interactions.selection;

import br.com.rkoyanagui.cornichon.screen.interactions.Readable;
import br.com.rkoyanagui.cornichon.screen.interactions.Visible;
import java.util.List;

public interface MultipleChoicer<M extends MultipleChoicer<M, C>, C extends Visible<C> & Readable<C>> extends
    SingleChoicer<M, C> {

  M selectRange(int firstInclusive, int lastInclusive);

  M selectMultiple(int... index);

  List<M> getSelectedOptions();
}
