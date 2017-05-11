package com.boomesh.domain.base;

import com.boomesh.data.api.API;

import io.reactivex.Single;

/**
 * General class for handling use cases in a rx way
 * <p>
 * Created by sumesh on 2/19/17.
 */

public abstract class UseCase<T> {

    protected abstract Single<T> buildCase(API api);
}
