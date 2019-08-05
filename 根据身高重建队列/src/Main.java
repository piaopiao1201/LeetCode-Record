import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] arr={{7,0},{4,4} ,{7,1},{5,0},{6,1},{5,2}};
        reconstructQueue(arr);
    }
    static class Node{
        Integer key;
        Integer value;
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    public static int[][] reconstructQueue(int[][] people) {
        Map<Integer,Integer> map=new TreeMap<>();
        List<Node> list=new ArrayList<Node>();
        for(int i=0;i<people.length;i++){
            list.add(new Node(people[i][0],people[i][1]));
        }

        list.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.key.equals(o2.key)){
                    return o1.value.compareTo(o2.value);
                }
                return o2.key.compareTo(o1.key);
            }
        });
        for(int i=1;i<list.size();i++){
            Node tmp=list.get(i);
            for(int j=i-1;j>=0;j--){
                if(tmp.value==j){
                    list.set(j+1,list.get(j));
                    list.set(j,tmp);
                    break;
                }else if(tmp.value>j){
                    list.set(j+1,tmp);
                    break;
                }else{
                    list.set(j+1,list.get(j));
                }
            }
        }
        int[][] res=new int[people.length][people[0].length];
        for(int i=0;i<list.size();i++){
            res[i][0]=list.get(i).key;
            res[i][1]=list.get(i).value;
        }
        return res;
    }
}
