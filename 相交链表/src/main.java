public class main {
    public static void main(String[] args) {

    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int length1=0,length2=0;
        ListNode tmpA=headA;
        ListNode tmpB=headB;
        while(tmpA!=null){
            length1++;
            tmpA=tmpA.next;
        }
        while(tmpB!=null){
            length2++;
            tmpB=tmpB.next;
        }
        if(length1<length2){
            int delta=length2-length1;
            while(delta>0){
                headB=headB.next;
                delta--;
            }
        }

        if(length1>length2){
            int delta=length1-length2;
            while(delta>0){
                headA=headA.next;
                delta--;
            }
        }

        while(headA!=null&&headB!=null){
            if(headA.val==headB.val){
                break;
            }
            headA=headA.next;
            headB=headB.next;
        }
        if(headA==null&&headB==null){
            return null;
        }
        return headA;
    }
}
