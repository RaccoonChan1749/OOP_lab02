package com.averkina;

import com.averkina.family04.Cricetidae;
import com.averkina.genus05.Phodopus;
import com.averkina.phylum01.Chordate;
import com.averkina.species06.PhodopusRoborovskii;
import com.averkina.species06.PhodopusSungorus;

/*
1. Создайте иерархию животного царства на свое усмотрение - выбираем один тип (простейшие/губки/хордовые и т.д.)
,а далее наследуйте классы, отряды, семейства, роды и виды - должна получиться иерархия в 6 уровней
,выбор животных на ваш вкус, особо много создавать не нужно.
2. Создаем generic класс Queue, представляющий из себя очередь фиксированного размера со стандартными методами очереди - add и get
3. Создаем методы produce и consume - первый метод должен возвращать upper bound generic очередь
(например наследники позвоночных) которая будет генерироваться на ваше усмотрение и подаваться во второй метод,
который будет их раcпределять в lower bound очередь - (например родители кошек)
4. Демонстрируем работу всех методов на конкретных собственных кейсах
*/

public class Main {

    public static void main(String[] args) {
        Queue<? extends Cricetidae> produceList = produce();

        System.out.println("Работа produce():");
        for (Object o : produceList) {
            System.out.println(o.toString());
        }
        System.out.println();

        Queue<? super Phodopus> consumeList = consume(produceList);
        System.out.println("Работа consume():");
        for (Object o : consumeList) {
            System.out.println(o.toString());
        }
    }

    private static Queue<? extends Cricetidae> produce() {
        Queue<Cricetidae> cricetidaeQueue = new Queue<>(4);

        cricetidaeQueue.add(new Cricetidae());
        cricetidaeQueue.add(new Phodopus());
        cricetidaeQueue.add(new PhodopusRoborovskii());
        cricetidaeQueue.add(new PhodopusSungorus());

        return cricetidaeQueue;
    }

    private static Queue<? super Phodopus> consume(Queue<? extends Chordate> list) {
        Queue<Object> result = new Queue<>(list.size());

        while (list.size() > 0) {
            Object obj = list.get();
            // isAssignableFrom проверяет является ли объектом класса Phodopus или его родителем.
            if (obj.getClass().isAssignableFrom(Phodopus.class)) {
                try {
                    result.add(obj);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        return result;
    }
}
