package com.averkina;

import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class ArraySquare {
    private int size;
    private double array[][];

    public ArraySquare(int size, double range) {
        Random random = new Random();
        array = new double[size][size];
        try {
            if (size > 1000000) throw new MaxValueException();
            this.size = size;
        } catch (MaxValueException e) {
            System.out.println(e.toString());
            return;
        }

        try {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    array[i][j] = -range + 2 * range * random.nextDouble();
                }
            }
        } catch (OutOfMemoryError e) {
            System.out.println("Ошибка! Произошла нехватка памяти!");
        }
    }
    public ArraySquare(int size, double rangeMin, double rangeMax) {
        Random random = new Random();
        array = new double[size][size];
        try {
            if (size > 1000000) throw new MaxValueException();
            this.size = size;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    array[i][j] = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
                }
            }
        } catch (MaxValueException | OutOfMemoryError e) {
            e.printStackTrace();
        }
    }
    public ArraySquare(String pathName) {
        int row = 0;
        int column = 0;

        try (Scanner in = new Scanner(new File(pathName))) {

            this.size = in.nextInt();
            if (size > 1000000) throw new MaxValueException();

            this.array = new double[this.size][this.size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    try {
                        this.array[i][j] = in.nextDouble();
                    } catch (NoSuchElementException e) {
                        System.out.println("Ошибка! В файле не хватает элементов матрицы!");
                        return;
                    }
                }
            }
        } catch (NoSuchElementException | MaxValueException | OutOfMemoryError | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printArray(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.printf("%.3f\t",array[i][j]);
            }
            System.out.println();
        }
    }
    public void printArray(String pathName, String message, boolean isAppend, boolean isSize) {
        try(BufferedWriter out = new BufferedWriter(new FileWriter(pathName, isAppend))){
            if (isAppend) out.newLine();
            if (!isSize) out.write(message);
            else out.write(Integer.toString(size));
            out.newLine();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    out.write(String.format("%.3f\t", array[i][j]));
                }
                out.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void turn90() {
        double arrayNew[][] = new double[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                arrayNew[size-i-1][j] = array[i][j];
            }
        }
        array = arrayNew;
    }
    public void turn180() {
        double arrayNew[][] = new double[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                arrayNew[size-i-1][size-j-1] = array[i][j];
            }
        }
        array = arrayNew;
    }
    public void turn270() {
        double arrayNew[][] = new double[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                arrayNew[i][size-j-1] = array[i][j];
            }
        }
        array = arrayNew;
    }
    public void division() {
        double sum = 0;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                sum = 0;
                if(i!=0) sum += array[i-1][j];
                if(i+1!=size) sum += array[i+1][j];
                if(j!=0) sum += array[i][j-1];
                if(j+1!=size) sum += array[i][j+1];

                try {
                    if (sum == 0) throw new ZeroException();
                    array[i][j] = array[i][j]/sum;
                }
                catch(ZeroException e)
                {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

}
