import java.util.Scanner;
import java.util.InputMismatchException;

public class Tester {

   public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
      double voltageLevel;

      while (scnr.hasNext()) {
         try {
            voltageLevel = scnr.nextDouble();

            if (voltageLevel >= 3.2) {
               System.out.println("High");
            }
            else if (voltageLevel >= 0.0 && voltageLevel <= 1.5) {
               System.out.println("Low");
            }
            else {
               System.out.println("xx");
            }
         }
         catch (InputMismatchException excpt) {
            System.out.println("Input is invalid");
            scnr.next();
         }
      }
   }
}