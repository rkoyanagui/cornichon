package br.com.rkoyanagui.cornichon.screen.interactions.selection;

public interface SelectionableByName<S extends SelectionableByName<S>> {

  S select(String name);
}
