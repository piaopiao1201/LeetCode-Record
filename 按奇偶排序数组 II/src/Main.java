import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(1);
    }
    public int[] sortArrayByParityII(int[] A) {
        int[] res=new int[A.length];
        List<Integer> listA=new ArrayList<Integer>();
        List<Integer> listB=new ArrayList<Integer>();
        int AIndex=0;
        int BIndex=0;
        int nowIndex=0;
        for(Integer t:A){
            if(t%2==0){
                listA.add(t);
            }else{
                listB.add(t);
            }
        }
        while(nowIndex<A.length){
            if(nowIndex%2==0){
                res[nowIndex++]=listA.get(AIndex++);
            }else{
                res[nowIndex++]=listB.get(BIndex++);
            }
        }
        return res;
    }
}
