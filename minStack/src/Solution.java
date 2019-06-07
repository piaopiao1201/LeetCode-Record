import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;
public class Solution {
    private static Stack<Integer> stack;
    private static List<Integer> minArr;
    public Solution(){
        stack=new Stack<Integer>();
        minArr=new ArrayList<Integer>();
    }
    public void push(int node) {
        stack.push(node);
        if(minArr.size()==0){
            minArr.add(node);
        }else{
            minArr.add(Math.min(node,minArr.get(minArr.size()-1)));
        }
    }

    public void pop() {
        stack.pop();
        minArr.remove(minArr.size()-1);
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minArr.get(minArr.size()-1);
    }
}
