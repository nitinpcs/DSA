    class Solution {
        public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
            
            long s = 1;
            long e = (long)1e18;
            long res = e;
            while(s <= e){
                long mid = s+(e-s)/2;
                long ans = 0L;
                for(int time : workerTimes){
                    long val = (2*mid)/time;
                    ans += (long)((Math.sqrt(1 + 4 * val) - 1) / 2);

                    if(ans >= mountainHeight) break;
                }
                if(ans >= mountainHeight){
                    res = mid;
                    e = mid - 1;
                }
                else s = mid + 1;
            }
            return res;
        }
    }