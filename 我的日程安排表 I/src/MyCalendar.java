import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class MyCalendar {
    private Map<Integer,Integer> map=new TreeMap<Integer, Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    });
    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        if(map.size()==0){
            map.put(start,end);
            return true;
        }
        Map.Entry<Integer,Integer> lastEntry=null;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getKey()>=end){
                if(lastEntry==null){
                    map.put(start,end);
                    return true;
                }else{
                    if(lastEntry.getValue()<=start){
                        map.put(start,end);
                        return true;
                    }else{
                        return false;
                    }
                }
            }
            lastEntry=entry;
        }
        if(lastEntry.getValue()<=start){
            map.put(start,end);
            return true;
        }else{
            return false;
        }
    }
}
