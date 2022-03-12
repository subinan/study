import java.util.Scanner;

public class Main {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = 99;

        N = sc.nextInt();
        if (N < 100)
            ans = N;
        else {
            for (int i = 101; i <= N; i++) {
                if (i / 100 - i % 100 / 10 == i % 100 / 10 - i % 100 % 10)
                    ++ans;
            }
        }
        System.out.println(ans);
    }
}
