Javaimport java.util.Scanner;
public class SumProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter first number: ");
            if (!sc.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a number.");
                return;
            }
            double num1 = sc.nextDouble();
            System.out.print("Enter second number: ");
            if (!sc.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a number.");
                return;
            }
            double num2 = sc.nextDouble();
            double sum = num1 + num2;
            System.out.println("Sum = " + sum);
        } finally {
            sc.close();
        }
    }
}
