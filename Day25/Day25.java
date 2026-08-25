import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int rollNo;

    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }
}

class Question {
    String question;
    String[] options;
    int correctAnswer;

    Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    void displayQuestion() {
        System.out.println(question);

        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }
}

class Quiz {
    ArrayList<Question> questions = new ArrayList<>();
    int score = 0;

    void addQuestion(Question question) {
        questions.add(question);
    }

    void startQuiz() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n----- QUIZ STARTED -----");

        for (int i = 0; i < questions.size(); i++) {

            System.out.println("\nQuestion " + (i + 1));

            Question q = questions.get(i);
            q.displayQuestion();

            System.out.print("Enter your answer: ");
            int answer = sc.nextInt();

            if (answer == q.correctAnswer) {
                System.out.println("Correct Answer");
                score++;
            } else {
                System.out.println("Wrong Answer");
            }
        }
    }
}

class Result {
    Student student;
    int score;
    int totalQuestions;

    Result(Student student, int score, int totalQuestions) {
        this.student = student;
        this.score = score;
        this.totalQuestions = totalQuestions;
    }

    void displayResult() {
        System.out.println("\n----- RESULT SUMMARY -----");
        System.out.println("Student Name: " + student.name);
        System.out.println("Roll Number: " + student.rollNo);
        System.out.println("Total Questions: " + totalQuestions);
        System.out.println("Correct Answers: " + score);
        System.out.println("Score: " + score + "/" + totalQuestions);

        double percentage = (score * 100.0) / totalQuestions;

        System.out.println("Percentage: " + percentage + "%");

        if (percentage >= 40) {
            System.out.println("Status: Pass");
        } else {
            System.out.println("Status: Fail");
        }
    }
}

public class Day25 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your roll number: ");
        int rollNo = sc.nextInt();

        Student student = new Student(name, rollNo);

        Quiz quiz = new Quiz();

        String[] options1 = {"Paris", "London", "Delhi", "Tokyo"};
        Question q1 = new Question(
                "What is the capital of France?",
                options1,
                1
        );

        String[] options2 = {"Hyper Text Markup Language", "High Text Machine Language",
                "Hyper Tool Markup Language", "Home Text Markup Language"};

        Question q2 = new Question(
                "What is the full form of HTML?",
                options2,
                1
        );

        String[] options3 = {"Java", "Python", "C++", "All of these"};

        Question q3 = new Question(
                "Which of the following is a programming language?",
                options3,
                4
        );

        quiz.addQuestion(q1);
        quiz.addQuestion(q2);
        quiz.addQuestion(q3);

        quiz.startQuiz();

        Result result = new Result(
                student,
                quiz.score,
                quiz.questions.size()
        );

        result.displayResult();

        sc.close();
    }
}