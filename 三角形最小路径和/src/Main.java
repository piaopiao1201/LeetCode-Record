import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp=new int[triangle.size()][triangle.size()+1];
        for(int i=0;i<triangle.get(triangle.size()-1).size();i++){
            dp[dp.length-1][i]=triangle.get(triangle.size()-1).get(i);
        }
        for(int i=dp.length-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
