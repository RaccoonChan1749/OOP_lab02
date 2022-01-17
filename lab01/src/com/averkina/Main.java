package com.averkina;
import java.util.Scanner;

/*
Аверкина Е.К.
в3530904/90322

Лабораторная_1
В компьютерной игре герой (класс Hero) может перемещаться между двумя точками (метод move) различными способами:
идти пешком, ехать на лошади, лететь и т.п..
Реализовать классы, позволяющие выбирать и менять в ходе выполнения программы способ перемещения героя,
используя паттерн “стратегия” (strategy). Продемонстрировать работу реализованных классов.
*/

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int menu = 0;
        String onePoint = "";
        String twoPoint = "";
        int type = 1;
        String typeName = "walking";
        Context way = new Context(typeName);

        while(menu < 3) {
            System.out.printf("------------------------------------------");
            System.out.printf("\nТекущий способ перемещения: %s",typeName);
            System.out.printf("\nМеню:");
            System.out.printf("\n1.Выбрать способ перемещения");
            System.out.printf("\n2.Отправиться");
            System.out.printf("\n3.Выход");
            System.out.printf("\nВведите пункт меню: ");

            try {
                menu = in.nextInt();
                if(menu < 1 || menu > 3) {
                    throw new Exception();
                }
                in.nextLine();
            }
            catch(Exception ex) {
                System.out.printf("Ошибка! Некорректный ввод пункта меню!\n");
                menu = 0;
                in.nextLine();
            }
            System.out.printf("------------------------------------------\n");

            if(menu == 1) {
                while(menu != 0) {
                    System.out.printf("------------------------------------------");
                    System.out.printf("\nДопустимые способы перемещения:");
                    System.out.printf("\n1.Пешком");
                    System.out.printf("\n2.На велосипеде");
                    System.out.printf("\n3.На общественном транспорте");
                    System.out.printf("\n4.На автомобиле");
                    System.out.printf("\n5.На самолете");
                    System.out.printf("\nВведите номер способа перемещения: ");

                    try {
                        type = in.nextInt();
                        if(type < 1 || type > 5) {
                            throw new Exception();
                        }

                        switch (type) {
                            case 1 -> typeName = "walking";
                            case 2 -> typeName = "cycling";
                            case 3 -> typeName = "transit";
                            case 4 -> typeName = "driving";
                            case 5 -> typeName = "flights";
                        }
                        way = new Context(typeName);
                        in.nextLine();
                        menu = 0;
                    }
                    catch(Exception ex) {
                        System.out.printf("Ошибка! Некорректный ввод способа перемещения!\n");
                        in.nextLine();
                    }
                    System.out.printf("------------------------------------------\n");
                }
            }

            if(menu == 2) {
                System.out.printf("------------------------------------------");
                System.out.printf("\nВведите пункт отправки: ");
                onePoint = in.nextLine();
                System.out.printf("Введите пункт назначения: ");
                twoPoint = in.nextLine();
                way.move(onePoint,twoPoint);
                System.out.printf("\n------------------------------------------\n");
            }
        }
    }
}
