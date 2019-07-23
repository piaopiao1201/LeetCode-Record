import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(1);
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree=new int[numCourses];
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0;i<prerequisites.length;i++){
            int toLearn=prerequisites[i][0];
            int preLearn=prerequisites[i][1];
            indegree[toLearn]++;
            if(map.containsKey(preLearn)){
                map.get(preLearn).add(toLearn);
            }else{
                List<Integer> list=new ArrayList<>();
                list.add(toLearn);
                map.put(preLearn,list);
            }
        }
        Stack<Integer> stack=new Stack<>();
        //init
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                stack.add(i);
            }
        }
        int count=0;
        while(!stack.isEmpty()){
            int tmp=stack.pop();
            count++;
            if(!map.containsKey(tmp)){
                continue;
            }
            for(int i=0;i<map.get(tmp).size();i++){
                if((--indegree[map.get(tmp).get(i)])==0){
                    stack.add(map.get(tmp).get(i));
                }
            }
        }
        return count<numCourses?false:true;
    }
}
