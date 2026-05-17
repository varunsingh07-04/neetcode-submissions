class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        for(int i=1;i<asteroids.length;i++){
            if(stack.isEmpty()){
                stack.push(asteroids[i]);
                continue;
            }
            if(stack.peek()>0 && asteroids[i]>0){
                stack.push(asteroids[i]);
            }else if(stack.peek()<0 && asteroids[i]<0){
                stack.push(asteroids[i]);
            }else if(stack.peek()>0 && asteroids[i]<0){
                boolean b= false;
                while(!stack.isEmpty() && stack.peek()>0){
                    if(stack.peek()==Math.abs(asteroids[i])){
                        stack.pop();
                        b=false;
                        break;
                    }else if(stack.peek()<=Math.abs(asteroids[i])){
                        stack.pop();
                        b=true;
                    }else{
                        b=false;
                        break;
                    }
                }
                if(b){
                    stack.push(asteroids[i]);
                }
            }else{
                stack.push(asteroids[i]);
            }
        }
        int[] arr = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            arr[i] = stack.pop();
        }
        return arr;
    }
}