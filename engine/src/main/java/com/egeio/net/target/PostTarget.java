package com.egeio.net.target;

import com.egeio.net.NetEngine;
import com.egeio.net.NetParams;
import com.egeio.net.NetUrl;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangjinpeng on 2017/4/1.
 */

public class PostTarget extends Target {

    @Override
    public String internalExecute() throws Exception {
        NetParams netParams = getNetParams();
        Map<String, Object> queryData = netParams.getQueryData();
        NetUrl netUrl = new NetUrl(netParams.getApiUrl());
        netUrl.addPath(netParams.getApi());
        for (Map.Entry<String, Object> entry : queryData.entrySet()) {
            netUrl.addQueryParam(entry.getKey(), entry.getValue());
        }

        String jsonBody = null;
        Set<NetParams.FormBody> formBodies = netParams.getFormBodies();
        Map<String, Object> postJsonBody = netParams.getPostJsonBody();
        if (postJsonBody == null) {
            postJsonBody = new HashMap<>();
        }
        Object postJsonObject = netParams.getPostJsonObject();
        if (postJsonObject != null) {
            String s = NetEngine.getDefaultJsonConvert().toString(postJsonObject);
            JSONObject jsonObject = new JSONObject(s);
            Iterator<String> keys = jsonObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                postJsonBody.put(next, jsonObject.get(next));
            }
        }
        if (!postJsonBody.isEmpty()) {
            jsonBody = new JSONObject(postJsonBody).toString();
        }

        return NetEngine.getRequestConvert().post(netUrl.toUrl(), jsonBody, formBodies, headers);
    }
}
