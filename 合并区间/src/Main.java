import javafx.util.Pair;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
    public static int[][] merge(int[][] intervals) {
        List<Pair<Integer,Integer>> arr=new ArrayList<Pair<Integer, Integer>>();
        for(int i=0;i<intervals.length;i++){
            arr.add(new Pair<Integer, Integer>(intervals[i][0],intervals[i][1]));
        }

        arr.sort(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                if(o1.getKey()==o2.getKey()){
                    return 0;
                }
                return o1.getKey()<o2.getKey()?-1:1;
            }
        });
        List<Pair<Integer,Integer>> ResArr=new ArrayList<Pair<Integer, Integer>>();
        for(int i=0;i<arr.size();i++){
            int tempRes=find(ResArr,arr.get(i).getKey(),arr.get(i).getValue());
        }
        Set<Pair<Integer,Integer>> flag=new HashSet<Pair<Integer,Integer>>(ResArr);
        int[][] resArr=new int[flag.size()][2];
        int index=0;
        for(Pair<Integer,Integer> temp:flag){
            resArr[index][0]=temp.getKey();
            resArr[index++][1]=temp.getValue();
        }
        return resArr;
    }
    public static int find(List<Pair<Integer,Integer>> arr,int head,int tail){
        boolean flag=false;
        for(int i=0;i<arr.size();i++){
            Pair<Integer,Integer> temp=arr.get(i);
            if(tail<temp.getKey()||head>temp.getValue()){
                continue;
            }else{
                flag=true;
                Pair<Integer,Integer> newTemp=new Pair<Integer, Integer>(Math.min(temp.getKey(),head),Math.max(temp.getValue(),tail));
                arr.set(i,newTemp);
            }
        }
        if(!flag){
            arr.add(new Pair<Integer, Integer>(head,tail));
        }
        return -1;
    }
}
