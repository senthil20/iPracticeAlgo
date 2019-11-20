package DataStructures.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by senthil on 21/8/16.
 */
public class HotelBookings {

    //IB code
    public boolean hotel1(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        Collections.sort(arrive);
        Collections.sort(depart);
        int ar=0, de=0, nos=0,satisfy=0 , roomoccupancy=0;
        while(ar<arrive.size() && de<depart.size()){
            if(arrive.get(ar)<depart.get(de)){
                ar++;
                nos++;
                roomoccupancy++;
                satisfy= Math.max(nos,satisfy);
            }else{
                de++;
                nos--;
            }
        }
        return satisfy <= K;
    }



    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {

        Collections.sort(arrive);
        Collections.sort(depart);

        int n = arrive.size();
        int a = 0;
        int d = 0;
        int roomsNeeded = 0;
        int maxNeeded = Integer.MIN_VALUE;
        while(a < n && d < n) {
            if(arrive.get(a) < depart.get(d)) {
                roomsNeeded++;
                a++;
                maxNeeded = Math.max(maxNeeded, roomsNeeded);
            }
            else {
                roomsNeeded--;
                d++;
            }

        }
        return maxNeeded <= K;
    }


    public static void main(String ar[]) {
        HotelBookings hb = new HotelBookings();
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> d = new ArrayList<>();

        //A : [ 11, 24, 36, 15, 16, 23, 20, 19 ]
        //B : [ 14, 32, 67, 25, 21, 54, 61, 34 ]
        //C : 4

        a.add(11);a.add(24);a.add(36);a.add(15);a.add(16);a.add(23);a.add(20);a.add(19);
        d.add(14);d.add(32);d.add(67);d.add(25);d.add(21);d.add(54);d.add(61);d.add(34);
        hb.hotel(a, d, 4);
    }
}
