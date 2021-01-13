package com.company.project.career.algorithms.arrow2offer;

/**
 * 二叉树的下一个节点<br>
 * 给定 一个二叉树和其中的一个节点，如何找出中序遍历的下一个节点？树中的节点除了有两个分别指向左、右子节点的指针，还有一个指向父节点的指针。
 * 例如：二叉树中序遍历{d，b，h，e，i，a，f，c，g}
 * 
 * @author zhangyanxiang 2020年12月28日 下午8:05:24
 */
public class NextNodeOfBinaryTree {

    public static void main(String[] args) {
        //创建一棵树
        /**
         * 1 2 3 4 5 6 7 8 9
         */
        Node<Integer> root = new Node<Integer>(1);
        Node<Integer> node1 = new Node<Integer>(2);
        Node<Integer> node2 = new Node<Integer>(3);
        Node<Integer> node3 = new Node<Integer>(4);
        Node<Integer> node4 = new Node<Integer>(5);
        Node<Integer> node5 = new Node<Integer>(6);
        Node<Integer> node6 = new Node<Integer>(7);
        Node<Integer> node7 = new Node<Integer>(8);
        Node<Integer> node8 = new Node<Integer>(9);
        root.left = node1;
        root.right = node2;
        root.parent = null;
        node2.parent = root;
        node1.parent = root;
        node1.left = node3;
        node3.parent = node1;
        node1.right = node4;
        node4.parent = node1;

        node2.left = node5;
        node5.parent = node2;
        node2.right = node6;
        node6.parent = node2;
        node3.right = node7;
        node7.parent = node3;

        node4.right = node8;
        node8.parent = node4;
        Node<Integer> N1 = findTheNextNode(node8);
        System.out.println(N1.item);
        Node<Integer> N2 = findTheNextNode(node4);
        System.out.println(N2.item);
        Node<Integer> N3 = findTheNextNode(node7);
        System.out.println(N3.item);
        //        Node<Integer> N4 = findTheNextNode(node6);
        //        System.out.println(N4.item);
    }

    private static Node findTheNextNode(Node n) {
        Node next = null;
        //情况1：如果该结点右子树不为空，那么他的下一个节点就是他的右子树中的最左节点，
        //即从右子节点出发，一直沿着指向左子节点的指针，找到他的下一个节点
        if (null != n.right) {
            next = n.right;
            while (null != next.left) {
                next = next.left;
            }
            return next;
        }

        //情况2：如果该节点右子树为空，如果节点是他的父节点的左子节点，
        //下一个节点是他的父节点
        if (null != n.parent && n == n.parent.left) {
            return n.parent;
        }

        //情况3：如果该节点是父节点的右子树，
        //沿着指向父节点的指针一直向上遍历，直到找到一个是它的父节点的左子节点的节点
        //如果这样的节点存在，那么这个节点的父节点就是我们要找到下一个节点
        if (null != n.parent && n == n.parent.right) {
            next = n;
            while (null != next.parent && next == next.parent.right) {//如果next.parent==null，直接返回null了？
                next = next.parent;
            }
            return next.parent;
        }
        return next;
    }

    private static class Node<E> {
        E       item;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E item) {
            this.item = item;
        }
    }

}
