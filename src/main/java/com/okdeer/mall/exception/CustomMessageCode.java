package com.okdeer.mall.exception;


/**
 * 自定义消息代码
 * @author arescheung
 *
 */
public enum CustomMessageCode{
	/**
	 * 操作成功
	 */
	SUCCESS("成功", 0), 
	UNKNOWN_EXCEPTION("未知异常", 9),
	BUSINESS_EXCEPTION("业务异常",11),
	EXISTS_EXCEPTION("数据已经存在异常",12),
	/**
	 * 参数缺失
	 */
	MISS_PARAMS_EXCEPTION("参数缺失", 13);
	
	// 成员变量
    private String name;
    private Integer index;

    // 构造方法
    private CustomMessageCode(String name, Integer index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (CustomMessageCode c : CustomMessageCode.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    // get set 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

}