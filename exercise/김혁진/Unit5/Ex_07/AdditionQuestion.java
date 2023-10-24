package Ex_07;

public class AdditionQuestion implements IntQuestion {

    private int a, b;  // The numbers in the problem.

    public AdditionQuestion() {
        a = (int)(Math.random() * 50 + 1);
        b = (int)(Math.random() * 50);
    }

    public String getQuestion() {
        return  a + " + " + b + ": " ;
    }

    public int getCorrectAnswer() {
        return a + b;
    }

}