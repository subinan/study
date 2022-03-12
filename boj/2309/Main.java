import java.util.Scanner;

public class Main {
    static int N = 9;
    static int[] height = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      
        int sum = 0;
        for (int i = 0; i < N; i++) {
            height[i] = sc.nextInt();
            sum += height[i];
        }

        // 정렬
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (height[i] > height[j]) {
                    int tmp = height[i];
                    height[i] = height[j];
                    height[j] = tmp;
                }
            }
        }
    
        // 브루트포스
        for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (sum - height[i] - height[j] == 100) {
					for (int k = 0; k < N; k++) {
						if (i == k || j == k) {
							continue;
						}
						System.out.println(height[k]);
					}
					System.exit(0);
				}
			}
		}
    }
}
