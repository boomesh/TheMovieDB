package com.boomesh.domain.base;

public class BasePresenter<V extends Viewable> {
    private V view;

    public void attach(V viewable) {
        view = viewable;
    }

    protected final V getView() {
        return view;
    }
}
