import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word="ABCB";
        boolean res=exist(board,word);
        System.out.println(res);
    }
    public static boolean exist(char[][] board, String word) {
        boolean[][] flag=new boolean[board.length][board[0].length];
        StringBuilder sb=new StringBuilder();
        List<Boolean> resList=new ArrayList<Boolean>();
        resList.add(false);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                find(board,flag,sb,word,resList,i,j);
                if(resList.get(0)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void find(char[][] board,boolean[][] flag,StringBuilder temp,String word,List<Boolean> resList,int row,int column){
        if(row<0||row>=board.length||column<0||column>=board[0].length||flag[row][column]){
            return;
        }
        temp.append(board[row][column]);
        flag[row][column]=true;
        if(resList.get(0)||temp.toString().length()>word.length()){
            temp.setLength(temp.length()-1);
            flag[row][column]=false;
            return;
        }
        if(temp.toString().charAt(temp.length()-1)!=word.charAt(temp.length()-1)){
            //resList.set(0,true);
            temp.setLength(temp.length()-1);
            flag[row][column]=false;
            return;
        }
        if(temp.toString().length()==word.length()){
            resList.set(0,true);
            temp.setLength(temp.length()-1);
            flag[row][column]=false;
            return;
        }
        find(board,flag,temp,word,resList,row-1,column);
        find(board,flag,temp,word,resList,row+1,column);
        find(board,flag,temp,word,resList,row,column+1);
        find(board,flag,temp,word,resList,row,column-1);
        temp.setLength(temp.length()-1);
        flag[row][column]=false;
    }
}
