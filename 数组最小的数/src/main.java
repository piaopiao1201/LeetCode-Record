import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
//    private static String minInteger="10000000000000000000";
    public static void main(String[] args) {
        int[] numbers={3,32,321};
        String res=PrintMinNumber(numbers);
        System.out.println(1);
    }
    public static String PrintMinNumber(int [] numbers) {
        boolean[] visited=new boolean[numbers.length];
        Arrays.fill(visited,false);
        List<Integer> tmpRes=new ArrayList<Integer>();
        List<String> res=new ArrayList<String>();
        res.add("10000000000000000000");
        find(numbers,visited,tmpRes,res);
        return res.get(0);
    }

    public static void find(int[] numbers,boolean[] visited,List<Integer> tmpRes,List<String> res){
        if(tmpRes.size()==numbers.length){
            StringBuilder sb=new StringBuilder();
            for(Integer i:tmpRes){
                sb.append(i);
            }
            String sbRes=sb.toString();
            if(sbRes.length()==res.get(0).length()){
                if(sbRes.compareTo(res.get(0))<0){
                    res.set(0,sbRes);
                }
            }else if(sbRes.length()<res.get(0).length()){
                res.set(0,sbRes);
            }
            return;
        }
        for(int i=0;i<numbers.length;i++){
            if(!visited[i]){
                visited[i]=true;
                tmpRes.add(numbers[i]);
                find(numbers,visited,tmpRes,res);
                tmpRes.remove(tmpRes.size()-1);
                visited[i]=false;
            }
        }
    }
}
