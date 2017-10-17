package com.github.jartisan.parent.base.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/***
 * int 主键
 * @author  wjl
 * @date 2017/10/16
 */
public class AbstractIntegerEntity{
	


	/***
	 * 主键
	 */
	private Integer id;
	
	
	/***
	 *实体创建时间 
	 */
	private Date createDate = new Date();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
    public static<T extends AbstractIntegerEntity> List<Integer> entityIds(List<T> list){
        List<Integer> ids = Lists.transform(list, new Function<T, Integer>(){
        	   @Override
                public Integer apply(T entity){
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
    public static<V extends AbstractIntegerEntity> Map<Integer,V> entityMaps(List<V> list){
            Map<Integer,V> maps = Maps.uniqueIndex(list.iterator(),  new Function<V, Integer>() {
            @Override
            public Integer apply(V entity) {
                return entity.getId();
            }
        });
        return maps;
    }
}
