import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int res=checkRecord(10);
        System.out.println(1);
    }
    public static int checkRecord(int n) {
        List<Integer> res=new ArrayList<>();
        res.add(0);
        DFS("",false,0,n,res);
        return res.get(0);
    }
    public static void DFS(String temp,boolean hasA,int LNum,int n,List<Integer> res){
        if(LNum>2){
            return;
        }
        if(temp.length()==n){
            res.set(0,res.get(0)+1);
            return;
        }
        if(!hasA){
            DFS(temp+"A",true,0,n,res);
        }
        DFS(temp+"L",hasA,LNum+1,n,res);
        DFS(temp+"P",hasA,0,n,res);
    }
}
