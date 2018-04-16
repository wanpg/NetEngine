package com.egeio.net;

import java.util.Set;

public interface RequestConvert {
    String get(String url, Set<Header> headers) throws Exception;

    String post(String url, String jsonBody, Set<NetParams.FormBody> formBodies, Set<Header> headers) throws Exception;
}
