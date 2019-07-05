import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] ages={101,56,69,48,30};
        int res=numFriendRequests(ages);
        System.out.println(1);
    }
    public static int numFriendRequests(int[] ages) {
        Map<Integer,Integer> map=new TreeMap<Integer, Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        for(int i:ages){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        List<Integer> quesArr=new ArrayList<Integer>();
        for(Integer i:map.keySet()){
            quesArr.add(i);
        }
        int sum=0;
        for(int i=0;i<quesArr.size();i++){
            if(quesArr.get(i)<15){
                continue;
            }
            for(int j=i-1;j>=0;j--){
                int temp=quesArr.get(j);
                if(temp<=(double)quesArr.get(i)*0.5+7){
                    break;
                }

                sum+=map.get(quesArr.get(i))*map.get(quesArr.get(j));
            }
            int sameNum=map.get(quesArr.get(i));
            sum+=sameNum*(sameNum-1);
        }
        return sum;
    }
}
