import java.util.ArrayList;
import java.util.List;


/*
给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。

你应当保留两个分区中每个节点的初始相对位置。

示例:

输入: head = 1->4->3->2->5->2, x = 3
输出: 1->2->2->4->3->5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/partition-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(4);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(2);
        ListNode node5=new ListNode(5);
        ListNode node6=new ListNode(2);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        ListNode res=partition(node1,3);
        System.out.println(1);
    }
    public static ListNode partition(ListNode head, int x) {
        List<ListNode> min=new ArrayList<ListNode>();
        List<ListNode> max=new ArrayList<ListNode>();
        while(head!=null){
            if(head.val<x){
                min.add(head);
            }else{
                max.add(head);
            }
            head=head.next;
        }
        ListNode res=new ListNode(1);
        ListNode tempRes=res;
        for(ListNode temp:min){
            tempRes.next=temp;
            tempRes=tempRes.next;
        }
        for(ListNode temp:max){
            tempRes.next=temp;
            tempRes=tempRes.next;
        }
        tempRes.next=null;
        return res.next;
    }
}
