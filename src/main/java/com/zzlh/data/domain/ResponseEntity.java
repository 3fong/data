package com.zzlh.data.domain;

/**
 * @Description 响应体
 * @author liulei
 * @date 2018年10月21日 下午6:00:53
 */
public class ResponseEntity<T> {

	// 响应状态码
	private Integer code;

	// 响应消息
	private String message;

	// 响应数据
	private T data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
