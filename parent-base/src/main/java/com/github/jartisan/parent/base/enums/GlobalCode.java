package com.github.jartisan.parent.base.enums;

/***
 * @description 全局响应码
 * @author wjl
 * @ClassName: GlobalCode
 * @Version 版本
 * @ModifiedBy jartisan
 * @Copyright com.github.jartisan
 * @date 2017年07月25日 下午7:28:23
 * 其中 10000 和 99999 为固定响应码
 * 响应码为5位数字组成
 */
public enum GlobalCode {
	    //通用响应码
	    SUCCESS(10000, "ok"),
	    ERROR(99999, "system error"),
	    ERROR_190001(190001, "authorization token is error !"),
	    ERROR_190002(190002, "参数校验失败 !"),
	    
	    ERROR_21001(21001, "手机号或密码错误");
	
	    private int code;
	    private String msg;
	    
		private GlobalCode(int code, String msg) {
			this.code = code;
			this.msg = msg;
		}
	    
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
}
