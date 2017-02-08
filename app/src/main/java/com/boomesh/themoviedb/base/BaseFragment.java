package com.boomesh.themoviedb.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * All fragments inherit from this
 * <p>
 * Created by sumesh on 2/7/17.
 */

public abstract class BaseFragment extends Fragment {

    //region Life Cycle
    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getFragmentContentLayout(), container, false);
    }
    //endregion

    @NonNull
    protected abstract String getFragmentTag();

    @LayoutRes
    protected abstract int getFragmentContentLayout();
}
