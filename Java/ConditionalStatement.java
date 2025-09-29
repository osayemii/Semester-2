public class ConditionalStatement {
    public static void main(String[] args){
        // if statement
        int age = 18;
        if(age >= 18){
            System.out.println("You are eligible to vote.");
        }

        // if-else statement
        int age2 = 18;
        if(age2 >= 18){
            System.out.println("You are eligible to vote.");
        } else {
            System.out.println("You are not eligible to vote.");
        }

        // if-else-if ladder
        int grade = 85;
        if(grade >= 90){
            System.out.println("You got an A.");
        } else if(grade >= 80){
            System.out.println("You got a B.");
        } else if(grade >= 70){
            System.out.println("You got a C.");
        } else {
            System.out.println("You need to improve.");
        }

        // nested if statement
        int score = 59;
        if(score >= 50){
            if(score >= 90){
                System.out.println("You got an A.");
            } else if(score >= 80){
                System.out.println("You got a B.");
            } else if(score >= 70){
                System.out.println("You got a C.");
            } else {
                System.out.println("Average.");
            }
        } else {
            System.out.println("You failed.");
        }

        // switch-case statement
        int score2 =  58;
        switch(score2){
            case 90:
                System.out.println("You got an A.");
                break;
            case 80:
                System.out.println("You got a B.");
                break;
            case 70:
                System.out.println("You got a C.");
                break;
            default:
                System.out.println("You need to improve.");
        }
    }
}