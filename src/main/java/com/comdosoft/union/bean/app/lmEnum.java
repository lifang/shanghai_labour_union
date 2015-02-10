package com.comdosoft.union.bean.app;

public enum lmEnum {
//    1 互助保障
//    2 劳动政策
//    3 会员卡
//    4 女职工特殊权益
//    5 心理咨询
//    8 困难帮扶
//    9 工会工作
//    10 其他 
//    99 暂时不使用
    HZBZ(1,"互助保障"),
    LDZC(2,"劳动政策"),
    HYK(3,"会员卡"),
    NZGTSQY(4,"女职工特殊权益"),
    XLZX(5,"心理咨询"),
    KNBF(8,"困难帮扶"),
    GHGZ(9,"工会工作"),
    QT(10,"其他"),
    ZSBSY(99,"暂时不使用");
    
    private Integer code;
    private String name;
   
    private lmEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
   
    /**  
     * 获取 code  
     * @return code
     */
    public Integer getCode() {
        return code;
    }
    /**  
     * 设置 code  
     * @param code
     */
    public void setCode(Integer code) {
        this.code = code;
    }
    /**  
     * 获取 name  
     * @return name
     */
    public String getName() {
        return name;
    }
    /**  
     * 设置 name  
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

}
