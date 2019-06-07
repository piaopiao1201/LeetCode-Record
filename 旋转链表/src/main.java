public class main {
    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
//        ListNode head=listNode;
//        for(int i=2;i<=5;i++){
//            listNode.next=new ListNode(i);
//            listNode=listNode.next;
//        }
//        listNode.next=null;
        ListNode res=rotateRight(listNode,2);
        System.out.println(1);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode tmp=head;
        //获得链表长度
        int length=0;
        while(tmp!=null){
            length++;
            tmp=tmp.next;
        }
        if(k==0||length==1){
            return head;
        }
        int index=length-k%length;

        ListNode tmpHead=head;
        //获得头元素
        tmp=head;
        while(index!=0){
            if(index==1){
                tmpHead=tmp;
            }
            index--;
            tmp=tmp.next;
        }

        //获得尾元素
        ListNode tmpRear=tmp;
        while(tmpRear.next!=null){
            tmpRear=tmpRear.next;
        }
        tmpRear.next=head;
        tmpHead.next=null;
        head=tmp;
        return head;
    }
}
