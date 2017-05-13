package com.boomesh.domain.base;

public abstract class BasePresenter<V extends Viewable> implements Presenter<V> {
    private V view;

    protected void onAttach(V viewable){};

    //<editor-fold desc="Presenter">
    @Override
    public final void attach(V viewable) {
        view = viewable;
        onAttach(viewable);
    }

    @Override
    public final V getView() {
        return view;
    }
    //</editor-fold>
}
