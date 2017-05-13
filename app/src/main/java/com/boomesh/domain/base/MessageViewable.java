package com.boomesh.domain.base;

import android.support.annotation.StringRes;

/**
 * {@link LoadPresenter} requires this to communicate errors to the {@link Viewable}
 * <p>
 * Created by sumesh on 5/12/17.
 */

public interface MessageViewable extends Viewable {
    void showMessage(@StringRes int stringResID);
}
