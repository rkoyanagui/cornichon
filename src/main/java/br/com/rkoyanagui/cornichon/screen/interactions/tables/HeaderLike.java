package br.com.rkoyanagui.cornichon.screen.interactions.tables;

import br.com.rkoyanagui.cornichon.screen.interactions.Clickable;
import br.com.rkoyanagui.cornichon.screen.interactions.Visible;
import java.util.List;

public interface HeaderLike<H extends HeaderLike<H, C>, C> extends Visible<H>, Clickable<H> {

  List<C> getCells();

  C getCell(int column);
}
