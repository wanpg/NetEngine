package com.egeio.network;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import net.engine.NetEngine;
import net.engine.NetParams;
import net.engine.request.NetRequestArray;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NetEngine.request(
                NetParams.builder()
                        .baseUrl("http://www.baidu.com")
                        .noVersion()
                        .api("")
                        .get()
                        .result(String.class)
                        .asArray()
                        .build())
                .observable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        NetRequestArray<String> stringNetRequestArray = NetEngine.request(
                NetParams.builder()
                        .baseUrl("http://www.baidu.com")
                        .noVersion()
                        .api("")
                        .get()
                        .result(String.class)
                        .build())
                .asArray();
        stringNetRequestArray
                .observable()
                .subscribe(new Consumer<List<String>>() {
                    @Override
                    public void accept(List<String> strings) throws Exception {

                    }
                });
    }
}
