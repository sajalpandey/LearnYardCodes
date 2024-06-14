class Solution {
    public static final int NOT_VISITED = 0;
    public static final int VISITING = 1;
    public static final int VISITED = 2;

    public boolean dfs(String r, HashMap<String, List<String>> adj, List<String> result, HashMap<String, Integer> status) {
        if(!status.containsKey(r))
            return false; //suppose someone calls dfs for non required recipe
        if(status.get(r) == VISITED)
            return true;
        
        if(status.get(r) == VISITING)
            return false; // already in DFS 
        
        status.put(r, VISITING);

        //now call dfs for every ingredients
        for(String str : adj.get(r)) {
            boolean possible = dfs(str, adj, result, status);
            if(!possible)
                return false;
        }

        status.put(r, VISITED);
        result.add(r);
        return true;
    }

    public void topoSortDfs(HashMap<String, List<String>> adj, List<String> result, String[] recipes, HashMap<String, Integer> status) {
        //call dfs for every recipes

        for(int i=0; i<recipes.length; i++) {
            dfs(recipes[i], adj, result, status);
        }
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        //visited array
        HashMap<String, Integer> status = new HashMap<>();

        //create a adjacency list
        HashMap<String, List<String>> adj = new HashMap<>();

        //mark every recipe as not visited
        for(int i=0; i<recipes.length; i++) {
            status.put(recipes[i], NOT_VISITED);
            adj.put(recipes[i], ingredients.get(i));
        }

        //put all supplies in status map as visited
        for(String str : supplies)  
            status.put(str, VISITED);
        List<String> result = new ArrayList<>();
        //Now call topoSort using dfs
        topoSortDfs(adj, result, recipes, status);

        return result;
    }
}