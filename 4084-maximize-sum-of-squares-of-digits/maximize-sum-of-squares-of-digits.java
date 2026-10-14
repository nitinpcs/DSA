class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb = new StringBuilder();
        while(sum > 0) {
            if(num == 0) return "";
            if(sum > 9) {
                sb.append(9);
                sum -= 9;
            }
            else {
                sb.append(sum);
                sum = 0;
            }
            num--;
        }
        while(num-- > 0) sb.append(0);
        return sb.toString();
    }
}
