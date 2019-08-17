import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

    }
    //暴力做法 O(n2)
    public int largestRectangleArea(int[] heights) {
        int max=0;
        for(int i=0;i<heights.length;i++){
            int minLength=Integer.MAX_VALUE;
            for(int j=i;j<heights.length;j++){
                minLength=Math.min(minLength,heights[j]);
                max=Math.max(minLength*(j-i+1),max);
            }
        }
        return max;
    }
    //单调栈
    public int largestRectangleArea2(int[] heights) {
        //本质能覆盖住每个长方条的最大矩形的面积
        Stack<Integer> stack=new Stack<>();
        stack.add(-1);
        int maxArea=0;
        for(int i=0;i<heights.length;i++){
            while(stack.size()>1&&heights[stack.peek()]>heights[i]){
                int top=heights[stack.pop()];
                maxArea=Math.max(maxArea,top*(i-stack.peek()-1));
            }
            stack.add(i);
        }
        while(stack.size()>1){
            int index=stack.pop();
            int top=heights[index];
            maxArea=Math.max(maxArea,top*(heights.length-stack.peek()-1));
        }
        return maxArea;
    }
}
