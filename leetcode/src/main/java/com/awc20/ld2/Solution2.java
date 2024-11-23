package com.awc20.ld2;

public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //建个哑结点作为头结点,我们就不用在递归前单独处理当前结点的val了,而是直接统一递归下一个结点.
        ListNode dummyHead=new ListNode(0);
        //用l3作为指针去递归.
        ListNode l3=dummyHead;
        //进位数
        int carry=0;
        //直接递归两条链表到尽头
        while(l1!=null || l2 !=null){
            //获取l1,l2的值,因为有可能为空,如果为空就为0;
            int x=(l1 != null)?l1.val:0;
            int y=(l2 != null)?l2.val:0;
            //把总和跟l1和l2的值加起来
            int sum=x+y+carry;
            //如果有进位的话,处理一下
            carry=sum/10;
            //把值赋值给新链表
            l3.next=new ListNode(sum%10);
            //处理链表递归
            if(l1!= null)
                l1=l1.next;
            if(l2 != null )
                l2=l2.next;
            l3=l3.next;
        }
        //出递归了判断一下是否最后还有进位,如果有进位我们需要再加一个结点
        if(carry>0){
            l3.next=new ListNode(carry);
        }
        //这里返回哑结点的下一个结点.细品这种处理,可以让你的头结点跟随着链表递归,而不会创建一个多的尾巴出来.
        return dummyHead.next;
    }
}
