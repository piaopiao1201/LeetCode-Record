public class Main {
    public static void main(String[] args) {
        int[][] grid={{7,0,5},{2,4,6},{3,8,1}};
        int res=numMagicSquaresInside(grid);
        System.out.println(1);
    }
    public static int numMagicSquaresInside(int[][] grid) {
        int num=0;
        for(int i=0;i<grid.length-2;i++){
            for(int j=0;j<grid[0].length-2;j++){
                if(check(grid,i,j)){
                    num++;
                }
            }
        }
        return num;
    }

    public static boolean check(int[][] grid,int starti,int startj){
        boolean[][] rowExist=new boolean[3][10];
        boolean[][] columnExist=new boolean[3][10];
        int[] rowNum=new int[3];
        int[] columnNum=new int[3];
        int dui1=0;
        int dui2=0;
        for(int i=starti;i<starti+3;i++){
            for(int j=startj;j<startj+3;j++){
                if(grid[i][j]>9||grid[i][j]<1){
                    return false;
                }
                if(rowExist[i-starti][grid[i][j]]){
                    return false;
                }
                rowExist[i-starti][grid[i][j]]=true;
                if(columnExist[j-startj][grid[i][j]]){
                    return false;
                }
                columnExist[j-startj][grid[i][j]]=true;
                rowNum[i-starti]+=grid[i][j];
                columnNum[j-startj]+=grid[i][j];
                if(i==starti&&j==startj){
                    dui1+=grid[i][j];
                }
                if(i==starti+2&&j==startj){
                    dui2+=grid[i][j];
                }
                if(i==starti+1&&j==startj+1){
                    dui1+=grid[i][j];
                    dui2+=grid[i][j];
                }
                if(i==starti&&j==startj+2){
                    dui2+=grid[i][j];
                }
                if(i==starti+2&&j==startj+2){
                    dui1+=grid[i][j];
                }
            }
        }
        if(dui1!=dui2){
            return false;
        }
        for(int i=0;i<3;i++){
            if(rowNum[i]!=dui1||columnNum[i]!=dui1){
                return false;
            }
        }
        return true;
    }
}
