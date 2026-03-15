class Fancy {
    static final long MOD = 1000000007;

    List<Long> l;
    long add = 0;
    long mul = 1;

    public Fancy() {
        l = new ArrayList<>();
    }
    
    public void append(int val) {
        long v = (val - add + MOD) % MOD;
        v = v * moduloInverse(mul) % MOD;
        l.add(v);
    }
    
    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }
    
    public void multAll(int m) {
        mul = (mul  * m) % MOD;
        add = (add * m) % MOD;
    }
    
    public int getIndex(int idx) {
        if(idx >= l.size()) return -1;
        int val = (int)((l.get(idx) * mul + add) % MOD);
        return val;
    }

    long moduloInverse(long mul) {
        return power(mul, MOD - 2);
    }

    long power(long a, long b) {
        long res = 1;
        while(b > 0){
            if((b&1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }
 }

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */