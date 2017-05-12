package com.boomesh.themoviedb.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boomesh.domain.base.BasePresenter;
import com.boomesh.domain.base.Viewable;

/**
 * All fragments inherit from this
 * <p>
 * Created by sumesh on 2/7/17.
 */

public abstract class BaseFragment<V extends Viewable, P extends BasePresenter<V>>
        extends Fragment implements Viewable{

    private P presenter;

    //region Life Cycle
    @Nullable
    @Override
    public final View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        presenter = createPresenter();
        return inflater.inflate(getFragmentContentLayout(), container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().attach((V) this);
    }

    //endregion

    //region presenter get/set
    @NonNull
    protected abstract P createPresenter();

    @NonNull
    protected final P getPresenter() {
        return presenter;
    }
    //endregion

    @NonNull
    protected abstract String getFragmentTag();

    @LayoutRes
    protected abstract int getFragmentContentLayout();
}
