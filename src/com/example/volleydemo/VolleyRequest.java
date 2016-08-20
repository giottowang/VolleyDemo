package com.example.volleydemo;

import java.util.Map;

import com.android.volley.Request.Method;
import com.android.volley.toolbox.StringRequest;

import android.content.Context;

public class VolleyRequest
{
	public static StringRequest stringRequest;
	public static Context context;
	public static void RequestGet(Context mContext,String url,String tag,VolleyInterface vif)
	{
		MyApplication.getHttpQueues().cancelAll(tag);
		stringRequest = new StringRequest(Method.GET, url, vif.loadingListener(), vif.errorListener());
		stringRequest.setTag(tag);
		MyApplication.getHttpQueues().add(stringRequest);
		MyApplication.getHttpQueues().start();
		
	}
	public static void RequestPost(Context mContext,String url,String tag,Map<String,String> params,VolleyInterface vif)
	{
		MyApplication.getHttpQueues().cancelAll(tag);
		stringRequest = new StringRequest(url,vif.loadingListener(),vif.errorListener());
	}
}
