class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0)
            return new int[0][0];
        
        Arrays.sort(people,
                   (a,b) -> {
                       if(a[0] == b[0])
                           return a[1] - b[1];
                       else
                           return b[0] - a[0];
                   });
        List<int[]> result = new ArrayList<>();
        
        for(int[] person:people)
        {
            result.add(person[1],person);
        }
        
        int[][] arr = new int[result.size()][2];
        for(int i = 0; i < arr.length;i++)
        {
            arr[i] = result.get(i);
        }
        return arr;
    }
}