public class Operations {
    
    public static void main(String[] args) {
        // numeric data and operations
        int a = 5;
        int b = 10;
        int sum = a + b;
        int difference = a - b;
        int product = a * b;
        double quotient = (double) b / a;
        int remainder = a % b;

        //Byte Operations
        byte byte1 = 5;
        byte byte2 = 10;
        byte byteSum = (byte) (byte1 + byte2);
        byte byteDifference = (byte) (byte1 - byte2);
        byte byteProduct = (byte) (byte1 * byte2);
        double byteQuotient = (double) byte2 / byte1;
        int byteRemainder = byte1 % byte2;

        print("Hello, World!");
        print("Sum: " + sum);
        print("Difference: " + difference);
        print("Product: " + product);
        print("Quotient: " + quotient);
        print("Remainder: " + remainder);

        print("Byte Sum: " + byteSum);
        print("Byte Difference: " + byteDifference);
        print("Byte Product: " + byteProduct);
        print("Byte Quotient: " + byteQuotient);
        print("Byte Remainder: " + byteRemainder);
    }

    public static void print(String message) {
        System.out.println(message);
    }
    public static void print(int number) {
        System.out.println(number);
    }
    public static void print(double number) {
        System.out.println(number);
    }
    public static void print(float value) {
        System.out.println(value);
    }
    public static void print(char character) {
        System.out.println(character);
    }
}
