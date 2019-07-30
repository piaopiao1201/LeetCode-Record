import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

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
}
