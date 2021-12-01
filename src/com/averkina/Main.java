package com.averkina;

/*
Аверкина Е.К.
в3530904/90322

Лабораторная_2
Написать консольное приложение, которое:
1.Считывает из текстового файл размерность матрицы N*N.
2.Создаёт и заполняет матрицу случайными числами от -N до N.
3.Последовательно поворачивает матрицу на 90, 180 и 270 градусов против часовой стрелки и делит каждый
элемент на сумму соседних.
4.Каждую из трёх получившихся матриц вывести в общий файл

Требования к обработке исключительных ситуаций:
1.контролировать состояние потоков ввода/вывода (отсутствие записи в файле, недопустимые значения, etc);
2.генерировать и обрабатывать исключение при некорректных математических операциях;
3.выбрасывать исключение при нехватке памяти;
4.реализовать собственные классы исключений для случаев:
    a.деление на 0
    b.файл не существует
    c.N > 1_000_000
*/

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            String in = "C:\\5\\OOP\\lab02\\inputArray.txt";
            String out = "C:\\5\\OOP\\lab02\\outputArray.txt";

            ArraySquare array;
            array = new ArraySquare(10, 100);
            array.PrintArray(in, "", false, true);

            array = new ArraySquare(in);
            array.PrintArray(out, "Начальный массив:", false, false);

            array.Turn90();
            array.PrintArray(out, "Поворот на 90:", true, false);

            array.Turn180();
            array.PrintArray(out, "Поворот на 180:", true, false);

            array.Turn270();
            array.PrintArray(out, "Поворот на 270:", true, false);

            array.Division();
            array.PrintArray(out, "Деление:", true, false);
        } catch (OutOfMemoryError e) {
            System.out.println("Ошибка! Произошла нехватка памяти!");
        }
    }
}


