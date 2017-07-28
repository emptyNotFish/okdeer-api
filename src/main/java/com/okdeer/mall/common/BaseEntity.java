package com.okdeer.mall.common;

import java.io.Serializable;
import java.util.Date;
/**
 * 实体对象的基础公共字段封装类
 * @author Administrator
 *
 */
public class BaseEntity implements Serializable {
	/**
	 * @fieldName serialVersionUID
	 * @fieldType long
	 * @desc serialVersionUID
	 */
	private static final long serialVersionUID = 1388461731047622111L;
	/**
	 * 主键ID
	 */
	protected String id;
	/**
	 * 创建时间
	 */
	protected Date createTime;
	/**
	 * 创建人
	 */
	protected String createUserId;
	/**
	 * 更新时间
	 */
	protected Date updateTime;
	/**
	 * 更新人
	 */
	protected String updateUserId;
	/**
	 * 删除标识 0未删除，1已删除
	 */
	protected Disabled disabled;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Disabled getDisabled() {
		return disabled;
	}

	public void setDisabled(Disabled disabled) {
		this.disabled = disabled;
	}

}
