class Solution {
    public int gcd(int a, int b) {
        int r = a % b;
        
        while (r != 0) {
            a = b;
            b = r;
            r = a % b;
        }
        return b;
    }
    
    public long solution(int w, int h) {
        return (long)w * h - (w + h - gcd(w, h));
    }
}

// https://hidelookit.tistory.com/251
