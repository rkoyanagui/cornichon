package br.com.rkoyanagui.cornichon.screen.interactions.tables;

import br.com.rkoyanagui.cornichon.screen.interactions.Clickable;
import br.com.rkoyanagui.cornichon.screen.interactions.Sizable;
import br.com.rkoyanagui.cornichon.screen.interactions.Visible;
import java.util.List;

public interface TableLike<T extends TableLike<T, H, R>, H extends HeaderLike, R extends RowLike> extends
    Visible<T>, Clickable<T>, Sizable {

  H getHeader();

  List<R> getRows();

  R getRow(int index);
}
