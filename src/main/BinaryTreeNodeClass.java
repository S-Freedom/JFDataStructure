package main;

import main.entity.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by huangpengfei on 2018/12/18.
 */
public class BinaryTreeNodeClass {


//    前序遍历：根结点 ---> 左子树 ---> 右子树
//
//    中序遍历：左子树---> 根结点 ---> 右子树
//
//    后序遍历：左子树 ---> 右子树 ---> 根结点
//
//    层次遍历：只需按层次遍历即可

    public static void main(String[] args) {

        //                          2
        //                   34           66
        //               21     55    99     67
        //            32   31                  88
        //          22
        //        12
        //
        //
        BinaryTreeNode root = new BinaryTreeNode(2);
        BinaryTreeNode tnLeft = new BinaryTreeNode(34);
        BinaryTreeNode tnRight = new BinaryTreeNode(66);
        BinaryTreeNode tnLeftLeft = new BinaryTreeNode(21);
        BinaryTreeNode tnLeftRight = new BinaryTreeNode(55);
        BinaryTreeNode tnLeftLeftLeft = new BinaryTreeNode(32);
        BinaryTreeNode tnLeftLeftRight = new BinaryTreeNode(31);
        BinaryTreeNode tnLeftLeftLeftLeft = new BinaryTreeNode(22);
        BinaryTreeNode tnLeftLeftLeftLeftLeft = new BinaryTreeNode(12);
        BinaryTreeNode tnRightRight = new BinaryTreeNode(67);
        BinaryTreeNode tnRightLeft = new BinaryTreeNode(99);
        BinaryTreeNode tnRightRightRight = new BinaryTreeNode(88);

        root.left = tnLeft;
        root.right = tnRight;
        tnLeft.left = tnLeftLeft;
        tnLeft.right = tnLeftRight;
        tnLeftLeft.left = tnLeftLeftLeft;
        tnLeftLeftLeft.left = tnLeftLeftLeftLeft;
        tnLeftLeftLeftLeft.left = tnLeftLeftLeftLeftLeft;
        tnLeftLeftLeft.right = tnLeftLeftRight;
        tnRight.left = tnRightLeft;
        tnRight.right = tnRightRight;
        tnRightRight.right = tnRightRightRight;

        outputTree(root, BinaryTreeSelEnum.BinaryTreePreSel);
        outputTree(root, BinaryTreeSelEnum.BinaryTreeMidSel);
        outputTree(root, BinaryTreeSelEnum.BinaryTreeBackSel);

        System.out.println("=========进行反转==========");
        BinaryTreeNode reBinaryTreeNode = invertTree(root);
//        invertTreeResu(root);
        System.out.println("=========反转后的链表=========");
        outputTree(reBinaryTreeNode, BinaryTreeSelEnum.BinaryTreePreSel);
        outputTree(reBinaryTreeNode, BinaryTreeSelEnum.BinaryTreeMidSel);
        outputTree(reBinaryTreeNode, BinaryTreeSelEnum.BinaryTreeBackSel);

    }

    // 遍历二叉树，
    public static void outputTree(BinaryTreeNode treeNode, BinaryTreeSelEnum treeEnum) {

        switch (treeEnum) {
            case BinaryTreePreSel:
                System.out.println("=========前序遍历=========");
                preOrderTraversel(treeNode);
                System.out.println();
                break;
            case BinaryTreeMidSel:
                System.out.println("=========中序遍历=========");
                midOrderTraversel(treeNode);
                System.out.println();
                break;
            case BinaryTreeBackSel:
                System.out.println("=========后序遍历=========");
                backOrderTraversel(treeNode);
                System.out.println();
                break;
        }
    }


    public static void preOrderTraversel(BinaryTreeNode root) {
        if (root != null) {
            System.out.print(root.data + "  ");
            preOrderTraversel(root.left);
            preOrderTraversel(root.right);
        }
    }

    public static void midOrderTraversel(BinaryTreeNode root) {
        if (root != null) {
            midOrderTraversel(root.left);
            System.out.print(root.data + "  ");
            midOrderTraversel(root.right);
        }
    }

    public static void backOrderTraversel(BinaryTreeNode root) {
        if (root != null) {
            backOrderTraversel(root.right);
            backOrderTraversel(root.left);
            System.out.print(root.data + "  ");
        }
    }

    // 非递归
    public void preOrderTraversel2(BinaryTreeNode root) {
        LinkedList<BinaryTreeNode> stack = new LinkedList<>();
        BinaryTreeNode pNode = root;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                System.out.print(pNode.data + "  ");
                stack.push(pNode);
                pNode = pNode.left;
            } else { //pNode == null && !stack.isEmpty()
                BinaryTreeNode node = stack.pop();
                pNode = node.right;
            }
        }
    }

    public void midOrderTraversel2(BinaryTreeNode root) {
        LinkedList<BinaryTreeNode> stack = new LinkedList<>();
        BinaryTreeNode pNode = root;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            } else { //pNode == null && !stack.isEmpty()
                BinaryTreeNode node = stack.pop();
                System.out.print(node.data + "  ");
                pNode = node.right;
            }
        }
    }

    // 广度优先遍历，根据层级遍历，地毯式搜索
    public void levelTraverse(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            System.out.print(node.data + "  ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    // 深度优先遍历，类似于前序优先遍历
    public void depthOrderTraverse(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<BinaryTreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            System.out.print(node.data + "  ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    // 反转二叉树，递归实现，左右交换即可
    public static BinaryTreeNode invertTree(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            invertTree(root.left);
        }
        if (root.right != null) {
            invertTree(root.right);
        }
        swap(root);
        return root;
    }


    // 非递归实现。
    public static void invertTreeResu(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode current = stack.pop();
            swap(current);
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
    }

    private static void swap(BinaryTreeNode root) {
        BinaryTreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}