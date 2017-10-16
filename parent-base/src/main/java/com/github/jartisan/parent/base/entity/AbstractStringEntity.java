package com.github.jartisan.parent.base.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/***
 * UUID主键
 * @author wjl
 * @date 2017/10/16
 */
public class AbstractStringEntity{
	
	/***
	 * 主键
	 */
	private String id;
	
	
	/***
	 *实体创建时间 
	 */
	private Date createDate = new Date();
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
	 /**
     * 获取表记录集合的Id集合
     * @param list
     * @return
     */
    public static<T extends AbstractStringEntity> List<String> entityIds(List<T> list){
        List<String> ids = Lists.transform(list, new Function<T, String>(){
                public String apply(T entity){
                return entity.getId();
                }
                }); 
        return ids;
    }
    /**
     * 根据实体记录，输出Map<Long id,K extend BaseEntity>集合
     * @param list
     * @return
     */
    public static<V extends AbstractStringEntity> Map<String,V> entityMaps(List<V> list){
            Map<String,V> maps = Maps.uniqueIndex(list.iterator(),  new Function<V, String>() {
            @Override
            public String apply(V entity) {
                return entity.getId();
            }
        });
        return maps;
    }
}
