import javafx.util.Pair;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        //int[][] arr={{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[][] arr2={{2,3},{4,6},{5,7},{3,4}};
        int[][] res=merge(arr2);
        System.out.println(1);
    }
    public static int[][] merge(int[][] intervals) {
        List<Pair<Integer,Integer>> arr=new ArrayList<Pair<Integer, Integer>>();

        for(int i=0;i<intervals.length;i++){
            arr.add(new Pair<Integer, Integer>(intervals[i][0],intervals[i][1]));
            //int tempRes=find(arr,intervals[i][0],intervals[i][1]);
//            if(tempRes==-1){
//                arr.add(new Pair<Integer, Integer>(intervals[i][0],intervals[i][1]));
//            }else{
//                Pair<Integer,Integer> temp=arr.get(tempRes);
//                Pair<Integer,Integer> newTemp=new Pair<Integer, Integer>(Math.min(temp.getKey(),intervals[i][0]),Math.max(temp.getValue(),intervals[i][1]));
//                arr.set(tempRes,newTemp);
//            }
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
        for(int i=0;i<arr.size();i++){
            int tempRes=find(arr,arr.get(i).getKey(),arr.get(i).getValue());
        }
        Set<Pair<Integer,Integer>> flag=new HashSet<Pair<Integer,Integer>>(arr);
        int[][] resArr=new int[flag.size()][2];
        int index=0;
        for(Pair<Integer,Integer> temp:flag){
            resArr[index][0]=temp.getKey();
            resArr[index++][1]=temp.getValue();
        }
//        for(int i=0;i<arr.size();i++){
//            Pair<Integer,Integer> temp=arr.get(i);
//            if(!flag.contains(temp)){
//                flag.add(temp);
//                resArr[i][0]=arr.get(i).getKey();
//                resArr[i][1]=arr.get(i).getValue();
//            }
//        }
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
