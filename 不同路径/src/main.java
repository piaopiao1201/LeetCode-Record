public class main {
    private static int sum;
    public static void main(String[] args) {
        System.out.println(uniquePaths(23,12));
    }

    public static int uniquePaths(int m, int n) {
        int[][] matrix=new int[n][m];
        for(int i=0;i<m;i++){
            matrix[0][i]=1;
        }
        for(int i=0;i<n;i++){
            matrix[i][0]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                matrix[i][j]=matrix[i-1][j]+matrix[i][j-1];
            }
        }
        return matrix[n-1][m-1];
    }
//    public static int uniquePaths(int m, int n) {
//        sum=0;
//        int startX=0,startY=0;
//        find(startX,startY,m,n);
//        return sum;
//    }


    public static void find(int curX,int curY,int m,int n){
        if(curX>=m||curY>=n){
            return;
        }
        if(curX==m-1&&curY==n-1){
            sum++;
        }
        for(int i=0;i<2;i++){
            switch (i){
                case 0:
                    find(curX+1,curY,m,n);
                    break;
                case 1:
                    find(curX,curY+1,m,n);
                    break;
            }
        }

    }
}
