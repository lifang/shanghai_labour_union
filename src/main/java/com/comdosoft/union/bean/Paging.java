package com.comdosoft.union.bean;

/**
 * 分页对象<br>
 * <功能描述>
 *
 * @author zengguang 2014年7月17日
 *
 */
public class Paging {
    private int page;
    private int rows;
    private int offset;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getOffset() {
        if (page == 0) {
            offset = 0 * rows;
        } else {
            offset = (page - 1) * rows;
        }
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

}
