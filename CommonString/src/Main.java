import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

    }
    public static void commonSubstring(List<String> a, List<String> b) {
        for(int i=0;i<a.size();i++){
            String temp=a.get(i);
            Set<Character> tempSet=new HashSet<Character>();
            for(Character c:temp.toCharArray()){
                tempSet.add(c);
            }
            boolean flag=false;
            for(Character d:b.get(i).toCharArray()){
                if(tempSet.contains(d)){
                    flag=true;
                    break;
                }
            }
            if(flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
