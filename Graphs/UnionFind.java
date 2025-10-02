public class UnionFind {
    static int n=5;
    static int[] par=new int[n];
    static int[] rank=new int[n];
    public static void init(){
         for(int i=0;i<n;i++){
            par[i]=i;
        }
    }

    public static int find(int x){
        if(x==par[x]){
            return x;
        }
        return par[x]=find(par[x]);
    }

    public static void union(int a,int b){
        int x=par[a];
        int y=par[b];

        if(rank[x]==rank[y]){
            par[x]=y;
            rank[y]++;
        }else if(rank[x]<rank[y]){
            par[x]=y;
        }else{
            par[y]=x;
        }
    }

    public static void main(String[] args) {
        init();
        System.out.println("init done");
        System.out.println(find(2));
        union(2, 3);
        System.out.println(find(2));
    }
}
