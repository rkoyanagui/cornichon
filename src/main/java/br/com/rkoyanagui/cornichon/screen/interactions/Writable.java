package br.com.rkoyanagui.cornichon.screen.interactions;

import br.com.rkoyanagui.cornichon.screen.processors.writable.WritableProcessor;

public interface Writable<W extends Writable<W>> extends Readable<W>, Clickable<W> {

  default WritableProcessor getWritableProcessor() {
    return DefaultChains.WRITABLE_PROCESSOR_CHAIN;
  }

  default W write(String text) {
    getWritableProcessor().write(this, text);
    return (W) this;
  }

  default W write(String text, long pauseInMilli) {
    getWritableProcessor().write(this, text, pauseInMilli);
    return (W) this;
  }

  default W clear() {
    getWritableProcessor().clear(this);
    return (W) this;
  }

  default void submit() {
    getWritableProcessor().submit(this);
  }
}
