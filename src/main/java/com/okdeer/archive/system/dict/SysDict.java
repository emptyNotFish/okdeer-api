package com.okdeer.archive.system.dict;

import java.io.Serializable;
/**
 * 数据字典实体类
 * @author Administrator
 *
 */
public class SysDict implements Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	
	/**
	 * 字典值id
	 */
	private String id;
	/**
	 * 字典值
	 */
	private String value;
	/**
	 * 字典名称
	 */
	private String label;
	/**
	 * 标签类型
	 */
	private String type;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 是否删除 0-否 1-是
	 */
	private String delFlag;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	
}
