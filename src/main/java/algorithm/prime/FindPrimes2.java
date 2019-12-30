package algorithm.prime;

import static java.lang.Math.floor;
import static java.lang.Math.sqrt;

/**
 * @Author ZhangGJ
 * @Date 2019/12/31 07:27
 */
public class FindPrimes2 {
    public static void main(String[] args) {
        int max = 100;
        // Get the max value from the command line,
        // if the argument has been provided:
        if (args.length != 0) {
            max = Integer.parseInt(args[0]);
        }
        boolean[] sieve = new boolean[max + 1];
        int limit = (int) floor(sqrt(max));
        System.out.println(1 + " ");
        if (max > 1) {
            System.out.println(2 + " ");
        }
        // Detect prime numbers
        for (int i = 3; i <= limit; i += 2) {
            if (!sieve[i]) {
                for (int j = 2 * i; j <= max; j += i) {
                    sieve[j] = true;
                }
            }
        }
        // Print prime numbers
        for (int i = 3; i <= max; i += 2) {
            if (!sieve[i]) {
                System.out.println(i + " ");
            }
        }
    }
}
