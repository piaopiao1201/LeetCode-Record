import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int res=numSquares(12);
        System.out.println(res);
    }
    public static int numSquares(int n) {
        List<Integer> numArr=new ArrayList<>();
        int start=1;
        while(true){
            if(start*start<=n){
                numArr.add(start*start);
                start++;
            }else {
                break;
            }
        }
        Collections.reverse(numArr);
        List<Integer> allRes=new ArrayList<>();
        allRes.add(Integer.MAX_VALUE);
        find(numArr,n,0,0,allRes);
        return allRes.get(0);
    }
    public static void find(List<Integer> numArr,int remain,int count,int start,List<Integer> allRes){
        if(remain==0){
            allRes.set(0,Math.min(allRes.get(0),count));
            return;
        }
        for(int i=start;i<numArr.size();i++){
            long tmp=(long)numArr.get(i)*(allRes.get(0)-count);
            if(numArr.get(i)<=remain&&remain<=tmp){
                find(numArr,remain-numArr.get(i),count+1,i,allRes);
            }
        }
    }
}
