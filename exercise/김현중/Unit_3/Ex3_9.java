package com.example.fxbuild;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Ex3_9 extends Application {
    private void drawFrame(GraphicsContext g, int frameNumber, double elapsedSeconds, int width, int height) {
        g.setFill(Color.WHITE);
        g.fillRect(0,0,width,height);
        for(int i = 0; i< height/20;i++){
            g.strokeLine(0,20*i,320,20*i);
        }

        int cyclicFrameNumber;
        cyclicFrameNumber = frameNumber % 300;
        g.setFill(Color.RED);
        g.fillRect(cyclicFrameNumber,0,20,20);

        cyclicFrameNumber = frameNumber % 150;
        g.setFill(Color.GREEN);
        g.fillRect(2*cyclicFrameNumber,20,20,20);

        cyclicFrameNumber = frameNumber % 100;
        g.setFill(Color.BLUE);
        g.fillRect(3*cyclicFrameNumber,40,20,20);

        int oscillationFrameNum;
        oscillationFrameNum = frameNumber % 600;
        if(oscillationFrameNum > 300)
            oscillationFrameNum = 600 - oscillationFrameNum;
        g.setFill(Color.CYAN);
        g.fillRect(oscillationFrameNum,60,20,20);

        oscillationFrameNum = frameNumber % 300;
        if(oscillationFrameNum > 150)
            oscillationFrameNum = 300 - oscillationFrameNum;
        g.setFill(Color.MAGENTA);
        g.fillRect(2*oscillationFrameNum,80,20,20);

        oscillationFrameNum = frameNumber % 200;
        if(oscillationFrameNum > 100)
            oscillationFrameNum = 200 - oscillationFrameNum;
        g.setFill(Color.YELLOW);
        g.fillRect(3*oscillationFrameNum,100,20,20);
    }

    @Override
    public void start(Stage stage) throws Exception {
        int width = 320;
        int height = 120;
        Canvas canvas = new Canvas(width,height);
        drawFrame(canvas.getGraphicsContext2D(),0,0,width,height);
        BorderPane root = new BorderPane(canvas);
        root.setStyle("-fx-border-width: 4px; -fx-border-color: #444");
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.setTitle("oscillation animation");
        stage.show();
        stage.setResizable(false);
        AnimationTimer anim = new AnimationTimer() {
            private int frameNum;
            private long startTime = -1;
            private long previousTime;

            @Override
            public void handle(long now) {
                if(startTime<0){
                    startTime = previousTime = now;
                    drawFrame(canvas.getGraphicsContext2D(), 0,0,width,height);
                } else if (now - previousTime > 0.95e9/60){
                    frameNum++;
                    drawFrame(canvas.getGraphicsContext2D(), frameNum,  ((now-startTime)/1e9),width,height);
                    previousTime = now;
                }
            }
        };
        anim.start();
    }

    public static void main(String[] args) {
        launch();
    }
}
