package com.boomesh.domain.base.message;

import android.support.annotation.StringRes;

import com.boomesh.domain.base.Viewable;
import com.boomesh.domain.base.load.LoadPresenter;

/**
 * {@link LoadPresenter} requires this to communicate errors to the {@link Viewable}
 * <p>
 * Created by sumesh on 5/12/17.
 */

public interface MessageViewable extends Viewable {
    void showMessage(@StringRes int stringResID);
}
