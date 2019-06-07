import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        Map<Integer,Integer> map=new LinkedHashMap<Integer, Integer>(){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size()>2;
            }
        };
        map.put(1,2);
        map.put(2,3);
        map.get(1);
        map.put(3,4);
        System.out.println(1);
    }

}
