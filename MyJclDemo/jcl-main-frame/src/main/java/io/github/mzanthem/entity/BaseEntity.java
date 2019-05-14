package io.github.mzanthem.entity;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

/**
 * baseEntity 通用字段
 * @author mazan
 *
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

	/**
	 * UID
	 */
	private static final long serialVersionUID = 1L;
	

}
