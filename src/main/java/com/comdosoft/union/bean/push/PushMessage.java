package com.comdosoft.union.bean.push;

import java.util.Map;

/**
 * 推送消息数据类<br>
 * <功能描述>
 *
 * @author zengguang 2014年12月30日
 *
 */
public class PushMessage {

    private String title;

    private String description;

    /**
     * IOS特有参数
     */
    private Map<?, ?> aps;

    /**
     * 自定义参数
     */
    private Map<?, ?> custom_content;

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the aps
     */
    public Map<?, ?> getAps() {
        return aps;
    }

    /**
     * @param aps
     *            the aps to set
     */
    public void setAps(Map<?, ?> aps) {
        this.aps = aps;
    }

    /**
     * @return the custom_content
     */
    public Map<?, ?> getCustom_content() {
        return custom_content;
    }

    /**
     * @param custom_content
     *            the custom_content to set
     */
    public void setCustom_content(Map<?, ?> custom_content) {
        this.custom_content = custom_content;
    }

}