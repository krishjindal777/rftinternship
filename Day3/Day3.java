import java.util.*;

class Question {
    String text;
    String[] options;
    int correct; 

    Question(String text, String[] options, int correct) {
        this.text = text;
        this.options = options;
        this.correct = correct;
    }

    void show() {
        System.out.println(text);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }
}

public class Day3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

     
        String[] options1 = {"Delhi", "Mumbai", "Kolkata", "Chennai"};
        Question q1 = new Question("What is the capital of India?", options1, 0);

        String[] options2 = {"Python", "Java", "C++", "Ruby"};
        Question q2 = new Question("Which language is used for Android development?", options2, 1);

        String[] options3 = {"3", "4", "5", "6"};
        Question q3 = new Question("2 + 2 = ?", options3, 1);

        
        Question[] quiz = {q1, q2, q3};

        int score = 0;

       
        for (Question q : quiz) {
            q.show();
            System.out.print("Your answer: ");
            int ans = sc.nextInt();

            if (ans - 1 == q.correct) {
                System.out.println(" Correct!\n");
                score++;
            } else {
                System.out.println(" Wrong! Correct answer: " + q.options[q.correct] + "\n");
            }
        }

        
        System.out.println("Quiz finished! Your score: " + score + "/" + quiz.length);

        sc.close();
    }
}
