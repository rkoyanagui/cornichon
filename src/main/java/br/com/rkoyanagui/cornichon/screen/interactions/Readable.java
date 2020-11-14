package br.com.rkoyanagui.cornichon.screen.interactions;

import br.com.rkoyanagui.cornichon.screen.processors.readable.ReadableProcessor;

public interface Readable<R extends Readable<R>> extends Clickable<R>, Sizeable {

  default ReadableProcessor getReadableProcessor() {
    return DefaultChains.READABLE_PROCESSOR_CHAIN;
  }

  default String read() {
    return getReadableProcessor().read(this);
  }

  @Override
  default int size() {
    return read().length();
  }
}
