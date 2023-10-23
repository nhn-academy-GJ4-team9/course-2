package org.example;

public class SubtractionQuestion implements IntQuestion {
    private int a, b;

    public SubtractionQuestion() {
        a = (int) (Math.random() * 50) + 1;
        b = (int) (Math.random() * 50);
        if (a - b < 0) {
            int tmp = a;
            a = b;
            b = tmp;
        }
    }

    @Override
    public String getQuestion() {
        return "what is " + a + " - " + b + " ? ";
    }

    @Override
    public int getCorrectAnswer() {
        return a - b;
    }
}
