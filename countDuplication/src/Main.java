import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

    }
    public static int countDuplicates(List<Integer> numbers) {
        int count=0;
        Set<Integer> set=new HashSet<Integer>();
        Set<Integer> flagSet=new HashSet<Integer>();
        for(Integer i:numbers){
            if(set.contains(i)){
                if(!flagSet.contains(i)){
                    count++;
                    flagSet.add(i);
                }
            }else{
                set.add(i);
            }
        }
        return count;
    }
}
