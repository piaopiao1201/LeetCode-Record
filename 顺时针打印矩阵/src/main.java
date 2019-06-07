import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        ArrayList<Integer> res=printMatrix(matrix);
        System.out.println(1);
    }
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        int row=matrix.length;
        int column=matrix[0].length;
        boolean[][] visited=new boolean[row][column];
        for(int i=0;i<visited.length;i++){
            Arrays.fill(visited[i],false);
        }
        int nowD=0;
        int[] direction={1,2,3,4};
        int startX=0,startY=0;
        int num=0;
        while(num<row*column){
            res.add(matrix[startX][startY]);
            visited[startX][startY]=true;
            num++;
            if(num>=row*column){
                break;
            }
            boolean flag=true;
            while(flag){
                switch (direction[nowD]){
                    case 1:
                        if(startY+1>=column||visited[startX][startY+1]){
                            nowD=(nowD+1)%direction.length;
                        }else{
                            startY++;
                            flag=false;
                        }
                        break;
                    case 2:
                        if(startX+1>=row||visited[startX+1][startY]){
                            nowD=(nowD+1)%direction.length;
                        }else{
                            startX++;
                            flag=false;
                        }
                        break;
                    case 3:
                        if(startY-1<0||visited[startX][startY-1]){
                            nowD=(nowD+1)%direction.length;
                        }else{
                            startY--;
                            flag=false;
                        }
                        break;
                    case 4:
                        if(startX-1<0||visited[startX-1][startY]){
                            nowD=(nowD+1)%direction.length;
                        }else{
                            startX--;
                            flag=false;
                        }
                        break;
                }
            }
        }
        return res;
    }
}
