import java.util.*;

public class LRUCache {
    private List<Integer> index;
    private Map<Integer,Integer> map;
    private int length;
    public LRUCache(int capacity) {
        this.length=capacity;
        index=new LinkedList<Integer>();
        map=new HashMap<Integer, Integer>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            int tmpIndex=index.indexOf(key);
            index.remove(tmpIndex);
            index.add(key);
            return map.get(key);
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.size()<length){
            if(map.containsKey(key)){
                map.put(key,value);
                int tmpIndex=index.indexOf(key);
                index.remove(tmpIndex);
                index.add(key);
            }else{
                index.add(key);
                map.put(key,value);
            }
        }else{
            if(map.containsKey(key)){
                map.put(key,value);
                int tmpIndex=index.indexOf(key);
                index.remove(tmpIndex);
                index.add(key);
            }else{
                int tmpIndex=index.remove(0);
                map.remove(tmpIndex);
                map.put(key,value);
                index.add(key);
            }
        }
    }
}
