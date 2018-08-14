package com.cn.networkdemo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.cn.networkdemo.base.BaseActivity;
import com.cn.networkdemo.bean.UserBean;
import com.cn.networkdemo.net.manager.SubscriberManger;
import com.cn.networkdemo.request.ImaRequestBean;
import com.cn.networkdemo.utils.StringUtil;

import java.io.IOException;
import java.util.List;
public class MainActivity extends BaseActivity {
    private Button button;
    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        image = findViewById(R.id.image);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestLogin();
            }
        });
    }
    /**
     * 请求登录
     */
    private void requestLogin() {
        ImaRequestBean requestBean = new ImaRequestBean(1);
        apiManager.update(requestBean).compose(compose(this.<List<UserBean>>bindToLifecycle())).subscribe(new SubscriberManger<List<UserBean>>(this, true) {
            @Override
            public void onSuccess(List<UserBean> result, String msg) throws IOException {
                showImageView(result);
            }
            @Override
            public void onFailure(String errorMsg, int code) throws IOException {
            }
        });
    }
    private void showImageView(List<UserBean> result) {
        Glide.with(this).load(StringUtil.StrTrim(result.get(0).getImg())).into(image);
    }
}
