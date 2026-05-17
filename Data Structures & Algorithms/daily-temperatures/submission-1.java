class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
       int l=temperatures.length-1;
       int[] ans = new int[l+1];
       Stack<Integer> stack= new Stack<>();
       ans[l]=0;
       stack.push(l);
       for(int i=l-1;i>=0;i--){
        if(!stack.isEmpty() && temperatures[i]<temperatures[stack.peek()]){
            ans[i]=stack.peek()-i;
            stack.push(i);
        }else{
            while(!stack.isEmpty() && temperatures[stack.peek()]<=temperatures[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i]=0;
            }else{
                ans[i]=stack.peek()-i;
            }
            stack.push(i);
        }
      }
      return ans;

    }
}