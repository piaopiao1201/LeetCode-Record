public class Main {
    public static void main(String[] args) {
        System.out.println(1);
    }
    public ListNode middleNode(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null){
            if(fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
            }else{
                fast=fast.next;
            }
        }
        return slow;
    }
}
