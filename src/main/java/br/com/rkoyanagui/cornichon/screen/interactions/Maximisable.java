package br.com.rkoyanagui.cornichon.screen.interactions;

import br.com.rkoyanagui.cornichon.screen.processors.maximisable.MaximisableProcessor;

public interface Maximisable<M extends Maximisable<M>> extends Locatable {

  default MaximisableProcessor getMaximisableProcessor() {
    return DefaultChains.MAXIMISABLE_PROCESSOR_CHAIN;
  }

  default M maximise() {
    getMaximisableProcessor().maximise(this);
    return (M) this;
  }
}
