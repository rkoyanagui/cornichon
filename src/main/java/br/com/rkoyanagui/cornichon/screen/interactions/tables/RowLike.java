package br.com.rkoyanagui.cornichon.screen.interactions.tables;

import br.com.rkoyanagui.cornichon.screen.elements.Text;
import br.com.rkoyanagui.cornichon.screen.interactions.Clickable;
import java.util.List;

public interface RowLike<R extends RowLike<R>> extends Clickable<R> {

  List<Text> getCells();

  Text getCell(int column);
}
