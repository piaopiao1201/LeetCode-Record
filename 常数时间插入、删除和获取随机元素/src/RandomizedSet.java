import java.util.*;

public class RandomizedSet {
    List<Integer> list=new ArrayList<Integer>();
    Map<Integer,Integer> map=new HashMap<Integer,Integer>();

    /** Initialize your data structure here. */
    public RandomizedSet() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }else{
            list.add(val);
            map.put(val,list.size()-1);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int index=map.get(val);
            list.remove(index);
            for(int i=index;i<list.size();i++){
                map.put(list.get(i),i);
            }
            map.remove(val);
            return true;
        }else{
            return false;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random ra=new Random();
        return list.get(ra.nextInt(list.size()));
    }
}
