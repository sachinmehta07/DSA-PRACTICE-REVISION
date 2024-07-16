package dsa.searching.binarysearch.hard;

public class RotiParataSpoj {
    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 1, 1, 1, 1, 1};

        System.out.println(getMinCookingTime(arr, 8));
    }

    public static boolean isPossible(int[] arr, int totalP, int minTime) {

        int currChefTime = 1;
        int parata = 0;
        int i = 0;
        int totalSum = 0;

        while (i < arr.length) {

            if (totalSum + currChefTime * arr[i] <= minTime) {

                totalSum += currChefTime * arr[i];

                currChefTime++;

                parata++;

            } else {
//
//                System.out.println("curr chef " + i + "-->" + totalSum);
//                System.out.println("\n");
//                System.out.println("Parata " + i + "-->" + parata);


                if (totalSum <= minTime && parata >= totalP) {
                    return true;
                }

                currChefTime = 1;

                totalSum = 0;

                i++;

            }
        }


        // means my all paratha are done in given time go left to decrese the time even more
        //            return false ; s = mid+1;  //means my all paratha not made go right and increse the time
        return false;

    }

    public static int geMinCookTime(int[] arr, int totalP) {

        int s = 1;

//      int e = totalP * (arr[arr.length - 1] + 1) / 2;

        int max = 0;

        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }

        int e = max * (totalP * (totalP + 1) / 2);

        int ans = -1;

        while (s <= e) {

            int mid = s + (e - s) / 2;

            if (isPossible(arr, totalP, mid)) {
                e = mid - 1;
                ans = mid;
            } else {
                s = mid + 1;
            }

        }
        return ans;
    }

    public static boolean isPossibleOp(int[] ranks, int totalP, int minTime) {

        int parata = 0;

        for (int rank : ranks) {

            int nxtParata = 1;

            int totalTime = 0;

            while (true) {

                int timeToCook = nxtParata * rank;
                if (totalTime + timeToCook <= minTime) {

                    totalTime += timeToCook;

                    nxtParata++;
                    parata++;

                    if (parata >= totalP) {
                        return true;
                    }

                } else {
                    System.out.println(totalTime);
                    break;

                }
            }
//            System.out.println(totalTime);
        }
        return parata >= totalP;
    }

    public static int getMinCookTimeOp(int[] ranks, int totalP) {

        int start = 1;

        int maxRank = 0;

        for (int rank : ranks) {
            maxRank = Math.max(maxRank, rank);
        }

        int end = maxRank * (totalP * (totalP + 1)) / 2;

        int ans = end;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isPossibleOp(ranks, totalP, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    //spoj ad bs problems
    public static int getMinCookingTime(int[] arr, int totalP) {
        //Binary Search
        if (totalP < 0) {
            return 0;
        }

        int s = 1;

        int e;

        int max = 0;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }


        e = max * (totalP * (totalP + 1)) / 2;
        int ans = e;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (isMinTimePossible(arr, totalP, mid)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    public static boolean isMinTimePossible(int[] chefArr, int totalP, int minTime) {
        int i = 0;

        int nextParata = 1;

        int totalTimeTaken = 0;

        int parata = 0;

        while (i < chefArr.length) {

            int timeTaken = nextParata * chefArr[i];

            if (timeTaken + totalTimeTaken <= minTime) {

                totalTimeTaken += timeTaken;

                parata++;

                nextParata++;

                if (parata >= totalP) {
                    return true;
                }

            } else {

                i++;//move for next chef

                nextParata = 1; //next parata count

                totalTimeTaken = 0;//for next chef

            }

        }
        return false;
    }

}
