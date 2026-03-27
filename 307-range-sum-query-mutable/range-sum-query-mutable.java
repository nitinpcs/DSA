class NumArray {
    int[] tree;
    int[] nums;
    int n;
    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        tree = new int[4*n];
        build(1, 0, n-1);
    }
    
    public void update(int index, int val) {
        updateVal(index, val, 0, n-1, 1);
    }
    
    public int sumRange(int left, int right) {
        return query(left, right, 0, n-1, 1);
    }

    void build(int node, int s, int e) {
        if(s == e){
            tree[node] = nums[s];
        }
        else{
            int mid = s + (e-s)/2;
            build(2*node, s, mid);
            build(2*node+1, mid+1, e);

            tree[node] = tree[2*node] + tree[2*node+1];
        }
    }

    void updateVal(int idx, int val, int s, int e, int node) {
        if(s == e){
            nums[idx] = val;
            tree[node] = val;
        }
        else{
            int mid = s+(e-s)/2;
            if(idx <= mid) updateVal(idx, val, s, mid, 2*node);
            else updateVal(idx, val, mid+1, e, 2*node+1);

            tree[node] = tree[2*node] + tree[2*node +1];
        }
    }

    int query(int l, int r, int s, int e, int node) {
        if(r<s || e<l) return 0;
        if(l<=s && e<=r){
            return tree[node];
        }

        int mid = s+(e-s)/2;
        return query(l, r, s, mid, 2*node) + query(l, r, mid+1, e, 2*node+1);
   }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */