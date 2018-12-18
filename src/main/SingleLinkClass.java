package main;

import main.entity.NodeList;

/**
 * Created by huangpengfei on 2018/12/18.
 *
 * 单链表反转，1递归法，2非递归法
 */
public class SingleLinkClass {


    public static void main(String[] args) {
        NodeList nodeList = new NodeList(0);
        NodeList nodeList1 = new NodeList(1);
        NodeList nodeList2 = new NodeList(2);
        NodeList nodeList3 = new NodeList(3);
        NodeList nodeList4 = new NodeList(4);

        nodeList.setNext(nodeList1);
        nodeList1.setNext(nodeList2);
        nodeList2.setNext(nodeList3);
        nodeList3.setNext(nodeList4);

        System.out.println("=========反转前的链表=========");
        outputNode(nodeList);

        System.out.println("=========进行反转==========");
//        NodeList reNodeList = reverseListNode1(nodeList);// 递归法
        NodeList reNodeList = reverseListNode2(nodeList);// 非递归法
        System.out.println("=========反转后的链表=========");
        outputNode(reNodeList);

    }

    // 递归法
    public static NodeList reverseListNode1(NodeList head){

        if(head == null) return head;  // 若为空链或者当前结点在尾结点，直接return
        if(head.getNext() == null)  return head; // 如果是为节点，则直接return

        NodeList reHead = reverseListNode1(head.getNext());// 先反转后续节点head.getNext()
        head.getNext().setNext(head);// 将当前结点的指针域指向前一结点
        head.setNext(null);// 前一结点的指针域令为null;
        return reHead;// 反转后新链表的头结点
    }

    // 非递归法
    public static NodeList reverseListNode2(NodeList head) {

        if(head == null) return head;  // 若为空链或者当前结点在尾结点，直接return
        if(head.getNext() == null)  return head; // 如果是为节点，则直接return

        NodeList pre = head;// 前结点
        NodeList cur = head.getNext();// 当前结点
        NodeList tmp;// 临时结点，用于保存当前结点的指针域（即下一结点）
        while (cur != null) {// 当前结点为null，说明位于尾结点
            tmp = cur.getNext();
            cur.setNext(pre);// 反转指针域的指向
            // 指针往下移动
            pre = cur;
            cur = tmp;
        }
        // 最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点
        head.setNext(null);
        return pre;
    }


    // 链表输出
    public static void outputNode(NodeList head){
        while (head != null){
            System.out.println("head.getData() = [" + head.getData() + "]");
            head = head.getNext();
        }
    }
}
