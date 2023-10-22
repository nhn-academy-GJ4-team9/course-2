package com.example.fxbuild;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Ex3_8 extends Application {
    public void drawPicture(GraphicsContext g, int width, int height) {
        int row;
        int col;
        int x, y;
        for (row = 0; row < 8; row++) {
            for (col = 0; col < 8; col++) {
                x = col * 50;
                y = row * 50;
                if ((row % 2) == (col % 2))
                    g.setFill(Color.RED);
                else
                    g.setFill(Color.BLACK);
                g.fillRect(x, y, 50, 50);
            }
        }


    }

    @Override
    public void start(Stage stage) {
        int width = 400;
        int height = 400;
        Canvas canvas = new Canvas(width, height);
        drawPicture(canvas.getGraphicsContext2D(), width, height);
        BorderPane root = new BorderPane(canvas);
        root.setStyle("-fx-border-width:  4px; -fx-border-color: #444");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Simple Graphics");
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }
}


