package io.github.mzanthem.util;

import org.springframework.data.domain.Sort;

/**
 * 排序工具类
 * http://blog.csdn.net/zhaoshuliok/article/details/70225348
 * 
 * @author mazan
 *
 */
public class SortUtils {

	private SortUtils() {
	}
	
	
	/**
	 * 默认排序
	 * @return
	 */
	public static Sort baseSort() {
		return baseSort("desc", "id");
	}
	
	/**
	 * 按照字段排序
	 * @param orderType
	 * @param orderField
	 * @return
	 */
	public static Sort baseSort(String orderType, String orderField) {
		Sort sort = new Sort(Sort.Direction.fromString(orderType), orderField);
		return sort;
	}
	
	/**
	 * 多属性排序
	 * @param dtos
	 * @return
	 */
	public static Sort basicSort(SortDto... dtos) {
	    Sort result = null;
	    for(int i=0; i<dtos.length; i++) {
	        SortDto dto = dtos[i];
	        Sort sort = baseSort(dto.getOrderType(), dto.getOrderField());
	        
	        if(result == null) {
	            result = sort;
	        } else {
	            result = result.and(sort);
	        }
	    }
	    return result;
	}
	
	
	
	
	/**
	 * 排序DTO
	 */
	public static class SortDto {

	    //排序方式
	    private String orderType;

	    //排序字段
	    private String orderField;

	    public String getOrderField() {
	        return orderField;
	    }

	    public void setOrderField(String orderField) {
	        this.orderField = orderField;
	    }

	    public String getOrderType() {
	        return orderType;
	    }

	    public void setOrderType(String orderType) {
	        this.orderType = orderType;
	    }

	    public SortDto(String orderType, String orderField) {
	        this.orderType = orderType;
	        this.orderField = orderField;
	    }

	    //默认为DESC排序
	    public SortDto(String orderField) {
	        this.orderField = orderField;
	        this.orderType = "desc";
	    }
	}
	
}
