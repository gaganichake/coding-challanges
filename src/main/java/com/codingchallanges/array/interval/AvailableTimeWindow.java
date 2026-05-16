package com.codingchallanges.array.interval;

/*
GE Health Care, June 2025

Given the availability of N people find the common time windows where all the N people are available to participate in a meeting.

Example:
Input -
Person1 - [ (9:00, 10:30), (12:00, 14:00), (14:30, 15:30) ]
Person2 - [ (16:00, 17:00), (12:30, 13:30) ]
Person3 - [ (11:00, 11:30), (13:00, 14:00) ]

Output -
[ (13:00, 13:30) ]
 */

import java.util.*;

public class AvailableTimeWindow {

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        Person person1 = new Person(Arrays.asList(new int[][]{{900, 1030}, {1200, 1400}, {1430, 1530}}));
        Person person2 = new Person(Arrays.asList(new int[][]{{1600, 1700}, {1230, 1330}}));
        Person person3 = new Person(Arrays.asList(new int[][]{{1100, 1130}, {1300, 1400}}));
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        System.out.println(Arrays.deepToString(availability(persons)));
    }

    // Fix the code to find common time windows where all persons are available
    private static int[][] availability(List<Person> persons){

        List<int[]> timeSlots = new ArrayList<>();
        for (Person person : persons) {
            timeSlots.addAll(person.timeWindows());
        }

        // Sort the time slots by start time
        timeSlots.sort(Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));

        List<int[]> mergedSlots = new ArrayList<>();
        int[] currentSlot = timeSlots.get(0);

        for (int i = 1; i < timeSlots.size(); i++) {
            int[] nextSlot = timeSlots.get(i);
            if (currentSlot[1] >= nextSlot[0]) {
                currentSlot[1] = Math.max(currentSlot[1], nextSlot[1]);
            } else {
                mergedSlots.add(currentSlot);
                currentSlot = nextSlot;
            }
        }
        mergedSlots.add(currentSlot);

        return mergedSlots.toArray(new int[mergedSlots.size()][]);
    }

    public record Person(List<int[]> timeWindows) {

    }
}
