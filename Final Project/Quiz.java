import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
//import java.util.ArrayList;
//import java.util.Scanner;

public class Quiz {
		Reader cardReader;
		Scanner sc;
		ArrayList<FlashCard> cards;
		ArrayList<String> userAnswers;
		int questionsAttempted = 0;
		private List<Question> questions = new ArrayList<>();
	    private Scanner scanner = new Scanner(System.in);
	    private int score = 0;

	    // Add this method to the Quiz class
	    public void addQuestion(Question question) {
	        questions.add(question);
	    }

	    public Quiz(List<Question> prePopulatedQuestions) {
	        this();
	        questions.addAll(prePopulatedQuestions);
	    }

	    public Quiz(){
	    	cardReader = new Reader();
	    	cards = cardReader.getFlashCards();
	    	sc = new Scanner(System.in);
	    	startQuiz();
	    }

	    private void loadQuestionsFromFile(String filePath) {
	        try (Scanner fileScanner = new Scanner(new File(filePath))) {
	            while (fileScanner.hasNextLine()) {
	                String questionText = fileScanner.nextLine();
	                String answer = fileScanner.nextLine();
	                Question question = new Question(questionText, answer);
	                addQuestion(question);
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("Error: File not found.");
	        }
	    }

	    // Modify startQuiz to use the questions loaded from the file
	    public void startQuiz() {
	        String input;
	        userAnswers = new ArrayList<>();
	        System.out.println("\n===============================================");
	        System.out.println("Quiz\n");

	        // Randomly shuffle the questions before starting the quiz
	        Collections.shuffle(questions);

	        for (int i = 0; i < questions.size(); i++) {
	            questionsAttempted++;

	            System.out.println("== Question " + (i + 1) + " ==");

	            // Use the question text instead of FlashCard's question
	            System.out.println(questions.get(i).getQuestion());

	            input = sc.nextLine();

	            if (input.equals(questions.get(i).getAnswer())) {
	                System.out.println("Correct!");
	                score++;

	                // Stores current question and the user's answer separated by a comma.
	                userAnswers.add(questions.get(i).getQuestion() + "," + input + ",right");
	            } else {
	                System.out.println("Incorrect, the actual answer is: " + questions.get(i).getAnswer());
	                userAnswers.add(questions.get(i).getQuestion() + "," + input + ",wrong");
	            }
	        }

	        // ... (remaining code remains the same)
	    }
	    
	    public static void main(String[] args) {
	        // Create a Quiz instance and load questions from a file
	        Quiz quiz = new Quiz();
	        quiz.loadQuestionsFromFile("questions.txt");

	        // Start and play the quiz
	        quiz.startQuiz();
	        quiz.displayScore();
	    }

}
