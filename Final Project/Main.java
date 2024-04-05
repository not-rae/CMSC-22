import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class Main {
	
	public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Question> createdQuestions = new ArrayList<>();

        while (true){
            displayWelcomeMessage();

            String option = getUserChoice(scanner);

            if (option.equalsIgnoreCase(UserOption.MAKE.toString())) {
                QuizMaker quizMaker = new QuizMaker(scanner);
                createdQuestions = quizMaker.createQuiz();

                if (askToTakeQuiz(scanner)){
                    playQuiz(createdQuestions, scanner);
                } else {
                    System.out.println("Thanks for playing! Goodbye!");
                    break;
                }
            } else if (option.equalsIgnoreCase(UserOption.TAKE.toString())){
                playQuiz(createdQuestions, scanner);
            } else {
                System.out.println("Invalid option. Please choose 'TAKE' or 'MAKE");
            }

            if (!askToPlayAgain(scanner)){
                System.out.println("Thanks for Playing! Goodbye!");
                break;
            }

            
        }

        scanner.close();

    }

    private static void displayWelcomeMessage(){
        System.out.println("\nWelcome to the NeuroTandemNinja: FlashCard Thunder!");
        System.out.println("\nDo you want to take a quiz or make a quiz?");
        System.out.println("- TAKE");
        System.out.println("- MAKE");
        System.out.print("Choice: ");
    }

    private static String getUserChoice(Scanner scanner){
        return scanner.nextLine().toLowerCase();
    }

    private static boolean askToTakeQuiz(Scanner scanner){
        System.out.println("\nDo you want to take the quiz you just created?");
        System.out.println("- " + UserOption.YES);
        System.out.println("- " + UserOption.NO);
        System.out.print("Choice: ");
        return scanner.nextLine().equalsIgnoreCase(UserOption.YES.toString());
    }

    private static boolean askToPlayAgain(Scanner scanner){
        System.out.println("Do you want to play again? (yes/no): ");
        try {
            String input = scanner.nextLine();
            return input.equalsIgnoreCase(UserOption.YES.toString());
        } catch (NoSuchElementException e) {
            System.out.println("Error reading input. Assuming 'no'.");
            return false;
        }
//        return scanner.nextLine().equalsIgnoreCase(UserOption.YES.toString());
    }

    private static void playQuiz(List<Question> questions, Scanner scanner){
        Quiz quiz = new Quiz(questions);
        quiz.startQuiz();       
        quiz.displayScore(); 
    }  
}
