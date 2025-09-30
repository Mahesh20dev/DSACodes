class Solution {
    public boolean canFinishUtil(ArrayList<Integer>[] graph,boolean[] visited,boolean[] stack,int curr) {
        visited[curr]=true;
        stack[curr]=true;

        for(int neighbour:graph[curr]){
            if(stack[neighbour]){
                return true;
            }else if(!visited[neighbour] && canFinishUtil(graph,visited,stack,neighbour)){
                return true;
            }
        }
        stack[curr]=false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
         ArrayList<Integer>[] graph=new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i]=new ArrayList<>();
        }
        for(int[] edge:prerequisites){
            int course=edge[0];
            int required=edge[1];
            graph[required].add(course);
        }

        boolean[] visited=new boolean[numCourses];
        boolean[] stack=new boolean[numCourses];
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                if(canFinishUtil(graph,visited,stack,i)){
                    return false;
                }
            }
        }
        return true;
    }
}