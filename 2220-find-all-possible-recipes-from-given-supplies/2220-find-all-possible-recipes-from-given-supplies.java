class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> visiting = new HashSet<>();
        Set<String> visited = new HashSet<>();
        List<String> result = new ArrayList<>();
        Set<String> supplySet = new HashSet<>();
        Set<String> cannotMake = new HashSet<>();

        for(int i = 0; i < recipes.length; i++)
        {
            graph.put(recipes[i], ingredients.get(i));
        }

        for(String s: supplies)
        {
            supplySet.add(s);
        }

        for(String recipe: recipes)
        {
            if(!visited.contains(recipe))
            {
                dfs(recipe, graph, supplySet, visiting, visited, result, cannotMake);
            }
        }

        return result;
    }

    private void dfs(String recipe, Map<String, List<String>> graph, Set<String> supplySet, Set<String> visiting, Set<String> visited, List<String> result, Set<String> cannotMake)
    {
        if(visiting.contains(recipe))
        {
            cannotMake.add(recipe);
            return;
        }

        if(supplySet.contains(recipe))
        {
            return;
        }

        if(!graph.containsKey(recipe))
        {
            return;
        }
        if(cannotMake.contains(recipe))
        {
            return;
        }

        visiting.add(recipe);

        List<String> ing = graph.get(recipe);

        if(ing != null)
        {
            for(String i: ing)
            {
                if(!supplySet.contains(i))
                {
                    dfs(i, graph, supplySet, visiting, visited, result, cannotMake);
                }
            } 

            boolean canMake = true;
            for(String i: ing)
            {
                if(!supplySet.contains(i))
                {
                    canMake = false;
                    break;
                }
            }   

            if(canMake)
            {
                result.add(recipe);
                supplySet.add(recipe);
            }     
            else {
                cannotMake.add(recipe);
            }  
        }
        else {
            cannotMake.add(recipe);
        }

        visiting.remove(recipe);
        visited.add(recipe);
    }
}