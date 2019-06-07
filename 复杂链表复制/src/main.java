public class main {
    public static void main(String[] args) {
        RandomListNode n1=new RandomListNode(1);
        RandomListNode n2=new RandomListNode(2);
        RandomListNode n3=new RandomListNode(3);
        RandomListNode n4=new RandomListNode(4);
        RandomListNode n5=new RandomListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n1.random=n4;
        n3.random=n2;
        RandomListNode res=Clone(n1);
        RandomListNode res2=cloneN(n1);
        System.out.println(1);
    }
    //简单链表复制
    public static RandomListNode cloneN(RandomListNode pHead){
        RandomListNode res=new RandomListNode(pHead.label);
        RandomListNode tmp=res;
        pHead=pHead.next;
        while(pHead!=null){
            res.next=new RandomListNode(pHead.label);
            res=res.next;
            pHead=pHead.next;
        }
        return tmp;
    }
    public static RandomListNode Clone(RandomListNode pHead)
    {
        //分为3步走
        //1、每个节点复制一份
//        RandomListNode tmpCopy=new RandomListNode(1);
//        RandomListNode tmpCopyYang=tmpCopy;
//        while(pHead!=null){
//            tmpCopyYang.next=new RandomListNode(pHead.next.label);
//            pHead=pHead.next;
//            tmpCopyYang=tmpCopyYang.next;
//        }
//        tmpCopy=tmpCopy.next;

        cloneNodes(pHead);
        connectNodes(pHead);
        return resHead(pHead);
    }
    public static void cloneNodes(RandomListNode head){
        while(head!=null){
            RandomListNode tmp=new RandomListNode(head.label);
            RandomListNode tmpNext=head.next;
            head.next=tmp;
            tmp.next=tmpNext;
            head=tmpNext;
        }
    }

    public static void connectNodes(RandomListNode head){
        while (head!=null){
            RandomListNode cloneNode=head.next;
            if(head.random!=null){
                cloneNode.random=head.random.next;
            }
            head=cloneNode.next;
        }
    }

    public static RandomListNode resHead(RandomListNode head){
        RandomListNode res=new RandomListNode(1);
        RandomListNode tmp=res;
        while(head!=null){
            RandomListNode cloneNode=head.next;
            tmp.next=cloneNode;
            head.next=cloneNode.next;
            head=head.next;
            tmp=tmp.next;
        }
        return res.next;
    }
}
