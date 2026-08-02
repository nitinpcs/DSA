class Solution {
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int[] arr = new int[n + m];
        
        for(int i=n-1; i>=0; i--) {
            int x = num1.charAt(i) - '0';
            for(int j=m-1; j>=0; j--) {
                int y = num2.charAt(j) - '0';
                int mul = x*y;
                int sum = arr[i+j+1] + mul;
                arr[i+j+1] = sum % 10;
                arr[i+j] += sum/10;
            }
        }
        int idx = -1;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 0) idx = i;
            else break;
        }
        if(idx == arr.length-1) return "0";
        idx++;
        StringBuilder sb = new StringBuilder();
        for(int i=idx; i<arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}