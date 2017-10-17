package com.github.jartisan.parent.base.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

/***
 * 
 * @author  wjl
 * @date 2017/10/16
 */
public class AbstractPersistable <PK extends Serializable> implements Persistable<PK> {

	private static final long serialVersionUID = 1L;
	
	private PK id;
	
	
	/***
	 *实体创建时间
	 *@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") 
	 */
	private Date createDate = new Date();
	@Override
	public PK getId() {
		return id;
	}

	protected void setId(final PK id) {
		this.id = id;
	}

	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
