// https://yuhe-dogspaw.tistory.com/76
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int max = 0;
        int[] d = new int[n + 1];
        int[] a = new int[n + 1];

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            d[i] = 1;
        }

        for(int i = 0; i < n ; i++) {
            for(int j = 0 ; j< = i ; j++) {
                if(a[j] < a[i] && d[j] >= d[i]) {
                    d[i] = d[j] + 1;
                }
            }
        }

        for(int i = 0; i < n ; i++) {
            if(d[i] > max)
                max = d[i];
        }

        System.out.println(max);

    }
}
