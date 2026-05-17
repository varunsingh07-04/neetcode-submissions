class Solution {
    public String decodeString(String s) {
      Stack<Integer> stack = new Stack<>();
      StringBuilder curr = new StringBuilder();
      Stack<StringBuilder> string = new Stack<>();
      int num=0;
      for(char ch : s.toCharArray()){
        if(Character.isDigit(ch)){
            num=num*10+(ch-'0');
        }else if(ch=='['){
            stack.push(num);
            num=0;
            string.push(curr);
            curr=new StringBuilder(); 
        }else if(ch==']'){
            StringBuilder prev = string.pop();
            prev.append(curr.toString().repeat(stack.pop()));
            curr=prev;
        }else{
            curr.append(ch);
        }
      }  
      return curr.toString();
    }
}