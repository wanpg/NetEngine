package com.egeio.net.target;

import com.egeio.net.NetCallBack;

/**
 * Created by wangjinpeng on 2017/12/12.
 */

public class SimpleNetCallBack<T> implements NetCallBack<T> {
    @Override
    public void onFinished(T t) {

    }

    @Override
    public void onFailed(Exception e) {

    }
}
