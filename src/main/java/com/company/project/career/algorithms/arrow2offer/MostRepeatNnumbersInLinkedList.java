package com.company.project.career.algorithms.arrow2offer;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ObjectUtils;

public class MostRepeatNnumbersInLinkedList {

    public static void main(String[] args) {
        Node<Integer> header = new Node<Integer>(1);
        Node<Integer> node1 = new Node<Integer>(2);
        Node<Integer> node2 = new Node<Integer>(2);
        Node<Integer> node3 = new Node<Integer>(4);
        header.next = node1;
        node1.next = node2;
        node2.next = node3;
        List<Integer> list = getTop(header, 1);
        list.forEach(e -> {
            System.out.println(e);
        });
    }

    public static <T> List<T> getTop(Node<T> header, int n) {
        if (null == header || n <= 0)
            return null;
        Map<T, Integer> count = new HashMap<T, Integer>();
        Node<T> out = header;
        while (out != null) {
            int c = 1;
            Node<T> inner = out.next;
            while (inner != null) {
                if (ObjectUtils.equals(out.item, inner.item)) {
                    c++;
                    //把下个节点复制过来
                    Node<T> temp = inner.next;
                    if (inner.next != null) {
                        inner.item = inner.next.item;
                        inner.next = inner.next.next;
                        temp.next = null;
                        temp = null;
                    }
                    break;
                }

                inner = inner.next;
            }
            count.put(out.item, c);
            out = out.next;
        }
        List<Entry<T, Integer>> sorted = count.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toList());
        if (n >= sorted.size()) {
            return sorted.stream().map(e -> {
                return e.getKey();
            }).collect(Collectors.toList());
        } else {
            return sorted.subList(0, n - 1).stream().map(e -> {
                return e.getKey();
            }).collect(Collectors.toList());
        }

    }

    private static class Node<E> {
        E       item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }
    }

}
