package com.github.jartisan.parent.base.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/***
 * long 主键 bigInt
 * @author  wjl
 * @date 2017/10/16
 */
public class AbstractLongEntity{
	


	/***
	 * 主键
	 */
	private Long id;
	
	
	/***
	 *实体创建时间 
	 */
	private Date createDate = new Date();
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
    public static<T extends AbstractLongEntity> List<Long> entityIds(List<T> list){
        List<Long> ids = Lists.transform(list, new Function<T, Long>(){
        		@Override
                public Long apply(T entity){
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
    public static<V extends AbstractLongEntity> Map<Long,V> entityMaps(List<V> list){
            Map<Long,V> maps = Maps.uniqueIndex(list.iterator(),  new Function<V, Long>() {
            @Override
            public Long apply(V entity) {
                return entity.getId();
            }
        });
        return maps;
    }
}
