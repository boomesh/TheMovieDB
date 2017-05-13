package com.boomesh.data.api.base;

import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

import com.boomesh.themoviedb.R;

/**
 * Created by sumesh on 5/12/17.
 */


public class APIResponse<D> {
    @Nullable
    private final D data;

    @Nullable
    private final Error error;

    public APIResponse(D data) {
        this(data, null);
    }

    public APIResponse(Error error) {
        this(null, error);
    }

    public APIResponse(@Nullable D data, @Nullable Error error) {
        this.data = data;
        this.error = error;
    }

    @Nullable
    public D getData() {
        return data;
    }

    @Nullable
    public Error getError() {
        return error;
    }

    public boolean isSuccessful() {
        return error == null;
    }

    public enum Error {
        NO_NETWORK(R.string.network_error_no_network),
        TIMEOUT(R.string.network_error_timeout),
        UNKNOWN(R.string.network_error_unknown);

        @StringRes
        public final int message;

        Error(int message) {
            this.message = message;
        }
    }
}
