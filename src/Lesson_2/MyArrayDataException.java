package Lesson_2;

public class MyArrayDataException extends RuntimeException {

 // String answer;

    public MyArrayDataException(String el, int X, int Y) {
        super(String.format("В ячейке %d%d не число, а '%s'", (X + 1), (Y + 1), el));
    }


   /*public void getAnswer() {
        System.out.println(answer);
    }*/
}

