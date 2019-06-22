import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] grid={{0,0,1},{1,1,0}};
        int res=maxAreaOfIsland(grid);
        System.out.println(1);
    }
    public static int maxAreaOfIsland(int[][] grid) {
        boolean[][] flag=new boolean[grid.length][grid[0].length];
        Map<Integer,Integer> map=new TreeMap<Integer, Integer>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!flag[i][j]&&grid[i][j]==1){
                    BFS(i,j,flag,map,grid);
                }
            }
        }
        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for(Map.Entry<Integer,Integer> it:list){
            return it.getValue();
        }
        return 1;
    }

    public static void BFS(int x,int y,boolean[][] flag,Map<Integer,Integer> map,int[][] grid){
        Queue<Node> que=new LinkedList<Node>();
        Node node=new Node(x,y,x*flag[0].length+y);
        flag[x][y]=true;
        que.add(node);
        while(!que.isEmpty()){
            Node top=que.poll();
            int typeNum=map.containsKey(top.type)?map.get(top.type):0;
            map.put(top.type,typeNum+1);
            if(judge(grid,top.x-1,top.y,flag)){
                Node newNode=new Node(top.x-1,top.y,top.type);
                que.add(newNode);
            }
            if(judge(grid,top.x+1,top.y,flag)){
                Node newNode=new Node(top.x+1,top.y,top.type);
                que.add(newNode);
            }
            if(judge(grid,top.x,top.y-1,flag)){
                Node newNode=new Node(top.x,top.y-1,top.type);
                que.add(newNode);
            }
            if(judge(grid,top.x,top.y+1,flag)){
                Node newNode=new Node(top.x,top.y+1,top.type);
                que.add(newNode);
            }
        }
    }
    public static boolean judge(int[][] grid,int x,int y,boolean[][] flag){
        if(x<0||x>=grid.length||y<0||y>=grid[0].length||flag[x][y]){
            return false;
        }
        if(grid[x][y]==1){
            flag[x][y]=true;
            return true;
        }else{
            return false;
        }

    }
    static class Node{
        int x;
        int y;
        int type;
        public Node(int x,int y,int type){
            this.x=x;
            this.y=y;
            this.type=type;
        }
    }
}
