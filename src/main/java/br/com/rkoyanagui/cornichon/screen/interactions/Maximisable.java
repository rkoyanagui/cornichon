package br.com.rkoyanagui.cornichon.screen.interactions;

import br.com.rkoyanagui.cornichon.screen.processors.maximisable.MaximisableProcessor;

public interface Maximisable<M extends Maximisable<M>> extends Locatable {

  MaximisableProcessor getMaximisableProcessor();

  default M maximise() {
    getMaximisableProcessor().maximise(this);
    return (M) this;
  }
}
