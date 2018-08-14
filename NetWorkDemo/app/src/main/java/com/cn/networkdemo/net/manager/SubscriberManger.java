package com.cn.networkdemo.net.manager;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.cn.networkdemo.net.base.BaseResponseBean;
import com.cn.networkdemo.net.loading.ConnectDialog;
import com.cn.networkdemo.utils.StringUtil;

import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;
/**
 * Description：封装loading
 * Created on 2018/6/28 0028
 * Author : 郭
 */
public abstract class SubscriberManger<T> implements Observer<BaseResponseBean<T>> {

    private static final String TAG = SubscriberManger.class.getSimpleName();
    private final Activity context;
    private final boolean isShowDialog;
    private ConnectDialog loadDialog = ConnectDialog.getInstanceDialog();

    public SubscriberManger(Activity context) {
        this(context, true);
    }

    public SubscriberManger(Activity context, boolean isShowDialog) {
        this.context = context;
        this.isShowDialog = isShowDialog;
    }
    @Override
    public void onSubscribe(Disposable d) {
//        if (!NetworkUtils.isNetworkConnected(context)) {
//            onError(new ConnectException());
//        }
        if (isShowDialog) {

            loadDialog.showDialog(context);
        }
    }

    @Override
    public void onNext(BaseResponseBean<T> t) {
        //1  代表成功
        if (Integer.valueOf(t.getCode()) == 1){
            try {
                onSuccess(t.getResult(), StringUtil.StrTrim(t.getMessage()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else { //服务器返回错误码
            if(!TextUtils.isEmpty(t.getMessage())){
                try {
                    onFailure(t.getMessage(),StringUtil.StrTrimInt(t.getCode()));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                Toast.makeText(context,t.getMessage(),Toast.LENGTH_LONG).show();;
            }else{
                onError(new RuntimeException());
            }
        }
    }

    public abstract void onSuccess(T result,String msg)throws IOException ;
    public abstract void onFailure(String errorMsg,int code) throws IOException;

    @Override
    public void onError(Throwable e) {
        if (e instanceof HttpException || e instanceof ConnectException|| e instanceof UnknownHostException) {
            Log.e("网络错误===",e.getMessage());
            Toast.makeText(context,"网络异常",Toast.LENGTH_SHORT).show();
        } else {
            String message = e.getMessage();
            if("timeout".equals(message)) {
                message ="超时";
            }
            Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
        }
        if (loadDialog != null && loadDialog.isShow()) {
            loadDialog.dismissDialog(context);
        }
    }

    @Override
    public void onComplete() {
        if (loadDialog != null && loadDialog.isShow()) {
            loadDialog.dismissDialog(context);
        }
    }

}
