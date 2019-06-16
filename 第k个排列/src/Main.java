import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String res=getPermutation(9 ,278893);
        System.out.println(res);
    }
    public static String getPermutation(int n, int k) {
        int[] arr=new int[n];
        for(int i=1;i<=n;i++){
            arr[i-1]=i;
        }
        boolean[] visit=new boolean[n];
        List<String> allRes=new ArrayList<String>();
        String temp="";
        getRes(allRes,temp,arr,visit,k);
        return allRes.get(k-1);
    }
    public static void getRes(List<String> allRes,String temp,int[] arr,boolean[] visit,int k){
        if(allRes.size()==k){
            return;
        }
        if(temp.length()==arr.length){
            allRes.add(temp);
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(!visit[i]){
                visit[i]=true;
                temp+=arr[i];
                getRes(allRes,temp,arr,visit,k);
                temp=temp.substring(0,temp.length()-1);
                visit[i]=false;
            }
        }
    }
}