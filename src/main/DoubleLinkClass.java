package main;

import main.entity.DoubleNodeList;

/**
 * Created by huangpengfei on 2018/12/18.
 * 双链表反转
 */
public class DoubleLinkClass {

    public static void main(String[] args) {
        DoubleNodeList doubleNodeList = new DoubleNodeList(0);
        DoubleNodeList doubleNodeList1 = new DoubleNodeList(1);
        DoubleNodeList doubleNodeList2 = new DoubleNodeList(2);
        DoubleNodeList doubleNodeList3 = new DoubleNodeList(3);
        DoubleNodeList doubleNodeList4 = new DoubleNodeList(4);

        doubleNodeList.setNext(doubleNodeList1);
        doubleNodeList1.setNext(doubleNodeList2);
        doubleNodeList2.setNext(doubleNodeList3);
        doubleNodeList3.setNext(doubleNodeList4);

        doubleNodeList4.setPrev(doubleNodeList3);
        doubleNodeList3.setPrev(doubleNodeList2);
        doubleNodeList2.setPrev(doubleNodeList1);
        doubleNodeList1.setPrev(doubleNodeList);

        System.out.println("=========反转前的链表=========");
        outputNode(doubleNodeList);

        System.out.println("=========进行反转==========");
        DoubleNodeList reDoubleNodeList = reverseListNode(doubleNodeList);

        System.out.println("=========反转后的链表=========");
        outputNode(reDoubleNodeList);

    }

    public static void outputNode(DoubleNodeList head){
        while (head != null){
            System.out.println("head.getData() = [" + head.getData() + "]");
            if(head.getNext() != null){
               System.out.println("head.getNext() = [" + head.getNext().getData() + "]");
            }
            if(head.getPrev() != null) {
                System.out.println("head.getPrev() = [" + head.getPrev().getData() + "]");
            }
            head = head.getNext();
            System.out.println();
        }
    }

    public static DoubleNodeList reverseListNode(DoubleNodeList head) {

        DoubleNodeList pre = null;
        DoubleNodeList next = null;
        while(head!=null){
            next = head.getNext();
            head.setNext(pre);
            head.setPrev(next);
            pre = head;
            head = next;
        }
        return pre;
    }

}
