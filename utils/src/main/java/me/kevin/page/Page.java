package me.kevin.page;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @author Kevin
 * @description 分页对象
 * @date 2017/1/19
 */
public class Page<T> implements Serializable {

    private Long total;

    private List<T> data;

    public Page(Long total, List<T> data) {
        this.total = total;
        this.data = data;
    }

    public static <T> Page<T> empty() {
        return new Page(0L, Collections.<T>emptyList());
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Page{" +
                "total=" + total +
                ", data=" + data +
                '}';
    }
}
