package com.okdeer.mall.common;

import java.util.ArrayList;
import java.util.List;
/**
 * 切割List集合方法
 * 将集合按照一定的规则分割成多个集合
 * @author Administrator
 *
 */
public class SplitListUtils {

	// 默认拆分条数为1000条
	private static final int MAX_SPLIT_SIZE = 1000;

	public static <T> List<List<T>> splitList(List<T> list) {
		return splitList(list, MAX_SPLIT_SIZE);
	}

	/**
	 * List 分割 害
	 * 
	 * @param list
	 *            原数据LIST
	 * @param subListSize
	 *            分割成包括多少个元素的LIST
	 * @return
	 */
	public static <T> List<List<T>> splitList(List<T> list, int subListSize) {
		// 创建list数组 ,用来保存分割后的list
		List<List<T>> listArray = new ArrayList<List<T>>();
		// 将分割后的list放入集合
		List<T> subList = new ArrayList<T>();
		int count = list.size() / subListSize + (list.size() % subListSize > 0 ? 1 : 0);
		for (int i = 0; i < count; i++) {
			if (subListSize * (i + 1) < list.size()) {
				subList = list.subList(i * subListSize, subListSize * (i + 1));
			} else {
				subList = list.subList(i * subListSize, list.size());
			}
			listArray.add(subList);
		}
		return listArray;
	}

}
