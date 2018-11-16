package com.zzlh.data.util;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzlh.data.domain.ResponseEntity;
/**
 * @Description http工具类
 * @author liulei
 * @date 2018年10月22日 下午5:38:53
 */
public class HttpUtil {

	/**
	 * @Description 发送http get请求
	 * @param path 请求路径
	 * @return
	 */
	public static ResponseEntity doGet(String path) {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		RequestConfig config = RequestConfig.custom().setConnectTimeout(60000).setConnectionRequestTimeout(60000)
				.setSocketTimeout(60000).build();

		HttpGet httpGet = new HttpGet(path);
		httpGet.setConfig(config);
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(httpGet);
			// 获取响应实体
			HttpEntity httpEntity = response.getEntity();
			if (httpEntity != null) {
				ObjectMapper mapper = new ObjectMapper();
				return mapper.readValue(EntityUtils.toString(httpEntity, "UTF-8"), ResponseEntity.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static ResponseEntity<BigInteger> httpPost(String url,Object obj){
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		CloseableHttpResponse response = null;
		try{
	        HttpPost post = new HttpPost(url);
//	        ObjectMapper json = new ObjectMapper();
	        ObjectMapper mapper = new ObjectMapper();
	    	StringEntity entiry = new StringEntity(mapper.writeValueAsString(obj));
	    	entiry.setContentEncoding("UTF-8");
	    	entiry.setContentType("application/json");
	    	post.setEntity(entiry);
        	response = httpClient.execute(post);
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            	HttpEntity httpEntity = response.getEntity();
				return mapper.readValue(EntityUtils.toString(httpEntity, "UTF-8"), ResponseEntity.class);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
            	response.close();
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}