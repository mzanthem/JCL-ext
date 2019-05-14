package io.github.mzanthem.util;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * 翻页工具类
 * @author MSH8244
 *
 */
public class PageUtils {
	public static Pageable page(Integer page, Integer size,Sort sort) {
		if (null == page || "".equals(page)) {
			page = 1;
		}
		if (null == size || "".equals(size)) {
			size = 10;
		}
		return new PageRequest(page, size,sort);
	}
	
	
	//-----------------------------------//
	/**
	 * 翻页，无排序
	 * @param page
	 * @param size
	 * @param sort
	 * @return
	 */
	public static Pageable build(Integer page, Integer size) {
		return new PageRequest(page, size);
	}
	/**
	 * 翻页，单排序降序
	 * @param page
	 * @param size
	 * @param sort
	 * @return
	 */
	public static Pageable build(Integer page, Integer size, String orderField) {
		return build(page, size, orderField, false);
	}
	
	/**
	 * 
	 * @param page
	 * @param size
	 * @param orderField
	 * @param isASC
	 * @return
	 */
	public static Pageable build(Integer page, Integer size, String orderField, boolean isASC) {
		String orderType = isASC ? "asc" : "desc";
		return page(page, size, SortUtils.baseSort(orderType, orderField));
	}
}
