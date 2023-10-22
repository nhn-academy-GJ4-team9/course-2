package com.example.fxbuild;

import javafx.scene.paint.Color;

public class Ex4_7 {
    final static int ROWS = 40;
    final static int COLUMNS = 40;
    final static int SQUARE_SIZE = 10;

    static int currentRow;
    static int currentColumn;
    public static void main(String[] args) {
        Mosaic.setUse3DEffect(false);
        Mosaic.open(ROWS, COLUMNS, SQUARE_SIZE, SQUARE_SIZE);
        fillWithRandomColors();

        while (true) {
           int row = (int) (ROWS* Math.random());
           int col = (int) (COLUMNS*Math.random());
           changeNearColor(row,col);
        }
    }
    static void fillWithRandomColors() {
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                changeToRandomColor(row, column);
            }
        }
    }
    static void changeNearColor(int rowNum,int colNum){
        int red = Mosaic.getRed(rowNum,colNum);
        int green = Mosaic.getGreen(rowNum,colNum);
        int blue = Mosaic.getBlue(rowNum,colNum);
        int directionNum;

        directionNum = (int) (4 * Math.random());
        switch (directionNum) {
            case 0 :{
                rowNum--;
                if(rowNum<0)
                    rowNum = ROWS-1;
            }
            case 1 :{
                rowNum++;
                if(rowNum>=ROWS)
                    rowNum=0;
            }
            case 2 :{
                colNum--;
                if(colNum<0)
                    colNum = COLUMNS-1;
            }
            case 3:{
                colNum++;
                if(colNum>=COLUMNS)
                    colNum=0;
            }
        }
        Mosaic.setColor(rowNum,colNum,red,green,blue);


    }


    static void changeToRandomColor(int rowNum, int colNum) {
        int red = (int) (256 * Math.random());    // Choose random levels in range
        int green = (int) (256 * Math.random());  //     0 to 255 for red, green,
        int blue = (int) (256 * Math.random());   //     and blue color components.
        Mosaic.setColor(rowNum, colNum, red, green, blue);
    }


    static void randomMove() {
        int directionNum;
        directionNum = (int) (4 * Math.random());
        switch (directionNum) {
            case 0: {
                currentRow--;
                if (currentRow < 0)
                    currentRow = ROWS - 1;
            }
            case 1: {
                currentColumn++;
                if (currentColumn >= COLUMNS)
                    currentColumn = 0;
            }
            case 2: {
                currentRow++;
                if (currentRow >= ROWS)
                    currentRow = 0;
            }
            case 3: {
                currentColumn--;
                if (currentColumn < 0)
                    currentColumn = COLUMNS - 1;
            }
        }
    }

}