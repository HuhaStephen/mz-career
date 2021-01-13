package com.company.project.career.algorithms.arrow2offer;

/***
 * 从尾到头打印链表<br>
 * 输入一个链表的头结点，从尾到头反过来打印出每个节点的值
 * 
 * @author zhangyanxiang 2021年1月12日 下午5:07:27
 */
public class PrintLinkedListFromTailToHead {

    public static void main(String[] args) {
        Node<Integer> node0 = new Node<Integer>(1);
        Node<Integer> node1 = new Node<Integer>(2);
        Node<Integer> node2 = new Node<Integer>(3);
        Node<Integer> node3 = new Node<Integer>(4);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        //test null
        print(null);
        //test 正常数据
        print(node0);
        //test 元素为空
        node0.item = null;
        print(node0);

    }

    //递归调用反向输出
    private static void print(Node n) {
        if (null == n)
            return;
        if (n.next != null) {
            print(n.next);
        }
        System.out.println(n.item);
    }

    private static class Node<E> {
        E       item;
        Node<E> next;

        public Node(E item, Node<E> n) {
            this.item = item;
            this.next = n;
        }

        public Node(E item) {
            this.item = item;
        }
    }

}
