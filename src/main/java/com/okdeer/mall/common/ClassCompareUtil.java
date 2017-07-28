package com.okdeer.mall.common;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 *  对象比较工具类
 *  利用java 反射机制实现
 *  返回有差异的数据
 * @author Administrator
 *
 */
public class ClassCompareUtil {

    /**
     * 对比两个相同对象中的差异属性值，并返回差异的数据
     *
     * @param oneObj Object 第一个对象（修改前）
     * @param twoObj Object 第二个对象（修改后）
     * @param editor String 拼接文案
     * @return Map<String, Object> 不相同的属性值信息
     * @throws IllegalAccessException
     */
    public static Map<String, Object> entityCompare(Object oneObj, Object twoObj, String editor) throws Exception {
        if (oneObj.getClass() != twoObj.getClass()) {
            throw new Exception("两个对象类型不一致");
        }
        //返回被修改的信息对象
        Map<String, Object> map = Maps.newHashMap();
        //获取对象的字段信息
        Field[] one_fields = oneObj.getClass().getDeclaredFields();
        Field[] two_fields = twoObj.getClass().getDeclaredFields();
        //字段名集合
        List<String> keyList = Lists.newArrayList();
        //字段修改内容集合
        List<String> valList = Lists.newArrayList();
        for (int i = 0; i < one_fields.length; i++) {
            //修改访问权限，放开私有属性
            one_fields[i].setAccessible(true);
            two_fields[i].setAccessible(true);
            //第一个对象的属性值
            String val_one = one_fields[i].get(oneObj) == null ? "" : one_fields[i].get(oneObj).toString();
            //第二个对象的属性值
            String val_two = two_fields[i].get(twoObj) == null ? "" : two_fields[i].get(twoObj).toString();
            if (!val_one.equals(val_two) && !val_two.trim().equals("")) {
                //获取属性的注解信息
                XmlElement xmlElement = one_fields[i].getDeclaredAnnotation(XmlElement.class);
                if (xmlElement != null) {
                    keyList.add(one_fields[i].getName());
                    valList.add(xmlElement.name() + editor + val_two);
                }
            }
        }
        if (valList.size() > 0) {
            map.put("keyList", keyList);
            map.put("valList", valList);
        }
        return map;
    }
}
