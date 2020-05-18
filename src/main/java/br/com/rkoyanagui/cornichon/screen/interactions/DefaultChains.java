package br.com.rkoyanagui.cornichon.screen.interactions;

import br.com.rkoyanagui.cornichon.screen.processors.clickable.ClickableProcessor;
import br.com.rkoyanagui.cornichon.screen.processors.closeable_window.CloseableWindowProcessor;
import br.com.rkoyanagui.cornichon.screen.processors.has_title.PageTitleProcessor;
import br.com.rkoyanagui.cornichon.screen.processors.loadable.LoadableProcessor;
import br.com.rkoyanagui.cornichon.screen.processors.maximisable.MaximisableProcessor;
import br.com.rkoyanagui.cornichon.screen.processors.readable.ReadableProcessor;
import br.com.rkoyanagui.cornichon.screen.processors.visible.VisibleProcessor;
import br.com.rkoyanagui.cornichon.screen.processors.writable.WritableProcessor;

final class DefaultChains {

  static final ClickableProcessor CLICKABLE_PROCESSOR_CHAIN = ClickableProcessor.getChain();
  static final CloseableWindowProcessor CLOSEABLE_WINDOW_PROCESSOR_CHAIN =
      CloseableWindowProcessor.getChain();
  static final PageTitleProcessor PAGE_TITLE_PROCESSOR_CHAIN = PageTitleProcessor.getChain();
  static final LoadableProcessor LOADABLE_PROCESSOR_CHAIN = LoadableProcessor.getChain();
  static final MaximisableProcessor MAXIMISABLE_PROCESSOR_CHAIN = MaximisableProcessor.getChain();
  static final ReadableProcessor READABLE_PROCESSOR_CHAIN = ReadableProcessor.getChain();
  static final VisibleProcessor VISIBLE_PROCESSOR_CHAIN = VisibleProcessor.getChain();
  static final WritableProcessor WRITABLE_PROCESSOR_CHAIN = WritableProcessor.getChain();

  private DefaultChains() {
  }
}
