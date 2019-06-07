import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        char[] matrix={'a','b' ,'c', 'e','s','f' ,'c','s','a', 'd' ,'e' ,'e' };
        //char[] matrix={'a','b','c','b','c','d'};
        char[] str={'b','c','c','e','d'};
        //char[] str={'d','c','b','c','d'};
        boolean res=hasPath(matrix,3,4,str);
        System.out.println(1);
    }
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        boolean[] visited=new boolean[matrix.length];
        Arrays.fill(visited,false);
        String target=new String(str);
        int startX=0,startY=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(judgeIsTrue(matrix,j,i,rows,cols,visited,target,"")){
                    return true;
                }else{
                    Arrays.fill(visited,false);
                    continue;
                }
            }
        }
        return false;
        //return judgeIsTrue(matrix,startX,startY,rows,cols,visited,target,"");
    }
    public static boolean judgeIsTrue(char[] matrix,int posX,int posY,int rows,int cols,boolean[] visited,String target,String tempRes){
        //写边界条件
        if(posX<0||posY<0||posX>=cols||posY>=rows||visited[posY*cols+posX]){
            return false;
        }
        if(tempRes.length()>=target.length()){
            return false;
        }
        tempRes+=matrix[posY*cols+posX];
        visited[posY*cols+posX]=true;
        if(target.startsWith(tempRes)){
            if(tempRes.equals(target)){
                return true;
            }
        }else{
            tempRes=tempRes.substring(0,tempRes.length()-1);
            visited[posY*cols+posX]=false;
            return false;
        }

        if(judgeIsTrue(matrix,posX+1,posY,rows,cols,visited,target,tempRes)){
            return true;
        }
        if(judgeIsTrue(matrix,posX,posY+1,rows,cols,visited,target,tempRes)){
            return true;
        }
        if(judgeIsTrue(matrix,posX,posY-1,rows,cols,visited,target,tempRes)){
            return true;
        }
        if(judgeIsTrue(matrix,posX-1,posY,rows,cols,visited,target,tempRes)){
            return true;
        }
        tempRes=tempRes.substring(0,tempRes.length()-1);
        visited[posY*cols+posX]=false;
        return false;
    }
}
