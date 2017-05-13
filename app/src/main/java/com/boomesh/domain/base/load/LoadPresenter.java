package com.boomesh.domain.base.load;

import android.annotation.SuppressLint;

import com.boomesh.data.api.base.APIResponse;
import com.boomesh.domain.base.message.MessageViewable;
import com.boomesh.domain.base.Presenter;

import io.reactivex.Single;

/**
 * Presenters making network requests can utilize this contract and wrap their requests with
 * loading handling.
 * <p>
 * Created by sumesh on 5/12/17.
 */

public interface LoadPresenter<V extends LoadViewable & MessageViewable> extends Presenter<V> {

    @SuppressLint("NewApi")
    default <BODY extends APIResponse> Single<BODY> loadWith(Single<BODY> apiRequestSingle) {
        return
                apiRequestSingle.doOnSubscribe(disposable -> {
                    getView().showLoading(true);
                }).doFinally(() -> {
                    getView().showLoading(false);
                }).doOnSuccess(body -> {
                    APIResponse.Error error = body.getError();
                    if (body.isSuccessful() || error == null) {
                        return;
                    }

                    getView().showMessage(error.message);
                });
    }
}
