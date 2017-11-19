package com.test;



/**
 * Created by yanfeng-mac on 2017/11/12.
 */
public class AddTwoNumbers {
    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public long castToNumber(ListNode listNode) {
        ListNode node = listNode;
        StringBuilder s = new StringBuilder();
        for(;;) {
            if(node.next == null) {
                s.append(node.val);
                break;
            }
            s.append(node.val);
            node = node.next;


        }

        Long a = Long.parseLong(s.toString());
        return a;
    }

    public String reverseSum(long sum) {
        String str = sum + "";
        StringBuffer stringBuffer = new StringBuffer(str).reverse();

        return stringBuffer.toString();
    }

    public ListNode StringToList(String str) {

        String[] array = str.split("");

        ListNode result = new ListNode(Integer.parseInt(array[0]));
        ListNode cursor = result;
        for(int i = 1;i < array.length;i++) {

            ListNode newListNode = new ListNode(Integer.parseInt(array[i]));
            cursor.next = newListNode;
            cursor = cursor.next;
        }
        return result;
    }

    public ListNode test(ListNode l1,ListNode l2) {

        long a = castToNumber(l1);
        long b = castToNumber(l2);

        long sum = a + b;
        System.out.println("sum: " + sum);
        String reverseSum = reverseSum(sum);
        System.out.println("reverseSum: " + reverseSum);




        return StringToList(reverseSum);


    }

    public static void main(String[] args) {

        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(9);
        listNode.next.next = new ListNode(9);
        listNode.next.next.next = new ListNode(9);
        listNode.next.next.next.next = new ListNode(9);
        listNode.next.next.next.next.next = new ListNode(9);
        listNode.next.next.next.next.next.next = new ListNode(9);
        listNode.next.next.next.next.next.next.next = new ListNode(9);
        listNode.next.next.next.next.next.next.next.next = new ListNode(9);
        listNode.next.next.next.next.next.next.next.next.next = new ListNode(9);


        ListNode listNode2 = new ListNode(7);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode listNode1 = addTwoNumbers.test(listNode,listNode2);
        System.out.println(addTwoNumbers.castToNumber(listNode1));


    }
}
