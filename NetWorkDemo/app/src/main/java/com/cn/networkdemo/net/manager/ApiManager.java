package com.cn.networkdemo.net.manager;
import com.cn.networkdemo.bean.UserBean;
import com.cn.networkdemo.net.WAPI;
import com.cn.networkdemo.net.base.BaseResponseBean;
import com.cn.networkdemo.request.ImaRequestBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
/**
 * Description：管理请求接口
 * Created on 2018/7/3
 * Author : 郭
 */
public interface ApiManager<T> {

    @POST(WAPI.UPDATE)
    Observable<BaseResponseBean<List<UserBean>>> update(@Body ImaRequestBean body);
}
