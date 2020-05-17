package br.com.rkoyanagui.cornichon.screen.interactions;

import br.com.rkoyanagui.cornichon.screen.processors.closeable_window.CloseableWindowProcessor;

public interface CloseableWindow extends Locatable {

  CloseableWindowProcessor getCloseableWindowProcessor();

  default void closeWindow() {
    getCloseableWindowProcessor().closeWindow(this);
  }
}
