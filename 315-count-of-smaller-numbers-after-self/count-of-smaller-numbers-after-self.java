class Solution {
    int[] arr;
    public List<Integer> countSmaller(int[] nums) {
        this.arr = nums;
        int n = nums.length ;
        SegmentTree s = new SegmentTree(4 * n);
        s.build(1, 0, n-1);
        
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++) {
            ans.add(s.query(1, i+1, n-1, 0, n-1, nums[i]));
        }

        return ans;
    }


    class SegmentTree {
        List<Integer>[] tree;
        SegmentTree(int n) {
            tree = new ArrayList[n];
        }

        void build(int node, int start, int end) {
            tree[node] = new ArrayList<>();
            if(start == end){
                tree[node].add(arr[end]);
                return;
            }
            int mid = start + (end - start)/2;
            build(2*node, start, mid);
            build(2*node + 1, mid+1, end);

            tree[node] = merge(tree[2*node], tree[2*node+1]);
        }

        List<Integer> merge(List<Integer> a, List<Integer> b){
            int n = a.size();
            int m = b.size();

            List<Integer> ans = new ArrayList<>();
            int i=0, j=0;
            while(i<n && j<m) {
                if(a.get(i) < b.get(j)){
                    ans.add(a.get(i++));
                }
                else{
                    ans.add(b.get(j++));
                }
            }
            while(i < n) ans.add(a.get(i++));
            while(j < m) ans.add(b.get(j++));

            return ans;
        }

        int query(int node, int l, int r, int s, int e, int x) {
            if(r < s || e < l) return 0;
            if(l <= s && e <= r) {
                List<Integer> temp = tree[node];
                return countMax(x, temp);
            }

            int mid = s +(e-s)/2;
            return query(2*node, l, r, s, mid, x) + query(2*node+1, l, r, mid+1, e, x);
        }

        int countMax(int x, List<Integer> l) {
            int s = 0, e = l.size() - 1;
            while(s <= e) {
                int mid = s + (e-s)/2;
                if(l.get(mid) < x) {
                    s = mid + 1;
                }
                else e = mid - 1;
            }
            return s;
        }
    }
}


// class Solution {

//     public List<Integer> countSmaller(int[] nums) {

//         int n = nums.length;

//         // Step 1: compression
//         int[] temp = nums.clone();
//         Arrays.sort(temp);

//         Map<Integer, Integer> map = new HashMap<>();
//         int idx = 1;

//         for (int x : temp) {
//             if (!map.containsKey(x)) {
//                 map.put(x, idx++);
//             }
//         }

//         // Step 2: BIT
//         int[] bit = new int[idx + 1];

//         List<Integer> ans = new ArrayList<>();

//         // Step 3: process from right
//         for (int i = n - 1; i >= 0; i--) {

//             int val = map.get(nums[i]);

//             // count smaller
//             ans.add(query(bit, val - 1));

//             // update
//             update(bit, val, 1);
//         }

//         Collections.reverse(ans);
//         return ans;
//     }

//     // prefix sum query
//     int query(int[] bit, int i) {
//         int sum = 0;
//         while (i > 0) {
//             sum += bit[i];
//             i -= i & (-i);
//         }
//         return sum;
//     }

//     // update BIT
//     void update(int[] bit, int i, int val) {
//         while (i < bit.length) {
//             bit[i] += val;
//             i += i & (-i);
//         }
//     }
// }