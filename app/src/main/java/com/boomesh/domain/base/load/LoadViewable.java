package com.boomesh.domain.base.load;

import com.boomesh.domain.base.Viewable;

/**
 * View that handle loading must implement this contract, as accompanying {@link LoadPresenter}
 * requires this
 *
 * Created by sumesh on 5/9/17.
 */

public interface LoadViewable extends Viewable {
    void showLoading(boolean isLoading);
}
