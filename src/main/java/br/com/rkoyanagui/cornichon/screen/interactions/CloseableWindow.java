package br.com.rkoyanagui.cornichon.screen.interactions;

import br.com.rkoyanagui.cornichon.screen.processors.closeable_window.CloseableWindowProcessor;

public interface CloseableWindow extends Locatable {

  default CloseableWindowProcessor getCloseableWindowProcessor() {
    return DefaultChains.CLOSEABLE_WINDOW_PROCESSOR_CHAIN;
  }

  default void closeWindow() {
    getCloseableWindowProcessor().closeWindow(this);
  }
}
