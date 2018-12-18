package main.entity;

/**
 * Created by huangpengfei on 2018/12/18.
 */
public class NodeList {

    private int data;// 数据域
    private NodeList next;// 指针域

    public NodeList(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public NodeList getNext() {
        return next;
    }

    public void setNext(NodeList next) {
        this.next = next;
    }
}
