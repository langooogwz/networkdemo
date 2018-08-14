package com.cn.networkdemo.base;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.cn.networkdemo.net.manager.ApiManager;
import com.cn.networkdemo.net.manager.RetrofitManager;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
/**
 * Description：
 * Created on 2018/8/14 0014
 * Author : 郭
 */
public class BaseActivity extends RxAppCompatActivity {
    public ApiManager apiManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiManager = RetrofitManager.getInstance().createApiManager();
    }

    //////////////////////网络//////////////////////
    /**
     * 线程调度
     */
    public <T> ObservableTransformer<T, T> compose(final LifecycleTransformer<T> lifecycle) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> observable) {
                return observable
                        .subscribeOn(Schedulers.io())
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(Disposable disposable) throws Exception {
                                // 可添加网络连接判断等
//                                if (!Utils.isNetworkAvailable(BaseActivity.this)) {
//                                    Toast.makeText(BaseActivity.this, R.string.toast_network_error, Toast.LENGTH_SHORT).show();
//                                }
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        .compose(lifecycle);
            }
        };
    }
}
