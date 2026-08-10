class Solution {

    public int minFlipsMonoIncr(String s) {

        int end0 = 0;
        int end1 = 0;

        for (char c : s.toCharArray()) {

            int newEnd0 = end0 + (c == '0' ? 0 : 1);

            int newEnd1 =
                Math.min(end0, end1)
                + (c == '1' ? 0 : 1);

            end0 = newEnd0;
            end1 = newEnd1;
        }

        return Math.min(end0, end1);
    }
}