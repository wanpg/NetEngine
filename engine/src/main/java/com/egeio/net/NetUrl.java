package com.egeio.net;

import android.net.Uri;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangjinpeng on 2017/9/13.
 */

public class NetUrl {

    private String scheme;

    private String host;

    /**
     * 1到65535
     */
    private int port = -1;
    private final List<String> pathList = new ArrayList<>();
    private final Map<String, Object> queryParams = new LinkedHashMap<>();

    public NetUrl() {
    }

    public NetUrl(String url) {
//        [scheme:]scheme-specific-part[#fragment]
//        [scheme:][//authority][path][?query][#fragment]
//        [scheme:][//host:port][path][?query][#fragment]
        Uri uri = Uri.parse(url);
        scheme = uri.getScheme();
        host = uri.getHost();
        port = uri.getPort();
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments != null) {
            pathList.addAll(pathSegments);
        }
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        if (queryParameterNames != null) {
            for (String key : queryParameterNames) {
                String queryParameter = uri.getQueryParameter(key);
                queryParams.put(key, queryParameter);
            }
        }
    }

    public NetUrl addPath(Object pathValue) {
        String pathStringValue = String.valueOf(pathValue);
        if(pathStringValue.contains("/")){
            String[] strings = pathStringValue.split("/");
            for(String path : strings){
                if(!TextUtils.isEmpty(path)){
                    pathList.add(path);
                }
            }
        }else {
            pathList.add(String.valueOf(pathValue));
        }
        return this;
    }

    public NetUrl addQueryParam(String key, Object param) {
        queryParams.put(key, param);
        return this;
    }

    public String toUrl() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(scheme)
                .append("://")
                .append(host);
        if (port > 0) {
            stringBuilder.append(":")
                    .append(port);
        }

        for (String path : pathList) {
            stringBuilder.append("/");
            stringBuilder.append(path);
        }

        if (!queryParams.isEmpty()) {
            stringBuilder.append("?");
            boolean isFirst = true;
            for (Map.Entry<String, Object> entry : queryParams.entrySet()) {
                if(!isFirst){
                    stringBuilder.append("&");
                }
                stringBuilder.append(entry.getKey())
                        .append("=")
                        .append(entry.getValue());
                isFirst = false;
            }
        }
        return stringBuilder.toString();
    }
}
