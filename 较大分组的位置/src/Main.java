import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(1);
    }
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        int start=0,end=0;
        char lastC='a';
        int i;
        for(i=0;i<S.length();i++){
            if(i==0){
                lastC=S.charAt(i);
                start=i;
                continue;
            }
            if(S.charAt(i)!=lastC){
                if(i-1-start+1>=3){
                    List<Integer> temp=new ArrayList<Integer>();
                    temp.add(start);
                    temp.add(i-1);
                    res.add(temp);
                }
                start=i;
                lastC=S.charAt(i);
            }
        }
        if(i-1-start+1>=3){
            List<Integer> temp=new ArrayList<Integer>();
            temp.add(start);
            temp.add(i-1);
            res.add(temp);
        }
        return res;
    }
}
