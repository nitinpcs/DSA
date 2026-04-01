class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> adq = new ArrayDeque<>();
        for(int asteroid : asteroids){
            boolean flag = true;
            while(!adq.isEmpty() && adq.peek() > 0 && asteroid < 0){
                if(adq.peek() < -asteroid){
                    adq.pop();
                    continue;
                }
                if(adq.peek() == -asteroid){
                    adq.pop();
                }
                flag = false;
                break;
            }
            if(flag){
                adq.push(asteroid);
            }
        }
        int[] ans=new int[adq.size()];
        for(int i=ans.length-1;i>=0;i--){
            ans[i]=adq.pop();
        }
        return ans;
    } 
}