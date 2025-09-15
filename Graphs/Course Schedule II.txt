class Solution {
    public  boolean findOrderUtil(ArrayList<Integer>[] graph,boolean[] visited,boolean[] recStack,int curr,Stack<Integer> s){
        visited[curr]=true;
        recStack[curr]=true;
        for(int neighbour:graph[curr]){
            if(recStack[neighbour]){
                return true;
            }else if(!visited[neighbour] && findOrderUtil(graph,visited,recStack,neighbour,s)){
                return true;
            }
        }
        recStack[curr] = false;
        s.push(curr);
        return false;

    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         ArrayList<Integer>[] graph=new ArrayList[numCourses];
        boolean[] visited=new boolean[numCourses];
        boolean[] recStack=new boolean[numCourses];
        Stack<Integer> s=new Stack<>();
        int[] result=new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i]=new ArrayList<>();
        }
        for(int[] edge:prerequisites){
            int course=edge[0];
            int required=edge[1];
            graph[required].add(course);
        }
        // System.out.println(graph);
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]){
                if(findOrderUtil(graph,visited,recStack,i,s)){
                    return new int[0];
                }
            }
        }
        for(int i=0;i<result.length;i++){
            if(!s.isEmpty()){
            int re=s.pop(); 
            result[i]=re;
        }
        } 
        return result;
    }
}