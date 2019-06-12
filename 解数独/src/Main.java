import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        char[][] board={{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(board);
        System.out.println(1);
    }
    public static void solveSudoku(char[][] board) {
        //初始化
        boolean[][] row=new boolean[board.length+2][board[0].length+2];
        boolean[][] column=new boolean[board.length+2][board[0].length+2];
        boolean[][] block=new boolean[board.length+2][board[0].length+2];
        List<Integer> needFill=new ArrayList<Integer>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.'){
                    int temp=board[i][j]-'0';
                    int blockColumn=j/3;
                    int blockRow=i/3;
                    int blockIndex=blockRow*3+blockColumn;
                    row[i][temp]=true;
                    column[j][temp]=true;
                    block[blockIndex][temp]=true;
                }else{
                    needFill.add(i*board.length+j);
                }
            }
        }
        List<Boolean> res=new ArrayList<Boolean>();
        res.add(false);
        getRes(needFill,0,board,row,column,block,res);

    }
    public static void getRes(List<Integer> needFill,int nowIndex,char[][] board,boolean[][] row,boolean[][] column,boolean[][] block,List<Boolean> res){
//        if(nowIndex>=6){
//            System.out.println(1);
//        }
        if(nowIndex>=needFill.size()||res.get(0)==true){
            if(nowIndex>=needFill.size()){
                res.set(0,true);
            }
            return;
        }
        for(int i=1;i<=9;i++){
            if(check(row,column,block,i,needFill.get(nowIndex),board)){
                int index=needFill.get(nowIndex);
                int x=index/board.length;
                int y=index%board[0].length;
                int blockColumn=y/3;
                int blockRow=x/3;
                int blockIndex=blockRow*3+blockColumn;
                row[x][i]=column[y][i]=block[blockIndex][i]=true;
                board[x][y]=(char)(i+'0');
                getRes(needFill,nowIndex+1,board,row,column,block,res);
                if(nowIndex>=needFill.size()||res.get(0)==true){
                    if(nowIndex>=needFill.size()){
                        res.set(0,true);
                    }
                    return;
                }
                row[x][i]=column[y][i]=block[blockIndex][i]=false;
            }
        }
    }
    public static boolean check(boolean[][] row,boolean[][] column,boolean[][] block,int temp,int index,char[][] board){
        int i=index/board.length;
        int j=index%board[0].length;
        int blockColumn=j/3;
        int blockRow=i/3;
        int blockIndex=blockRow*3+blockColumn;
        if(row[i][temp]||column[j][temp]||block[blockIndex][temp]){
            return false;
        }
        return true;
    }
}
