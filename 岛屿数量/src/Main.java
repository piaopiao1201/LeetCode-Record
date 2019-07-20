import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

    }
    public int numIslands(char[][] grid) {
        int count=0;
        if(grid.length==0){
            return 0;
        }
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'&&!visited[i][j]){
                    count++;
                    BFS(grid,visited,new Node(i,j));
                }
            }
        }
        return count;
    }
    public static void BFS(char[][] grid,boolean[][] visited,Node start){
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(start);
        visited[start.x][start.y]=true;
        while (!queue.isEmpty()){
            Node temp=queue.poll();
            if(check(temp.x-1,temp.y,grid,visited)){
                queue.add(new Node(temp.x-1,temp.y));
            }
            if(check(temp.x+1,temp.y,grid,visited)){
                queue.add(new Node(temp.x+1,temp.y));
            }
            if(check(temp.x,temp.y+1,grid,visited)){
                queue.add(new Node(temp.x,temp.y+1));
            }
            if(check(temp.x,temp.y-1,grid,visited)){
                queue.add(new Node(temp.x,temp.y-1));
            }
        }
    }
    public static boolean check(int x,int y,char[][] grid,boolean[][] visited){
        if(x<0||x>=grid.length||y<0||y>=grid[0].length||visited[x][y]||grid[x][y]!='1'){
            return false;
        }
        visited[x][y]=true;
        return true;
    }
    static class Node{
        int x;
        int y;
        public Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}
