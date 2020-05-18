package br.com.rkoyanagui.cornichon.screen.interactions.tables;

import br.com.rkoyanagui.cornichon.screen.elements.Text;
import br.com.rkoyanagui.cornichon.screen.interactions.Clickable;
import java.util.List;

public interface HeaderLike<H extends HeaderLike<H>> extends Clickable<H> {

  List<Text> getCells();

  Text getCell(int column);
}
