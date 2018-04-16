// Generated by delombok at Tue Nov 14 18:34:13 CST 2017
package com.egeio.net.target;

import android.support.annotation.CallSuper;

import com.egeio.network.Header;
import com.egeio.net.NetParams;
import com.egeio.net.request.NetRequest;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wangjinpeng on 2016/11/24.
 */
public abstract class Target {
    protected Set<Header> headers = new HashSet<>();
    private NetParams netParams;

    @CallSuper
    public Target header(String key, String value) {
        headers.add(new Header(key, value));
        return this;
    }

    @CallSuper
    public <T> NetRequest<T> param(NetParams<T> netParams) {
        this.netParams = netParams;
        return new NetRequest<>(this);
    }

    public abstract String internalExecute() throws Exception;

    public Class<?> getResultClass() {
        return netParams.getResultType();
    }

    NetParams getNetParams() {
        return this.netParams;
    }
}