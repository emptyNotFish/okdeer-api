package com.okdeer.archive.system.dict;

import java.util.List;

/**
 * 数据字典接口
 * @author Administrator
 *
 */
public interface SysDictApi {
	/**
	 * @desc 根据字典type获取字典列表
	 * @param type 字典类型
	 * @return 列表信息
	 */
	List<SysDict> findDictList(String type) throws Exception;
}
