package org.example;

public class Ex1 {
    public static void main(String[] args) {

        Counter c = new Counter();
        a th1 = new a(c);
        b th2 = new b(c);

        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println(c.getCount());
    }
}


class a extends Thread{
    private Counter c;
    public a(Counter c) {
        this.c=c;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            c.inc();
        }

    }
}

class b extends Thread{
    private Counter c;
    public b(Counter c) {
        this.c=c;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            c.inc();
        }

    }
}

class Counter {
    int count;

    void inc() {
        count = count + 1;
    }

    int getCount() {
        return count;
    }
}