import java.util.ArrayList;
import java.util.List;

public class MinStack {
    private static List<Integer> minArr;
    private static List<Integer> arr;
    /** initialize your data structure here. */
    public MinStack() {
        minArr=new ArrayList<Integer>();
        arr=new ArrayList<Integer>();
    }

    public void push(int x) {
        arr.add(x);
        if(minArr.size()>0){
            minArr.add(Math.min(x,minArr.get(minArr.size()-1)));
        }else{
            minArr.add(x);
        }
    }

    public void pop() {
        if(arr.size()==0){
            return;
        }
        arr.remove(arr.size()-1);
        minArr.remove(minArr.size()-1);
    }

    public int top() {
        return arr.get(arr.size()-1);
    }

    public int getMin() {
        return minArr.get(minArr.size()-1);
    }
}
