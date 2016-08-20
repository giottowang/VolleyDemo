package com.example.volleydemo;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.android.volley.Request.Method;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//volley_Get();
		volley_Post();
	}
	
	
	@Override
	protected void onStop()
	{
		super.onStop();
		MyApplication.getHttpQueues().cancelAll("testPost");;
	}
//	private void volley_Post()
//	{
//		String url = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm";
//		StringRequest request = new StringRequest(Method.POST, url, new Listener<String>()
//		{
//
//			@Override
//			public void onResponse(String response)
//			{
//				// TODO Auto-generated method stub
//				Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
//			}
//		}, new ErrorListener()
//		{
//
//			@Override
//			public void onErrorResponse(VolleyError error)
//			{
//				// TODO Auto-generated method stub
//				Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
//			}
//		}){
//			@Override
//			protected Map<String, String> getParams() throws AuthFailureError
//			{
//				Map<String,String> map = new HashMap<String, String>();
//				map.put("tel","15850781443");
//				return map;
//			}
//		};
//		request.setTag("abcPOST");
//		MyApplication.getHttpQueues().add(request);
//	}
	
	private void volley_Post() {
	    String url = "http://www.kuaidi100.com/query";
	    Map<String,String> map = new HashMap<String, String>();
	    map.put("type","yuantong");
	    map.put("postid","229728279823");
	    //��mapת��ΪJSONObject����
	    JSONObject jsonObject = new JSONObject(map);

	    JsonObjectRequest request = new JsonObjectRequest(Method.POST, url, jsonObject,
	            new Listener<JSONObject>() {
	                @Override
	                public void onResponse(JSONObject jsonObject) {//jsonObjectΪ���󷵻ص�Json��ʽ����
	                    Toast.makeText(MainActivity.this,jsonObject.toString(),Toast.LENGTH_LONG).show();
	                }
	            },
	            new ErrorListener() {
	                @Override
	                public void onErrorResponse(VolleyError volleyError) {
	                    Toast.makeText(MainActivity.this,volleyError.toString(),Toast.LENGTH_LONG).show();
	                }
	            });
	    //���������Tag��ǩ��������ȫ�����������ͨ��Tag��ǩ��������Ĳ���
	    request.setTag("testPost");
	    //���������ȫ�ֶ�����
	    MyApplication.getHttpQueues().add(request);
	}

	private void volley_Get()
	{
//		String url = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=15850781443";
		
//		StringRequest request = new StringRequest(Method.GET, url, new Listener<String>()
//		{
//
//			@Override
//			public void onResponse(String response)
//			{
//				Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
//				
//			}
//		}, new Response.ErrorListener()
//		{
//
//			@Override
//			public void onErrorResponse(VolleyError error)
//			{
//				Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
//			}
//		});
//		request.setTag("abcGet");
//		MyApplication.getHttpQueues().add(request);
		String url = "http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip=218.4.255.255";
		JsonObjectRequest request = new JsonObjectRequest(Method.GET, url, null, new Listener<JSONObject>()
		{

			@Override
			public void onResponse(JSONObject response)
			{
				Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
			}
		}, new Response.ErrorListener()
		{

			@Override
			public void onErrorResponse(VolleyError error)
			{
				Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
			}
		});
		request.setTag("testGet");
		MyApplication.getHttpQueues().add(request);
	}
	
}
