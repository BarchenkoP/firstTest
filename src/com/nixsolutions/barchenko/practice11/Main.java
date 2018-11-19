package com.nixsolutions.barchenko.practice11;

import interfaces.logging.LoggingArrayCollection;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LoggingArrayCollection<Integer> logArray =
                new LoggingArrayCollectionImpl<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (int i = 0; i < 3; i++) {
            try {
                logArray.addAll(list);
            } catch (IllegalArgumentException e) {
                System.out.println("catch IllegalArgumentException");
            }
        }
    }
}
