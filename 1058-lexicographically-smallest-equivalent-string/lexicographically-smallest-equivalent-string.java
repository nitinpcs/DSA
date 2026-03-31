class DSU{
    static int par[];
    public DSU(){
        par=new int[26];
        for(int i=0;i<26;i++){
            par[i]=i;
        }
    }
    public static int find(int x){
        if(par[x]!=x){
            par[x]=find(par[x]);
        }
        return par[x];
    }
    public static boolean union(int x,int y){
        int root1=find(x);
        int root2=find(y);
        if(root1==root2){
            return false;
        }
        if(root1<root2){
            par[root2]=root1;
            
        }
        else if(root2<root1){
            par[root1]=root2;
        }
       
        return true;
    }
}
class Solution {
    public String smallestEquivalentString(String s1, String s2, String base) {
        DSU dsu=new DSU();
        for(int i=0;i<s1.length();i++){
            dsu.union(s1.charAt(i)-'a',s2.charAt(i)-'a');
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<base.length();i++){
            sb.append((char)(dsu.find(base.charAt(i)-'a')+'a'));
        }
        return sb.toString();
    }
}