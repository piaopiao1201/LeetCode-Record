public class Main {
    public static void main(String[] args) {
    }
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row=new boolean[board.length+2][board[0].length+2];
        boolean[][] column=new boolean[board.length+2][board[0].length+2];
        boolean[][] block=new boolean[board.length+2][board[0].length+2];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]<'0'||board[i][j]>'9'){
                    continue;
                }
                int temp=board[i][j]-'0';
                int blockColumn=j/3;
                int blockRow=i/3;
                int blockIndex=blockRow*3+blockColumn;
                if(row[i][temp]||column[j][temp]||block[blockIndex][temp]){
                    return false;
                }
                row[i][temp]=true;
                column[j][temp]=true;
                block[blockIndex][temp]=true;
            }
        }
        return false;
    }
}
