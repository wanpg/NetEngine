package net.engine.target;

import net.engine.NetEngine;
import net.engine.NetParams;
import net.engine.NetUrl;

import java.util.Map;

/**
 * Created by wangjinpeng on 2017/4/1.
 */

public class GetTarget extends Target {

    @Override
    public String internalExecute() throws Exception {
        NetParams netParams = getNetParams();
        Map<String, Object> queryData = netParams.getQueryData();
        NetUrl netUrl = new NetUrl(netParams.getApiUrl());
        netUrl.addPath(netParams.getApi());
        for (Map.Entry<String, Object> entry : queryData.entrySet()) {
            netUrl.addQueryParam(entry.getKey(), entry.getValue());
        }
        return NetEngine.getRequestConvert().get(netUrl.toUrl(), headers);
    }
}
