import java.util.Scanner;
import java.util.List;

enum UserOption{
    TAKE,
    MAKE,
    YES,
    NO,
    DONE;
}

public class QuizMaker {
	private Scanner scanner;
    private int numberOfQuestions = 0;

    public QuizMaker(Scanner scanner){
        this.scanner = scanner;
    }

    public List<Question> createQuiz() {
        Quiz quiz = new Quiz();

        while (true) {
            System.out.println("\n===============================================");
            System.out.println("\n[ You are in Quiz Maker mode. Enter quiz questions. Type 'DONE' when finished. ]\n");
            System.out.println("Enter question type: {No. of questions: " +  numberOfQuestions + "}");
            System.out.println("- FlashCard");
            System.out.println("- True False");
            System.out.println("- Multiple Choice");
            System.out.println("- DONE");
            System.out.print("Choice: ");
            String questionType = scanner.nextLine().toLowerCase();

            if (questionType.equalsIgnoreCase(UserOption.DONE.toString())) {
                break;
            }

            System.out.println("\n===============================================");
            System.out.println("\nQuestion Type: " + questionType);
            System.out.print("\nEnter question: ");
            String questionText = scanner.nextLine();

            // FLASHCARD
            if (questionType.equalsIgnoreCase("flashcard")) {
                System.out.print("Enter answer: ");
                String answer = scanner.nextLine();
                System.out.println("\nQUESTION: " + questionText);
                System.out.println("ANSWER: " + answer);
                quiz.addQuestion(new FlashCard(questionText, answer));

            // TRUE OR FALSE
            } else if (questionType.equalsIgnoreCase("true false")) {
                System.out.print("Enter answer (True/False): ");
                boolean answer = Boolean.parseBoolean(scanner.nextLine());
                System.out.println("\nQUESTION: " + questionText);
                System.out.println("ANSWER: " + answer);
                quiz.addQuestion(new TrueFalseQuestion(questionText, answer));

            // MULTIPLE CHOICE
            } else if (questionType.equalsIgnoreCase("multiple choice")) {
                System.out.print("Enter number of choices: ");
                int numChoices = Integer.parseInt(scanner.nextLine());
                String[] choices = new String[numChoices];
                for (int i = 0; i < numChoices; i++) {
                    System.out.print("Enter choice " + (char) ('a' + i) + ": ");
                    choices[i] = scanner.nextLine();
                }
                System.out.print("Enter correct choice (a, b, c, ...): ");
                String correctChoice = scanner.nextLine().toLowerCase();
                int correctChoiceIndex = correctChoice.charAt(0) - 'a';
                System.out.println("\nQUESTION: " + questionText);
                System.out.println("ANSWER: " + correctChoice);
                quiz.addQuestion(new MultipleChoiceQuestion(questionText, choices, correctChoiceIndex));
            
            // INVALID INPUT
            } else {
                System.out.println("Invalid question type. Try again.");
            }
            numberOfQuestions++; // Increment the number of questions
        }

        // scanner.close();

        System.out.println("\n===============================================");
        System.out.println("Quiz creation completed. Number of questions: " + numberOfQuestions);
        return quiz.getQuestions();
    }
}
