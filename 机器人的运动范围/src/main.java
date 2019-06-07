import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        int res=movingCount(5,10,10);
        System.out.println(1);
    }
    public static int movingCount(int threshold, int rows, int cols)
    {
        boolean[] visited=new boolean[rows*cols];
        Arrays.fill(visited,false);
        ArrayList<Integer> res=new ArrayList<Integer>();
        res.add(0);
        find(threshold,0,0,rows,cols,visited,res,1);
        return res.get(0);
    }
    public static void find(int threshold, int posX,int posY,int rows, int cols,boolean[] visited, ArrayList<Integer> res,int tempRes){
        if(posX<0||posY<0||posX>=cols||posY>=rows||visited[posY*cols+posX]){
            return;
        }
        int sum=0;
        int tempX=posX,tempY=posY;
        while(tempX>0){
            sum+=tempX%10;
            tempX/=10;
        }
        while(tempY>0){
            sum+=tempY%10;
            tempY/=10;
        }
        if(sum>threshold){
            return;
        }
        visited[posY*cols+posX]=true;
        res.set(0,res.get(0)+1);
        find(threshold,posX-1,posY,rows,cols,visited,res,tempRes);
        find(threshold,posX,posY-1,rows,cols,visited,res,tempRes);
        find(threshold,posX+1,posY,rows,cols,visited,res,tempRes);
        find(threshold,posX,posY+1,rows,cols,visited,res,tempRes);
        //visited[posY*cols+posX]=false;
    }
}
