package br.com.rkoyanagui.cornichon.screen.interactions.selection;

import br.com.rkoyanagui.cornichon.screen.interactions.Clickable;
import br.com.rkoyanagui.cornichon.screen.interactions.Readable;
import br.com.rkoyanagui.cornichon.screen.interactions.Sizable;
import br.com.rkoyanagui.cornichon.screen.interactions.Visible;

public interface SingleChoicer<S extends SingleChoicer<S, C>, C extends Visible<C> & Readable<C>> extends
    Visible<S>, Clickable<S>, Sizable {

}
