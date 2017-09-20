package com.github.jartisan.parent.base.response;

import java.util.HashMap;

import com.github.jartisan.parent.base.enums.GlobalCode;

/***
 * @description 反回结果类
 * @author wjl
 * @ClassName: APIResult
 * @Version 版本
 * @ModifiedBy jartisan
 * @Copyright com.github.jartisan
 * @date 2017年07月25日 下午7:28:23
 */
public class APIResult extends HashMap<String, Object>  {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 执行成功
	 */
	public static final int SUCCESS = GlobalCode.SUCCESS.getCode();

	public APIResult() {
	}

	public APIResult(Object result) {
		setCode(APIResult.SUCCESS);
		setMessage(GlobalCode.SUCCESS.getMsg());
		setData(result);
	}
	public APIResult success() {  
		setCode(APIResult.SUCCESS);
		setMessage(GlobalCode.SUCCESS.getMsg());
        return this;  
    }  
  
    public APIResult success(Object data) {  
    	setCode(APIResult.SUCCESS);
    	setMessage(GlobalCode.SUCCESS.getMsg());
		setData(data);
        return this;  
    }  
  
    public APIResult failure(int code,String message) {  
		setMessage(message);
		setCode(code);
        return this;  
    }  

	
	public int getCode() {
		return Integer.parseInt(String.valueOf(this.get("code")));
	}

	public void setCode(int code) {
		this.put("code", String.valueOf(code));
	}
	
	public String getMessage() {
		return (String) this.get("msg");
	}

	public void setMessage(String message) {
		this.put("msg", message);
	}

	public Object getData() {
		return this.get("data");
	}

	public void setData(Object data) {
		this.put("data", data);
	}
	
}
