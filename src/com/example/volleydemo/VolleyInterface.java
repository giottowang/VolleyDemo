package com.example.volleydemo;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;

import android.content.Context;

public abstract class VolleyInterface
{
	public Context mContext;
	public Listener<String> mListener;
	public ErrorListener mErrorListener;
	
	public abstract void onMySucess(String result);
	public abstract void onMyError(VolleyError error);
	
	public VolleyInterface(Context context,Listener<String> listener,ErrorListener errorListener)
	{
		this.mContext = context;
		this.mErrorListener = errorListener;
		this.mListener = listener;
	}
	
	public Listener<String> loadingListener()
	{
		mListener = new Listener<String>()
				{

					@Override
					public void onResponse(String response)
					{
						// TODO Auto-generated method stub
						onMySucess(response);
					}
			
				};
				return mListener;
	}
	
	public ErrorListener errorListener()
	{
		mErrorListener = new ErrorListener()
				{

					@Override
					public void onErrorResponse(VolleyError error)
					{
						onMyError(error);
					}
			
				};
				return mErrorListener;
	}
	
	
}
