package org.example;

public class Ex5_6 {

    public static void main(String[] args) {

        AdditionQuestion[] questions = new AdditionQuestion[10];
        for (int i = 0; i < 10; i++) {
            questions[i] = new AdditionQuestion();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i].getQuestion());
            System.out.println("Correct Answer: " + questions[i].getCorrectAnswer());
            System.out.println();
        }
    }
}

class AdditionQuestion {
    private int a, b;

    public AdditionQuestion() {
        a = (int)(Math.random() * 50 + 1);
        b = (int)(Math.random() * 50);
    }

    public String getQuestion() {
        return "What is " + a + " + " + b + " ?";
    }

    public int getCorrectAnswer() {
        return a + b;
    }
}

