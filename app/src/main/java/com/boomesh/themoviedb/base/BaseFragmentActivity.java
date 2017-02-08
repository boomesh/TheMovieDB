package com.boomesh.themoviedb.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.boomesh.themoviedb.R;

/**
 * Base class to manage a single fragment
 * <p>
 * Created by sumesh on 2/7/17.
 */

public abstract class BaseFragmentActivity extends AppCompatActivity {

    @Override
    public final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment_container);

        if (savedInstanceState == null) {
            BaseFragment fragment = getSingleFragmentInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_content, fragment, fragment.getFragmentTag())
                    .commit();
        }
    }

    @NonNull
    protected abstract BaseFragment getSingleFragmentInstance();
}
