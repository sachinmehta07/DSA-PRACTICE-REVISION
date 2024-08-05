package dsa.leetcodes.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumTimeDifference {
    public static void main(String[] args) {

    }

    //converting to min
    public int convertToMinutes(String time) {

        String[] parts = time.split(":");

        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);

        return hours * 60 + minutes;

    }

    public int findMinDifference(List<String> timePoints) {

        List<Integer> minutesList = new ArrayList<>();

        //step 1 convert time to min
        for (String time : timePoints) {
            minutesList.add(convertToMinutes(time));
        }

        //step 2 sort the time list of times
        Collections.sort(minutesList);

        int minDiff = Integer.MAX_VALUE;
        //step 3 find the min time bw each slot
        for (int i = 1; i < minutesList.size(); i++) {
            minDiff = Math.min(minDiff, minutesList.get(i) - minutesList.get(i - 1));
        }

        // Handle the circular nature
        minDiff = Math.min(minDiff, 1440 - minutesList.get(minutesList.size() - 1) + minutesList.get(0));

        return minDiff;

    }
//"23:59","00:00"

    public int convertToMinutesTst(String time) {

        String[] part = time.split(":");

        int hour = Integer.parseInt(part[0]);
        int minutes = Integer.parseInt(part[1]);

        return hour * 60 + minutes;

    }

    // ["11:59 PM", "12:00 AM", "12:30 PM", "03:45 AM"]
    int convertToMinutesAmPm(String time) {
        String[] parts = time.split(" ");
        String[] hm = parts[0].split(":");
        int hours = Integer.parseInt(hm[0]);
        int minutes = Integer.parseInt(hm[1]);

        if (parts[1].equals("PM") && hours != 12) {
            hours += 12;
        } else if (parts[1].equals("AM") && hours == 12) {
            hours = 0;
        }
        return hours * 60 + minutes;
    }

//    Proceed with the Same Logic:
//
//    Once converted to minutes, use the same logic as before to find the minimum difference.
//    Example:
//
//    Time Points: ["11:59 PM", "12:00 AM", "12:30 PM", "03:45 AM"]
//    Converted to Minutes: [1439, 0, 750, 225]
//    Follow the previous solution steps to find the minimum difference.

    public int test(ArrayList<String> timePoint) {
        List<Integer> minMinutes = new ArrayList<>();

        //step 1
        //convert  each time points into the minute
        for (String time : timePoint) {
            minMinutes.add(convertToMinutesTst(time));
        }

        //step 2
        //sort the array
        Collections.sort(minMinutes);

//        step 3
        //take out the min diff bw the two time slots

        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < minMinutes.size(); i++) {
            minDiff = Math.min(minDiff, minMinutes.get(i) - minMinutes.get(i - 1));
        }

        //step 4 :

        // Wrap-Around Calculation:
        // Necessary for accurately finding the smallest time difference in a 24-hour format,
        // capturing differences that span from late at night to early in the morning

        int totalHours = 24 * 60;

        int startingDayTime = minMinutes.get(0);

        int endingDayTime = minMinutes.get(minMinutes.size() - 1);

        minDiff = Math.min(minDiff, totalHours - endingDayTime + startingDayTime);


        return minDiff;


    }


    // for follow-up question if interviewer say
    // tell what if i/p are in AM AND PM formate
    // or return me HH-MM formate in ans with diff

    public static class minimumTimeDifference {
        public List<String> findMinDifference(List<String> timePoints) {

            List<Integer> minutesList = new ArrayList<>();

            for (String time : timePoints) {
                minutesList.add(convertToMinutes(time));
            }

            Collections.sort(minutesList);

            int minDiff = Integer.MAX_VALUE;
            int firstTime = -1;
            int secondTime = -1;

            for (int i = 1; i < minutesList.size(); i++) {
                int diff = minutesList.get(i) - minutesList.get(i - 1);
                if (diff < minDiff) {
                    minDiff = diff;
                    firstTime = minutesList.get(i - 1);
                    secondTime = minutesList.get(i);
                }
            }

            int circularDiff = 1440 - minutesList.get(minutesList.size() - 1) + minutesList.get(0);

            if (circularDiff < minDiff) {
                minDiff = circularDiff;
                firstTime = minutesList.get(minutesList.size() - 1);
                secondTime = minutesList.get(0);
            }

            System.out.println(minDiff);

            List<String> result = new ArrayList<>();

            result.add(convertToHHMM(firstTime));

            result.add(convertToHHMM(secondTime));

            return result;
        }

        private int convertToMinutes(String time) {
            String[] parts = time.split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            return hours * 60 + minutes;
        }

        private String convertToHHMM(int minutes) {
            int hours = minutes / 60;
            int mins = minutes % 60;
            return String.format("%02d:%02d", hours, mins);
        }
    }
}
