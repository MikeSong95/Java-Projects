// Prints out the final series of numbers where those divisible by X, Y and both 
// are replaced by “F” for fizz, “B” for buzz and “FB” for fizz buzz respectively.

// Problem From: code_eval

// Implements a recursive function

package fizzbizz;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Michael
 */
public class Main {

    public static void out (int a, int b, int n, int num){
        if (num <= n) {
            if (num % a == 0) {
                if (num % b == 0) {
                    System.out.print("FB");
                } else {
                    System.out.print("F");
                }
            } else if (num % b == 0) {
                System.out.print("B");
            } else {
                System.out.print(num);
            }
 
            if (num + 1 <= n) {
                System.out.print(" ");
            }
            
            num ++;
            
            out (a, b, n, num);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int A, B, N;

        try {
            File file = new File(args[0]);
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine() == true) {
                A = scanner.nextInt();
                B = scanner.nextInt();
                N = scanner.nextInt();
                
                out(A, B, N, 1);
                
                System.out.println();
                
                scanner.nextLine();
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }  
         
        System.exit(0);
    }
}
