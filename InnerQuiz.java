import java.util.*;

class Question {
    String QuestionText;
    String[] option;
    char correctans;

    Question(String QuestionText, String[] option, char useranswer) {
        this.QuestionText = QuestionText;
        this.option = option;
        this.correctans = useranswer;
        ;
    }

    void display() {
        System.out.println("\n" + QuestionText);
        char optionName = 'A';
        for (String option : option) {
            System.out.println(optionName + "." + option);
            optionName++;
        }
    }

    boolean Questionasw(char useranswer) {
        return Character.toUpperCase(useranswer) == correctans;
    }
}

class Quiz {

    // create object to store our question
    List<Question> questions;

    // here we store our question 
    Quiz() {
        questions = new ArrayList<>();
    }
    // create function to add question
    void addQuestion(Question q) {
        questions.add(q);
    }

    void StartQuiz() {
        Scanner input = new Scanner(System.in);
        int score = 0;

        for (Question q : questions) {
            q.display();
            System.out.println("\n enter your answer (A/B/C/D)");
            char userinput = input.next().charAt(0);
            // check the answer
            if (q.Questionasw(userinput)) {
                System.out.println("correct answer");
                score++;
            }
            else {
                System.out.println("Wrong answer");
            }
            System.out.println("\n your score " + score + " "+ questions.size());
        }
    }
    
}

public class InnerQuiz {

    public static void main(String[] args) {

        Quiz quiz = new Quiz();

        quiz.addQuestion(new Question(
            "What is Java?",
            new String[]{"Programming Language", "Animal", "Car", "Game"},
            'A'
        ));

        quiz.addQuestion(new Question(
            "Which keyword creates object?",
            new String[]{"this", "new", "class", "void"},
            'B'
        ));

        quiz.StartQuiz();
    }
}