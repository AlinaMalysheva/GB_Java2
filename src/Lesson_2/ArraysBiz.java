package Lesson_2;

/*1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4,
при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение MyArrayDataException – с детализацией, в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException и вывести результат расчета.
 */

import java.sql.SQLOutput;
import java.util.Arrays;

public class ArraysBiz {
    public static void main(String[] args) throws MyArraySizeException {
        int x = 4;
        int y = 4;
        String[][] my_array = new String[][]{{"1", "1", "1", "1"}, {"0", "0", "0", "0"}, {"1", "1", "1", "1"}};
        String[][] my_array1 = new String[][]{{"1"}, {"0", "0", "0", "0"}, {"1", "1", "1", "1"}, {"0", "0","0", "0"}};
        String[][] my_array2 = new String[][]{{"привет", "1", "1", "1"}, {"0", "0", "0", "0"}, {"1", "1", "1", "1"}, {"0", "0","0", "0"}};
        String[][] my_array3= new String[][]{{"1", "1", "1", "1"}, {"0", "0", "0", "0"}, {"1", "1", "1", "1"}, {"0", "0","0", "0"}};
        try {
            theMethod(my_array, x, y);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            theMethod(my_array1, x, y);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            theMethod(my_array2, x, y);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            theMethod(my_array3, x, y);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void theMethod(String[][] _strArr, int _sizeX, int _sizeY) throws MyArraySizeException, MyArrayDataException {
        System.out.println("\nОбработка нового массива.");
        if (_strArr.length != _sizeX) {
            String answer = ("Некорректный размер внешнего массива. Требуемый размер " + _sizeX + "*" + _sizeY);
            throw new MyArraySizeException(answer);
        } else {
            int theSum=0;
            for (String[] mini_array : _strArr) {
                if (mini_array.length != _sizeY) {
                    String answer2 = (String.format("Некорректный размер %d внутреннего массива. Требуемый размер %d*%d", Arrays.asList(_strArr).indexOf(mini_array) + 1, _sizeX, _sizeY));
                    throw new MyArraySizeException(answer2);
                } else {
                    System.out.println("Ok with " + (Arrays.asList(_strArr).indexOf(mini_array) + 1) + "array");

                    /*int i = Integer.parseInt("234");*/
                    for (String el : mini_array) {
                        try {
                            int i = Integer.parseInt(el);
                            theSum+=i;
                        } catch (NumberFormatException e) {
                            throw new MyArrayDataException(el, (Arrays.asList(_strArr).indexOf(mini_array)), (Arrays.asList(mini_array).indexOf(el)));
                        }
                    }
                }
            }
            System.out.println("Сумма всех элементов " + theSum);
        }
    }
}
