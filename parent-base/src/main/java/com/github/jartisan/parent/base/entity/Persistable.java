package com.github.jartisan.parent.base.entity;

import java.io.Serializable;

/***
 * 持久化
 * @author  wjl
 * @date 2017/10/16
 */
public interface Persistable <ID extends Serializable> extends Serializable{
	
	/***
	 * getId
	 * @return
	 */
	ID getId();
}
