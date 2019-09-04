import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

    }
    public int firstUniqChar(String s) {
        Map<Character,Integer> map=new LinkedHashMap<Character,Integer>();
        Set<Character> set=new HashSet<>();
        int i=0;
        for(char c:s.toCharArray()){
            if(map.containsKey(c)){
                map.remove(c);
            }else{
                if(!set.contains(c)){
                    map.put(c,i);
                }
            }
            i++;
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            return entry.getValue();
        }
        return 0;
    }
}
