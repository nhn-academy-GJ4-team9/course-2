package Ex_07;


public class SubtractionQuestion implements IntQuestion {
    private int a, b;
    public SubtractionQuestion() {
        a = (int)(Math.random() * 50 + 1);
        b = (int)(Math.random() * 50);
        if (b > a) {swap();}
    }
    public void swap() {
        int temp = this.a;
        this.a = this.b;
        this.b = temp;
    }
    public String getQuestion() {
        return  a + " - " + b + ": " ;
    }
    public int getCorrectAnswer() {
        return a - b;
    }
}