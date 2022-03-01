import java.util.HashSet;

class Solution {
    boolean[] isNotPrime;
    boolean[] visited;
    HashSet<Integer> set;
    int max = 10000000;
    int answer = 0;

    public int solution(String numbers) {
        isNotPrime = new boolean[max];
        getPrime();
        visited = new boolean[numbers.length()];
        set = new HashSet<>();
        permutation(numbers, 0);
        System.out.println(answer);
        return answer;
    }

    public void getPrime() {
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for (int i = 2; i < max; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * 2; j < max; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
    }

    public void permutation(String numbers, int num) {
        if (set.add(num)) {
            if (!isNotPrime[num]) {
                answer++;
            }
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(numbers, num * 10 + numbers.charAt(i) - '0');
                visited[i] = false;
            }
        }
    }
}
