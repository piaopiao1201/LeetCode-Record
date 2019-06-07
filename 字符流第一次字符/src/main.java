import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class main {
    public static String res="ddodeellowworrld";
    public static void main(String[] args) {
        System.out.println(FirstAppearingOnce());
    }
    public static char FirstAppearingOnce()
    {
        Set<Character> linkedSet=new LinkedHashSet<Character>();
        Set<Character> hashSet=new HashSet<Character>();
        for(int i=0;i<res.length();i++){
            Character temp=res.charAt(i);
            if(!hashSet.contains(temp)){
                hashSet.add(temp);
                linkedSet.add(temp);
            }else{
                linkedSet.remove(temp);
            }
        }
        for(Character i:linkedSet){
            return i;
        }
        return '#';
    }
}
