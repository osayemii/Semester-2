public class Classwork1 {
    public static void main(String[] args) {
        int grade = 79;

        if(grade >= 90) grade = 'A';
        else if(grade >= 80) grade = 'B';
        else if(grade >= 70) grade = 'C';
        else if(grade >= 60) grade = 'D';
        else grade = 'F';

        switch(grade) {
            case 'A':
                System.out.println("You got an A.");
                break;
            case 'B':
                System.out.println("You got a B.");
                break;
            case 'C':
                System.out.println("You got a C.");
                break;
            case 'D':
                System.out.println("You got a D.");
                break;
            default:
                System.out.println("You got an F.");
        }
    }
}
