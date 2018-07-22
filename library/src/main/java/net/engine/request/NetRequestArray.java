package net.engine.request;

import android.support.annotation.NonNull;

import net.engine.JSONConvert;
import net.engine.NetEngine;
import net.engine.target.Target;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

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

    @Override
    public Observable<List<T>> observable() {
        return Observable.create(new ObservableOnSubscribe<List<T>>() {
            @Override
            public void subscribe(ObservableEmitter<List<T>> emitter) {
                try {
                    List<T> result = execute();
                    emitter.onNext(result);
                } catch (Throwable e) {
                    if (e instanceof Exception) {
                        emitter.onError(e);
                    } else {
                        emitter.onError(new Exception(e));
                    }
                } finally {
                    emitter.onComplete();
                }
            }
        }).subscribeOn(Schedulers.from(NetEngine.getExecutor()));
    }
}
