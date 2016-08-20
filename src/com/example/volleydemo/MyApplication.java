package com.example.volleydemo;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import android.app.Application;
/*
 * 建立了一个全局的请求队列
 */
public class MyApplication extends Application
{
	public static RequestQueue queues;
	
	@Override
	public void onCreate()
	{
		super.onCreate();
		queues=Volley.newRequestQueue(getApplicationContext());
		
	}
	public static RequestQueue getHttpQueues()
	{
		return queues;
	}
}
