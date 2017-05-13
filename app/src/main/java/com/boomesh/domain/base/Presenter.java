package com.boomesh.domain.base;

/**
 * Presenters must implement the following methods.
 * <p>
 * Created by sumesh on 5/12/17.
 */

public interface Presenter<V extends Viewable> {
    void attach(V viewable);

    V getView();
}
