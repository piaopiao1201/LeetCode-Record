import java.util.Map;
import java.util.Stack;

public class Main {
    //public static int maxArea=0;
    public static void main(String[] args) {
        int[] dp={1,0};
        int res=cal2(dp);
        System.out.println(1);
    }
    public static int maximalRectangle(char[][] matrix) {
        int[][] dp=new int[matrix.length][matrix[0].length];
        int maxArea=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==0){
                    dp[i][j]=matrix[i][j]=='1'?1:0;
                }else{
                    if(matrix[i][j]!='0'){
                        dp[i][j]=matrix[i-1][j]!=0?dp[i-1][j]+1:1;
                    }
                }
            }
            maxArea=Math.max(maxArea,cal2(dp[i]));
        }
        return maxArea;
    }
    public static int cal(int[] arr){
        int left=0,right=arr.length-1;
        int maxArea=0;
        while(left<right){
            maxArea=Math.max(maxArea,Math.min(arr[left],arr[right])*(right-left));
            if(arr[left]>arr[right]){
                right--;
            }else{
                left++;
            }
        }
        return maxArea;
    }
    public static int cal2(int[] arr){
        Stack<Integer> stack=new Stack<Integer>();
        int maxArea=0;
        for(int i=0;i<arr.length;i++){
            if(stack.empty()||arr[stack.peek()]<arr[i]){
                stack.add(i);
            }else{
                while(!stack.empty()&&arr[stack.peek()]>=arr[i]){
                    int tmp=stack.peek();
                    stack.pop();
                    int length=0;
                    if(stack.empty()){
                        length=i;
                    }else{
                        length=i-stack.peek()-1;
                    }
                    maxArea=Math.max(maxArea,length*arr[tmp]);
                }
                stack.add(i);
            }
        }
        while(!stack.empty()){
            int tmp=stack.peek();
            stack.pop();
            int length=0;
            if(stack.empty()){
                length=arr.length;
            }else{
                length=arr.length-stack.peek()-1;
            }
            maxArea=Math.max(maxArea,length*arr[tmp]);
        }
        return maxArea;
    }
}
