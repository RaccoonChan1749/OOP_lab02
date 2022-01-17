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
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String inPath = ".\\file\\inputArray.txt";
        String outPath = ".\\file\\outputArray.txt";

        int size = 0;
        double range = 0;
        boolean correct = false;

        while (!correct) {
            System.out.printf("\nВведите размер матрицы: ");
            try {
                size = in.nextInt();
                correct = true;
            } catch (InputMismatchException ex) {
                System.out.printf("Ошибка! Некорректный ввод пункта меню!\n");
                in.nextLine();
                correct = false;
            }

            if (correct) {
                System.out.printf("Введите границы значений матрицы [-N,N]: ");
                try {
                    range = in.nextDouble();
                    in.nextLine();
                    correct = true;
                } catch (InputMismatchException ex) {
                    System.out.printf("Ошибка! Некорректный ввод пункта меню!\n");
                    in.nextLine();
                    correct = false;
                }
            }
        }

        ArraySquare array;
        array = new ArraySquare(size, range);
        array.printArray(inPath, "", false, true);

        array = new ArraySquare(inPath);
        array.printArray(outPath, "Начальный массив:", false, false);

        array.turn90();
        array.printArray(outPath, "Поворот на 90:", true, false);

        array.turn180();
        array.printArray(outPath, "Поворот на 180:", true, false);

        array.turn270();
        array.printArray(outPath, "Поворот на 270:", true, false);

        array.division();
        array.printArray(outPath, "Деление:", true, false);
    }
}


