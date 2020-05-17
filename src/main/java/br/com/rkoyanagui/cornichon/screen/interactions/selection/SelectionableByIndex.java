package br.com.rkoyanagui.cornichon.screen.interactions.selection;

public interface SelectionableByIndex<S extends SelectionableByIndex<S>> {

  S select(int index);
}
