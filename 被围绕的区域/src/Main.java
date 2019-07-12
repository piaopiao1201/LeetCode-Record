public class Main {
    public static void main(String[] args) {
        System.out.println(1);
    }
    /*
    1、寻找边界点的字母O作为dfs的入口点
    2、将dfs寻找到的字母O改填充为'#'
    3、遍历数组，将O改为X，#改为0
     */
    public void solve(char[][] board) {
        if(board.length==0){
            return;
        }
        boolean[][] visited=new boolean[board.length][board[0].length];
        for(int i=0;i<board[0].length;i++){
            if(!visited[0][i]){
                dfs(0,i,board,visited);
            }
            if(!visited[board.length-1][i]){
                dfs(board.length-1,i,board,visited);
            }

        }

        for(int i=0;i<board.length;i++){
            if(!visited[i][0]){
                dfs(i,0,board,visited);
            }
            if(!visited[i][board[0].length-1]){
                dfs(i,board[0].length-1,board,visited);
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
    public static void dfs(int x,int y,char[][] board,boolean[][] visited){
        if(x<0||x>=board.length||y<0||y>=board[0].length||visited[x][y]||board[x][y]=='X'){
            return;
        }
        visited[x][y]=true;
        if(board[x][y]=='O'){
            board[x][y]='#';
        }
        dfs(x-1,y,board,visited);
        dfs(x+1,y,board,visited);
        dfs(x,y-1,board,visited);
        dfs(x,y+1,board,visited);
    }
}
