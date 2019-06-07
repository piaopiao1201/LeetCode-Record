import java.util.*;

public class main {
    public static void main(String[] args) {
        int res=FirstNotRepeatingChar("sdeeffdsgewsax");
        System.out.println(1);
    }
    public static int FirstNotRepeatingChar(String str) {
        LinkedHashSet<Character> hashSet=new LinkedHashSet<Character>();
        Set<Character> visit=new HashSet<Character>();
        for(int i=0;i<str.length();i++){
            if(hashSet.contains(str.charAt(i))){
                hashSet.remove(str.charAt(i));
            }else{
                if(!visit.contains(str.charAt(i))){
                    visit.add(str.charAt(i));
                    hashSet.add(str.charAt(i));
                }
            }
        }
        Iterator<Character> it=hashSet.iterator();
        Character res=null;
        while (it.hasNext()){
            res=it.next();
            break;
        }
        return str.indexOf(res);
    }
}
