package com.boomesh.domain.base;

public interface Presentable<V extends Viewable> {
    void set(V viewable);
}
