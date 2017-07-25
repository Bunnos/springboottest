package com.boot.utils;


import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class HttpHelper {
	private static CloseableHttpClient httpclient = null;
	
	static{
		httpclient = HttpClients.createDefault();
	}
	
	public static boolean post(String reqUrl, Map<String, Object> paramMap){
		boolean ret = false;

		CloseableHttpResponse response = null;
		try {

			HttpPost httpPost = new HttpPost(reqUrl);
			List<NameValuePair> parameters = new ArrayList<>();

			if(paramMap != null) {				//设置参数
				for(Map.Entry<String, Object> entry : paramMap.entrySet()) {
					parameters.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
				}
			}

			HttpEntity entity = new UrlEncodedFormEntity(parameters);
			httpPost.setEntity(entity);
			
			response = httpclient.execute(httpPost);
			
			if(response.getStatusLine().getStatusCode() == 200){

				ret = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(response != null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return ret;
	}
}

