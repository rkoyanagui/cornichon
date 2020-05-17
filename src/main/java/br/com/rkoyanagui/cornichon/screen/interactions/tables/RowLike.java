package br.com.rkoyanagui.cornichon.screen.interactions.tables;

import br.com.rkoyanagui.cornichon.screen.interactions.Clickable;
import br.com.rkoyanagui.cornichon.screen.interactions.Visible;
import java.util.List;

public interface RowLike<R extends RowLike<R, C>, C> extends Visible<R>, Clickable<R> {

  List<C> getCells();

  C getCell(int column);
}
