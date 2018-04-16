package com.egeio.net.request;

import android.support.annotation.NonNull;

import com.egeio.net.JSONConvert;
import com.egeio.net.NetEngine;
import com.egeio.net.target.Target;

import java.util.List;

/**
 * Created by wangjinpeng on 2017/4/6.
 */

public class NetRequestArray<T> extends NetRequest<List<T>> {

    public NetRequestArray(@NonNull Target target) {
        super(target);
    }

    @Override
    protected List<T> formatResult(String result) {
        JSONConvert jsonConvertTmp;
        if (jsonConvert != null) {
            jsonConvertTmp = jsonConvert;
        } else {
            jsonConvertTmp = NetEngine.getDefaultJsonConvert();
        }
        //noinspection unchecked
        return (List<T>) jsonConvertTmp.parseArray(result, target.getResultClass());
    }
}
