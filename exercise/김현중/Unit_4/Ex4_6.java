package com.example.fxbuild;


public class Ex4_6 {

    final static int ROWS = 80;
    final static int COLUMNS = 80;
    final static int SQUARE_SIZE = 5;

    static int currentRow;
    static int currentColumn;


    public static void main(String[] args) {
        Mosaic.open( ROWS, COLUMNS, SQUARE_SIZE, SQUARE_SIZE );
        Mosaic.setUse3DEffect(false);
        currentRow = ROWS / 2;
        currentColumn = COLUMNS / 2;
        while (true) {
            changeToGreen(currentRow, currentColumn);
            randomMove();
        }
    }




    static void changeToGreen(int rowNum,int colNum){
        int green = Mosaic.getGreen(rowNum,colNum);
        green += 25;
        if(green>255)
            green = 255;
        Mosaic.setColor(rowNum,colNum,0,green,0);
    }

    static void randomMove() {
        int directionNum;
        directionNum = (int)(4*Math.random());
        switch (directionNum) {
            case 0 : {  // move up
                currentRow--;
                if (currentRow < 0)
                    currentRow = ROWS - 1;
            }
            case 1 : {  // move right
                currentColumn++;
                if (currentColumn >= COLUMNS)
                    currentColumn = 0;
            }
            case 2 : {  // move down
                currentRow ++;
                if (currentRow >= ROWS)
                    currentRow = 0;
            }
            case 3 : {  // move left
                currentColumn--;
                if (currentColumn < 0)
                    currentColumn = COLUMNS - 1;
            }
        }
    }
}