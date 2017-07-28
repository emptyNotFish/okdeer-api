package com.okdeer.mall.common;

import java.util.List;
import java.util.Map;

public class ObjectUtil {
	/**
	 * 验证Object是否为空,目前只支持list/map/string
	 * @param object
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean vailObject(Object object){
		boolean boo = true;
		if(object != null){
		   if(object instanceof List){
			   List list = (List)object;
			   if(list != null && list.size()> 0){
				   boo = false;
			   }
		   }else if(object instanceof Map){
			   Map map = (Map)object;
			   if(map.size() > 0){
				   boo = false;
			   }
		   }else if(object instanceof String){
			   String str = (String)object;
			   if(str.length() > 0){
				   boo = false;
			   }
		   }else{
			   boo = false;
		   }
		}
	   return boo;
	}
}
