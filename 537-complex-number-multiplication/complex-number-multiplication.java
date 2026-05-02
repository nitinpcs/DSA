class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] n1 = num1.split("\\+");
        String[] n2 = num2.split("\\+");

        int a = Integer.parseInt(n1[0]);
        int b = Integer.parseInt(n1[1].substring(0,n1[1].length()-1));
        int c = Integer.parseInt(n2[0]);
        int d = Integer.parseInt(n2[1].substring(0,n2[1].length()-1));

        String res = (a*c + b*d*-1)+"+" + (a*d + b*c) + "i";

        return res;
    }
}