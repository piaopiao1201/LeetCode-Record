import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> allRes=new ArrayList<List<Integer>>();
        List<Integer> tempRes=new ArrayList<Integer>();
        Set<Integer> visit=new HashSet<Integer>();
        getRes(allRes,tempRes,visit,4,2,0);
        System.out.println(1);
    }
    public static void getRes(List<List<Integer>> allRes, List<Integer> tempRes, Set<Integer> visit,int n,int k,int j){
        if(tempRes.size()==k){
            List<Integer> temp=new ArrayList<Integer>(tempRes);
            allRes.add(temp);
            return;
        }
        for(int i=j+1;i<=n;i++){
            if(!visit.contains(i)){
                visit.add(i);
                tempRes.add(i);
                getRes(allRes,tempRes,visit,n,k,i);
                tempRes.remove((Integer) i);
                visit.remove(i);
            }
        }
    }
}
