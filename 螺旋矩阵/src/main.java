import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {
        //int[][] nums={{1,2,3},{4,5,6},{7,8,9}};
        //List<Integer> res=spiralOrder(nums);
        int[][] res=generateMatrix(3);
        System.out.println(1);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret=new ArrayList<Integer>();
        if(matrix.length==0){
            return ret;
        }
        int[] direction={1,2,3,4};
        int curPos=0;
        int startX=0,startY=0;
        int rowNum=matrix.length;
        int columnNum=matrix[0].length;
        boolean[][] isVisited=new boolean[rowNum][columnNum];
        //标记数组的初始化
        for (int i=0;i<isVisited.length;i++){
            Arrays.fill(isVisited[i],false);
        }

        while(ret.size()<rowNum*columnNum){
            ret.add(matrix[startX][startY]);
            isVisited[startX][startY]=true;
            switch (direction[curPos]){
                case 1:
                    if(startY+1>=columnNum||isVisited[startX][startY+1]){
                       curPos=(curPos+1)%direction.length;
                       startX++;
                    }else{
                        startY++;
                    }
                    break;
                case 2:
                    if(startX+1>=rowNum||isVisited[startX+1][startY]){
                        curPos=(curPos+1)%direction.length;
                        startY--;
                    }else{
                        startX++;
                    }
                    break;
                case 3:
                    if(startY-1<0||isVisited[startX][startY-1]){
                        curPos=(curPos+1)%direction.length;
                        startX--;
                    }else{
                        startY--;
                    }
                    break;
                case 4:
                    if(startX-1<0||isVisited[startX-1][startY]){
                        curPos=(curPos+1)%direction.length;
                        startY++;
                    }else{
                        startX--;
                    }
                    break;
            }
        }
        return ret;
    }

    public static int[][] generateMatrix(int n) {
        int num=n*n;
        int[][] res=new int[n][n];
        int[] direction={1,2,3,4};
        int curPos=0;
        int curNum=0;
        int startX=0,startY=0;
        boolean[][] isVisited=new boolean[num][num];
        //标记数组的初始化
        for (int i=0;i<isVisited.length;i++){
            Arrays.fill(isVisited[i],false);
        }
        while(curNum<num){
            res[startX][startY]=++curNum;
            isVisited[startX][startY]=true;
            switch (direction[curPos]){
                case 1:
                    if(startY+1>=n||isVisited[startX][startY+1]){
                        curPos=(curPos+1)%direction.length;
                        startX++;
                    }else{
                        startY++;
                    }
                    break;
                case 2:
                    if(startX+1>=n||isVisited[startX+1][startY]){
                        curPos=(curPos+1)%direction.length;
                        startY--;
                    }else{
                        startX++;
                    }
                    break;
                case 3:
                    if(startY-1<0||isVisited[startX][startY-1]){
                        curPos=(curPos+1)%direction.length;
                        startX--;
                    }else{
                        startY--;
                    }
                    break;
                case 4:
                    if(startX-1<0||isVisited[startX-1][startY]){
                        curPos=(curPos+1)%direction.length;
                        startY++;
                    }else{
                        startX--;
                    }
                    break;
            }
        }
        return res;
    }
}
