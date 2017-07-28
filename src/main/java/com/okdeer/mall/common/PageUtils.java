package com.okdeer.mall.common;

public class PageUtils {

	private long page;
	private long totalPage;
	private Object list;
	

	public void setPage(long page) {
		this.page = page;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	

	public Object getList() {
		return list;
	}

	public void setList(Object list) {
		this.list = list;
	}

	public long getPage() {
		return page;
	}

	public long getTotalPage() {
		return totalPage;
	}
	
}
