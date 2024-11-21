package com.awc20.ld2;


//两数之和:  该解决方案只能是long范围之内的两数之和,其他的就得通过二进制操作来了
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long list1=readList(l1);
        long list2=readList(l2);
        long listSum=list1+list2;
        return createResultList(listSum);
    }

    public long readList(ListNode listNode){
        //把第一个结点的值读取出来
        long result=listNode.val;
        //递归读取第二位以及更多
        //定义一个位 个十百千万,每次递归*10
        long size=10;
        while(listNode.next!=null){
            listNode=listNode.next;
            result=result+listNode.val*size;
            size=size*10;
        }
        return result;
    }

    public ListNode createResultList(long sum){
        ListNode resultList=new ListNode();
        ListNode curNode=resultList;
        int ud=(int)(sum%10);
        curNode.val=ud;
        sum=sum/10;
        while(sum>0){
            curNode.next=new ListNode();
            curNode=curNode.next;
            //求余出sum的个位数, 然后让sum/10消去该个位数
            ud=(int)(sum%10);
            curNode.val=ud;
            sum=sum/10;
        }
        return resultList;
    }
}