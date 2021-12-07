package org.hui_su_fa.qiu_zi_ji_he;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 求解子集合
 * */
public class QiuZiJiHe {
    public static void main(String[] args) {
        System.out.println("[+] QiuZiJiHe main.");
    }

    public static void entrance(int[] ints) {
        ArrayList<LinkedList<Integer>> resultList = new ArrayList<>();
        helper(0, ints, resultList, new LinkedList<>());
        output(resultList);
    }

    private static void helper(int index,
                               int[] ints,
                               ArrayList<LinkedList<Integer>> resultList,
                               LinkedList<Integer> intList) {
        if (index >= ints.length) {
            resultList.add(new LinkedList<>(intList));
            return;
        } else {

        }
        // 不将第 index 个元素，加入到子集合中
        helper(index+1, ints, resultList, intList);
        // 将第 index 个元素，加入到子集合中
        intList.add(ints[index]);
        helper(index+1, ints, resultList, intList);
        intList.removeLast();
    }

    private static void output(ArrayList<LinkedList<Integer>> resultList) {
        for (int i=0; i<resultList.size(); i++) {
            System.out.println("\n====================");
            LinkedList<Integer> ints = resultList.get(i);
            if (ints.isEmpty()) {
                System.out.print("-");
            } else {
                ints.forEach(System.out::print);
            }
        }
    }
}
