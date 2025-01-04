package com.codingchallanges.array.sort.interval;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class CarRental {

    public static Boolean canScheduleAll(Collection<RentalTime> rentalTimes) {

        rentalTimes = rentalTimes.stream().sorted().collect(Collectors.toList());

        LinkedList<RentalTime> nonOverlyingTime = new LinkedList<>();

        for(RentalTime time : rentalTimes) {

            System.out.println(time.toString());
            if(nonOverlyingTime.isEmpty() || nonOverlyingTime.getLast().getEnd().getTime() <= time.getStart().getTime()){
                nonOverlyingTime.add(time);
            }
        }
        System.out.println("non Overlying Time size = " + nonOverlyingTime.size());
        return nonOverlyingTime.size() == rentalTimes.size();
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/y H:m");

        ArrayList<RentalTime> rentalTimes = new ArrayList<RentalTime>();
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 19:00"), sdf.parse("03/05/2020 20:30")));
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 22:10"), sdf.parse("03/05/2020 22:30")));
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 20:30"), sdf.parse("03/05/2020 22:00")));
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 21:45"), sdf.parse("03/05/2020 23:00")));
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 21:45"), sdf.parse("03/05/2020 22:00")));

        System.out.println(CarRental.canScheduleAll(rentalTimes));
    }
}

/*
// rentalTimes.stream().sorted(new TimeComparator()).collect(Collectors.toList());
class TimeComparator implements Comparator<RentalTime> {

    @Override
    public int compare(RentalTime o1, RentalTime o2) {

        int result = Long.compare(o1.getStart().getTime(), o2.getStart().getTime());
        return result != 0 ? result : Long.compare(o1.getEnd().getTime(), o2.getEnd().getTime());
    }
}
*/

class RentalTime implements Comparable<RentalTime>{
    private Date start, end;

    public RentalTime(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return this.start;
    }

    public Date getEnd() {
        return this.end;
    }

    @Override
    public String toString() {
        return "RentalTime{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    @Override
    public int compareTo(RentalTime other) {
        int result = Long.compare(this.getStart().getTime(), other.getStart().getTime());
        return result != 0 ? result : Long.compare(this.getEnd().getTime(), other.getEnd().getTime());
    }
}

