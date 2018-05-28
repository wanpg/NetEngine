package net.engine;

/**
 * Created by wangjinpeng on 2017/4/1.
 */

public interface NetCallBack<T> {

    void onFinished(T t);

    void onFailed(Exception e);
}
