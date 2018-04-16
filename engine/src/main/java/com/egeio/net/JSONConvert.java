package com.egeio.net;

import java.util.List;

public interface JSONConvert {

    <T> T parse(String json, Class<T> tClass);

    <T> List<T> parseArray(String json, Class<T> tClass);

    String toString(Object o);
}
