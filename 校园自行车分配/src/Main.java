import javafx.util.Pair;

import java.util.*;

public class Main {
    public static Set<Integer> flagSet=new HashSet<Integer>();
    //工人匹配车
    public static Map<Integer,Pair<Integer,Integer>> hashMap=new HashMap<Integer,Pair<Integer,Integer>>();

    //车匹配工人
    public static Map<Pair<Integer,Integer>,Integer> hashMap2=new HashMap<Pair<Integer,Integer>,Integer>();
    public static List<Pair<Integer,Integer>> workerList=new ArrayList<Pair<Integer, Integer>>();
    public static List<Pair<Integer,Integer>> bikeList=new ArrayList<Pair<Integer, Integer>>();
    public static void main(String[] args) {

    }
    public int[] assignBikes(int[][] workers, int[][] bikes) {

        for(int i=0;i<workers.length;i++){
            workerList.add(new Pair<Integer, Integer>(workers[i][0],workers[i][1]));
        }
        for(int i=0;i<bikes.length;i++){
            bikeList.add(new Pair<Integer, Integer>(bikes[i][0],bikes[i][1]));
        }
        for(int i=0;i<bikeList.size();i++){
            flagSet.clear();
            find(bikeList.get(i),workerList);
        }
        return null;
    }
    public static boolean find(Pair<Integer,Integer> bikeInfo,List<Pair<Integer,Integer>> workerList){
        for(int i=0;i<workerList.size();i++){
            if(Manhattan(bikeInfo,workerList.get(i))<getDefault(bikeInfo)&&!flagSet.contains(i)){
                flagSet.add(i);
                if(!hashMap.containsKey(i)||find(hashMap.get(i),workerList)){
                    hashMap.put(i,bikeInfo);
                    hashMap2.put(bikeInfo,i);
                    return true;
                }
            }
        }
        return false;
    }
    public static int Manhattan(Pair<Integer,Integer> bike,Pair<Integer,Integer> worker){
        return Math.abs(bike.getKey()-worker.getKey())+Math.abs(bike.getValue()-worker.getValue());
    }
    public static int getDefault(Pair<Integer,Integer> bikeInfo){
        if(hashMap2.containsKey(bikeInfo)){
            int workerIndex=hashMap2.get(bikeInfo);
            Pair<Integer,Integer> worker=workerList.get(workerIndex);
            return Manhattan(bikeInfo,worker);
        }else{
            return 1000000;
        }

    }
}
