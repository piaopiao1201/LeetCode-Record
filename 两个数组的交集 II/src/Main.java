import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

    }
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        Map<Integer,Integer> map2=new HashMap<Integer,Integer>();
        for(int i:nums1){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        for(int i:nums2){
            if(map2.containsKey(i)){
                map2.put(i,map2.get(i)+1);
            }else{
                map2.put(i,1);
            }
        }
        for(Map.Entry<Integer,Integer> entry:map2.entrySet()){
            int temp=entry.getKey();
            int mapSum=map.containsKey(temp)?map.get(temp):0;
            for(int i=0;i<Math.min(entry.getValue(),mapSum);i++){
                res.add(temp);
            }
        }
        int[] arrRes=new int[res.size()];
        for(int i=0;i<res.size();i++){
            arrRes[i]=res.get(i);
        }
        return arrRes;
    }
}
