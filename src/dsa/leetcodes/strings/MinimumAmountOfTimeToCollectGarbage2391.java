package dsa.leetcodes.strings;

public class MinimumAmountOfTimeToCollectGarbage2391 {

    public static void main(String[] args) {
    }

    public int getTimeCollectGarbage(String[] garbage, int[] travel) {
        //till i understood the question

        //there are 3 type of garbage

        //P M G


        //and collecting each garbage take 1 min from garbage house arr
//        "P" "M" "PG" "GG"

        //AS I KNOW WHY COLLECTING P OR M OR G BCZ AS QUESTION SAID THERE ARE 3
        // TYPE OF TRUCK FOR EACH GRBG TYPE

        //SO WHN WE VISIT PERTICULER GRBG WE MUST MAKE MARK AS VIST

        //ACCORDING TO THEIR GRBG TYPE AND ALSO INCRESE THE COLLETING
        // TIMEOR PICKUP TIME ACCORING THIER TYPR BRBG

        //NOW SIMPLE CALCULATING PICKING TIME FOR P TYPE OF GARBAGE

        //NOW SIMPLE CALCULATING PICKING TIME FOR M TYPE OF GARBAGE

        //NOW SIMPLE CALCULATING PICKING TIME FOR G TYPE OF GARBAGE

        //WE ALSO GOING TO SAVE variable name according to type of each grbg
        // THE LAST VISITED HOUSE FOR THAT
        // particular GRBG TO KNOW THE Distance of travel time for truck


        //as we have another travel time array which mention the travel distance of house

//        so based on last visited  house of eachgrbg type willl help to know
//        the whn the to stop calculating the travel distnce based on index

        // at the end we will get the all travel time + pick time and just return the ans total time to collect the grbg


        //Approch

        // step1

        //create  var for all truck 3 var for each pickTime, travelTime ,lastVisitedHouse

//        step 2
        //after that simple travel over the gbg array  and
        //as know only three type of gbg M P G
        //        step 3
        // so while trvesing simply when p come truck p wil pick so inrese pickP++ time also store the lastPhouse
        // so like wise for each we will get the pick time as per their truck vsite and their last House Visit

        //        step 4
        //based on lastHouse vist simply travese over the travel arr
        //calculte all three truck trave distce based on each last truck
        //        step 5
        // simply collect all the travel time and pick time off alll return  the totaltime


//        ["MMM","PGM","GP"]

        //time for P truck
        int pickP = 0;
        int travelP = 0;
        int lastVisitedHouseP = 0;


        //time for G truck
        int pickG = 0;
        int travelG = 0;
        int lastVisitedHouseG = 0;

        //time for M truck
        int pickM = 0;
        int travelM = 0;
        int lastVisitedHouseM = 0;

        //let travel to the street house
        for (int i = 0; i < garbage.length; i++) {
            String currHouse = garbage[i]; //bcz each house can have multiple
            //To get each curr House garbage type
            for (int j = 0; j < currHouse.length(); j++) {
                char currGrgType = currHouse.charAt(j);
                if (currGrgType == 'P') {
                    pickP++;
                    lastVisitedHouseP = i; //marks last visited House
                }
                if (currGrgType == 'G') {
                    pickG++;
                    lastVisitedHouseG = i;
                }
                if (currGrgType == 'M') {
                    pickM++;
                    lastVisitedHouseM = i;
                }
            }
        }

        //to calculate the travel time of each truck
        for (int i = 0; i < travel.length; i++) {
            if (i < lastVisitedHouseP) {
                travelP += travel[i];
            }
            if (i < lastVisitedHouseG) {
                travelG += travel[i];
            }
            if (i < lastVisitedHouseM) {
                travelM += travel[i];
            }
        }

        int totalPickUpTime = pickG + pickP + pickM;
        int totalTravelTime = travelP + travelM + travelG;

        int totalTime = totalTravelTime + totalPickUpTime;

        return totalTime;

    }


}
