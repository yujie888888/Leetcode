package Company_Uber;

public class P7_LC2192_NumberofWaystoReachDestination {
    public static void main(){
        //Hard题，看起来贼麻烦，LC上有讲解
        /*
        const int M = 998244353;

int mul(long long x, long long y) {
    return x * y % M;
}

int sub(int x, int y) {
    if ((x -= y) < 0) {
        x += M;
    }
    return x;
}

int add(int x, int y) {
    if ((x += y) >= M) {
        x -= M;
    }
    return x;
}

int rev(int x) {
    int r = 1;
    for (int i = M - 2; i; i >>= 1) {
        if (i & 1) {
            r = mul(r, x);
        }
        x = mul(x, x);
    }
    return r;
}

vector<int> helper(int x1, int x2, int n, int k) {
    // how many ways we can go from x1 to x2 by excatly k steps?
    vector<int> r(k + 1);
    r[0] = (x1 == x2) ? 1 : 0;
    for (int i = 1, m = 1; i <= k; ++i) {
        r[i] = sub(m, r[i - 1]);
        m = mul(m, n - 1);
    }
    return r;
}

int solution(int x1, int y1, int x2, int y2, int n, int m, int k) {
    const vector<int>& a = helper(x1, x2, n, k);
    const vector<int>& b = helper(y1, y2, m, k);
    int r = 0;
    // Now select i steps to change x and (k - i) steps to change y.
    for (int i = 0, c = 1; i <= k; ++i) {
        r = add(r, mul(mul(c, a[i]), b[k - i]));
        c = mul(mul(c, k - i), rev(i + 1));
    }
    return r;
}

int main() {
    cout << solution(1, 1, 2, 2, 3, 2, 2) << endl;
    cout << solution(2, 2, 1, 1, 3, 4, 3) << endl;
    return 0;
}
         */
    }
}
