package com.boomesh.themoviedb.base;

public interface Presentable<V extends Viewable> {
    void set(V viewable);
}
