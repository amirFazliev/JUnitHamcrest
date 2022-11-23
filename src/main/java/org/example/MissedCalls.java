package org.example;

import java.time.LocalDateTime;
import java.util.*;

public class MissedCalls {
    private SortedMap<LocalDateTime, String> missedCalls = new TreeMap<>() ;

    public void addCalls(LocalDateTime localDateTime, String number) {
        missedCalls.put(localDateTime, number);
    }

    public void missedCallsPhone (PhoneBook phoneBook) {
        for (Map.Entry <LocalDateTime, String> time : missedCalls.entrySet()) {
            String number = time.getValue();
            System.out.println(phoneBook.testInNull((phoneBook.seachContactNumber(number))));
        }
    }
}

