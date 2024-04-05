interface Question {
    String getQuestion();
    String getAnswer();
    boolean checkAnswer(String userAnswer);
}

class FlashCard implements Question {
    private String question;
    private String answer;

    public FlashCard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    @Override
    public String getQuestion() {
        return question + " (FLASHCARD)";
    }

    @Override
    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        return userAnswer.equalsIgnoreCase(answer);
    }
}

class TrueFalseQuestion implements Question {
    private String question;
    private boolean answer;

    public TrueFalseQuestion(String question, boolean answer) {
        this.question = question;
        this.answer = answer;
    }

    @Override
    public String getQuestion() {
        return question + " (TRUE or FALSE)";
    }

    @Override
    public String getAnswer() {
        return String.valueOf(answer);
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        return Boolean.toString(answer).equalsIgnoreCase(userAnswer);
    }
}

class MultipleChoiceQuestion implements Question {
    private String question;
    private String[] choices;
    private int correctChoice;

    public MultipleChoiceQuestion(String question, String[] choices, int correctChoice) {
        this.question = question;
        this.choices = choices;
        this.correctChoice = correctChoice;
    }

    @Override
    public String getQuestion() {
        StringBuilder questionString = new StringBuilder(question + " (MULTIPLE CHOICE)\n");
        for (int i = 0; i < choices.length; i++) {
            questionString.append((char) ('a' + i)).append(") ").append(choices[i]).append("\n");
        }
        return questionString.toString();
    }

    @Override
    public String getAnswer() {
        return String.valueOf((char) ('a' + correctChoice));
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        return userAnswer.equalsIgnoreCase(getAnswer());
    }
}

