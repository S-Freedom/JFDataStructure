package main.entity;

/**
 * Created by huangpengfei on 2018/12/18.
 */
public class DoubleNodeList {
    private int data;// 数据域
    private DoubleNodeList next;// 指针域
    private DoubleNodeList prev;// 指针域

    public DoubleNodeList(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DoubleNodeList getNext() {
        return next;
    }

    public void setNext(DoubleNodeList next) {
        this.next = next;
    }

    public DoubleNodeList getPrev() {
        return prev;
    }

    public void setPrev(DoubleNodeList prev) {
        this.prev = prev;
    }
}
