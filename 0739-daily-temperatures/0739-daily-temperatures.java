class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length == 0 || temperatures == null)
            return new int[0];
        int[] result = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < temperatures.length;i++)
        {
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i])
            {
                int idx = st.pop();
                result[idx] = i - idx;
            }
            st.push(i);
        }
        return result;
    }
}