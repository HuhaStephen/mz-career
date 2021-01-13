package com.company.project.career.algorithms.arrow2offer;

/**
 * 重建二叉树<br>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,
 * 5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 
 * @author zhangyanxiang 2020年12月28日 下午1:47:25
 */
public class RebuildBinaryTree {

    public static void main(String[] args) {
        int[] preOrder = { 1, 2, 4, 7, 3, 5, 6, 8 };
        int[] midOrder = { 4, 7, 2, 1, 5, 3, 8, 6 };
        Node<Integer> treeNode = rebuild(preOrder, 0, preOrder.length - 1, midOrder, 0, midOrder.length - 1);
        theFirstTraversal(treeNode);
    }

    //先序遍历 用于测试最终的结果是否正确
    public static void theFirstTraversal(Node root) {
        System.out.println(root.item);
        if (root.left != null) { //使用递归进行遍历左孩子
            theFirstTraversal(root.left);
        }
        if (root.right != null) { //递归遍历右孩子
            theFirstTraversal(root.right);
        }
    }

    private static Node<Integer> rebuild(int[] preOrder, int preLeft, int preRight, int[] midOrder, int midLeft,
                                         int midRight) {
        if (preLeft > preRight || midLeft > midRight) {
            return null;
        }

        int rootV = preOrder[preLeft];
        Node<Integer> rootN = new Node<Integer>(rootV);
        //找出根节点值在中序遍历数组中的索引位置
        int rootIndexInMidOrderArray = midLeft;
        for (; rootIndexInMidOrderArray <= midRight; rootIndexInMidOrderArray++) {
            if (midOrder[rootIndexInMidOrderArray] == rootV) {
                break;
            }
        }
        //分治思想
        rootN.left = rebuild(preOrder, preLeft + 1, rootIndexInMidOrderArray - midLeft + preLeft, midOrder, midLeft,
                rootIndexInMidOrderArray - 1);
        rootN.right = rebuild(preOrder, rootIndexInMidOrderArray - midLeft + preLeft + 1, preRight, midOrder,
                rootIndexInMidOrderArray + 1, midRight);

        return rootN;

    }

    private static class Node<E> {
        E       item;
        Node<E> left;
        Node<E> right;

        public Node(E item) {
            this.item = item;
        }
    }

}
