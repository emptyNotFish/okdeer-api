package com.okdeer.mall.common;

import org.apache.commons.lang3.StringUtils;

/**
 * 删除状态枚举 effective java建议删除状态用枚举
 * @author Administrator
 *
 */
public enum Disabled implements ViewEnum {


    /**
     * 不删除
     */
    valid("不删除"),

    /**
     * 删除
     */
    invalid("删除");

    /**
     * 枚举值
     */
    private String value;

    Disabled(String value) {
        this.value = value;
    }

    @Override
    public String getName() {
        return this.name();
    }

    @Override
    public String getValue() {
        return this.value;
    }

    /**
     * 根据值取枚举
     * @param value 枚举值
     * @return 枚举对象
     */
    public static Disabled enumValueOf(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        for (Disabled disabled : values()) {
            if (value.equalsIgnoreCase(disabled.getValue())) {
                return disabled;
            }
        }
        return null;
    }
}
