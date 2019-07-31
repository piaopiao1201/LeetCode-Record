import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] coins={2};
        int amount=4;
        int res=coinChange2(coins,amount);
        System.out.println(1);
    }
    public int coinChange(int[] coins, int amount) {
        List<Integer> coinsQues=new ArrayList<>();
        for(int i:coins){
            coinsQues.add(i);
        }
        coinsQues.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        int count=0;
        for(int i=coinsQues.size()-1;i>=0;i--){
            count+=amount/coinsQues.get(i);
            amount%=coinsQues.get(i);
            if(amount==0){
                break;
            }
        }
        return amount==0?count:-1;
    }
    public static int coinChange2(int[] coins, int amount) {
        List<Integer> coinsQues=new ArrayList<>();
        for(int i:coins){
            coinsQues.add(i);
        }
        coinsQues.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        List<Integer> res=new ArrayList<>();
        res.add(Integer.MAX_VALUE);
        find(coinsQues,amount,0,0,res);
        return res.get(0)==Integer.MAX_VALUE?-1:res.get(0);
    }
    public static void find(List<Integer> coinsArr,int remain,int start,int count,List<Integer> res){
        if(remain==0){
            res.set(0,Math.min(res.get(0),count));
        }
        for(int i=start;i<coinsArr.size();i++){
            long tmp=(long)coinsArr.get(i)*(res.get(0)-count);
            if(coinsArr.get(i)<=remain&&remain<=tmp){
                find(coinsArr,remain-coinsArr.get(i),i,count+1,res);
            }
        }
    }
}
