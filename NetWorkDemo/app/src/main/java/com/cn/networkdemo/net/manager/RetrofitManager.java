package com.cn.networkdemo.net.manager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.LruCache;

import com.cn.networkdemo.application.MyApplication;
import com.cn.networkdemo.net.WAPI;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Description：请求管理类
 * Created on 2018/6/28 0028
 * Author : 郭
 */
public class RetrofitManager {
    public static final String TAG = RetrofitManager.class.getSimpleName();
    private static Retrofit mRetrofit;
    private static Context sContext;
    private static final int DEFAULT_TIMEOUT = 20;
    private ApiManager apiManager;
    private static LruCache<String, Context> mLruCache = new LruCache<>(5);
    private static class SingletonHolder {
        private static RetrofitManager INSTANCE = new RetrofitManager();
    }
    public static RetrofitManager getInstance() {
        if (sContext == null) {
            sContext = MyApplication.getInstance().getApplicationContext();
        }
//        mLruCache.put("")
        return SingletonHolder.INSTANCE;
    }
    private RetrofitManager() {
        // Log信息拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                //打印retrofit日志
                Log.e(TAG, "message --->" + message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //设置 Debug Log 模式
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                // 设置超时
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request.Builder requestBuilder = chain.request().newBuilder();
//                        if (Constant.TOKEN != null)
//                        requestBuilder.addHeader("tokentime", GlobeConfig.getRequestToekn());
                        Request build = requestBuilder.build();
                        return chain.proceed(build);
                    }
                });
        OkHttpClient okHttpClient = builder.build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(WAPI.API_SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }
    /**
     * create BaseApi  defalte ApiManager
     *
     * @return ApiManager
     */
    public ApiManager createApiManager() {
        return apiManager = create(ApiManager.class);
    }

    /**
     * create you ApiService
     */
    private <T> T create(final Class<T> service) {
        if (service == null) {
            throw new RuntimeException("Api service is null!");
        }
        return mRetrofit.create(service);
    }
}
