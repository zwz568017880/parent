package com.github.jartisan.parent.base.response;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.github.jartisan.parent.base.enums.GlobalCode;

/***
 * @description 反回结果类
 * @author wjl
 * @ClassName: RestResult
 * @Version 版本
 * @ModifiedBy jartisan
 * @Copyright com.github.jartisan
 * @date 2017年07月25日 下午7:28:23
 */
public class RestResult<T> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 全局响应码
	 */
	private final int code;
	/**
	 * 全局响应码说明
	 */
	private final String msg;
	/**
	 * 响应数据
	 */
	private final T data;


	public RestResult(T result) {
		this(GlobalCode.SUCCESS.getCode(),GlobalCode.SUCCESS.getMsg(),null);
	}
	
	
	public RestResult(int code, String msg) {
		
		this(code,msg,null);
	}


	public RestResult(int code, String msg, T data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public T getData() {
		return data;
	}
	
	public static <T> RestResult<T> ok() {
		RestResultBuilder builder = new RestResultBuilder();
		return builder.ok();
	}
	
	public static <T> RestResult<T> ok(T body) {
		RestResultBuilder builder = new RestResultBuilder();
		return builder.ok(body);
	}
	public static <T> RestResult<T> failure(int code ,String msg) {
		RestResultBuilder builder = new RestResultBuilder();
		return builder.failure(code,msg,null);
	}
	
	public static <T> RestResult<T> failure(int code ,String msg,T body) {
		RestResultBuilder builder = new RestResultBuilder();
		return builder.failure(code,msg,body);
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.JSON_STYLE);
	}
	
	public static class RestResultBuilder{
		
		public <T> RestResult<T> ok() {
			return ok(null);
		}

		public <T> RestResult<T> ok(T body) {
			return new RestResult<T>(GlobalCode.SUCCESS.getCode(),GlobalCode.SUCCESS.getMsg(),body);
		}
		
		public <T> RestResult<T> failure(int code ,String msg,T body) {
			return new RestResult<T>(GlobalCode.SUCCESS.getCode(),GlobalCode.SUCCESS.getMsg(),body);
		}
	}
}
