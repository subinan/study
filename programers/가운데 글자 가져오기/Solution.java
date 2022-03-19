class Solution {
    public String solution(String s) {
        int mid = s.length() / 2;
        Boolean even = s.length() % 2 == 0 ? true : false;

        return even ? s.substring(mid - 1, mid + 1) : s.substring(mid, mid + 1);
    }
}
