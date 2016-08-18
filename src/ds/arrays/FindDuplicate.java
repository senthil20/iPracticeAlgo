package ds.arrays;

import java.sql.Array;
import java.util.*;
import java.util.Arrays;

/**
 * Created by senthil on 13/8/16.
 */
public class FindDuplicate {

    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        int find = 0;

        while(find != slow){
            slow = nums[slow];
            find = nums[find];
        }
        return slow;
    }

    public static int findDuplicate1(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int m = (l+r)/2;
            int c = 0;

            for(int i: nums){
                if(i <= m){
                    c++;
                }
                else
                    break;
            }
            if(c > m) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return (l==nums.length) ? r : -1;
    }

    public static void missingInteger(int[] a) {

        if(a == null || a.length == 0) return;
        Arrays.sort(a);

        int s = 0;
        int e = a.length;
        int negCount = 0;

        while(s < e) {
            if(a[s] > 0 && (s-negCount+1) != a[s]) {
                System.out.println("Missing number is " + (s - negCount + 1));
                break;
            }
            if(a[s] <= 0) {
                negCount++;
            }
            s++;
        }
        System.out.println(negCount + " and "  + (s+1));
    }

    public static void missingInteger1(int[] A) {
        int n = A.length;

        for (int i = 0; i < n; i++) {
            while (A[i] != i + 1) {
                if (A[i] <= 0 || A[i] >= n)
                    break;

                if(A[i]==A[A[i]-1])
                    break;

                int temp = A[i];
                A[i] = A[temp - 1];
                A[temp - 1] = temp;
            }
        }

        for (int i = 0; i < n; i++){
            if (A[i] != i + 1){
                System.out.println(i + 1);
                break;
            }
        }

        System.out.println(n + 1);
    }

    public static void findRepetitiveAndMissing(int a[]) {

        if(a == null || a.length == 0) return;
        int s = 0;
        int e = a.length;

        while(s < e) {
            if(a[Math.abs(a[s])-1] > 0) {
                a[Math.abs(a[s])-1] = -a[Math.abs(a[s])-1];
            }
            else {
                System.out.println("Repeating element is " + Math.abs(a[s]));
            }
            s++;
        }
        s = 0;
        while(s < e) {
            if(a[s] > 0) {
                System.out.println("Missing element is " + (s+1));
                break;
            }
            s++;
        }
    }

    public static int findLargest(int a[]) {

        if(a == null || a.length == 0) return 0;
        String[] s = new String[a.length];
        StringBuffer sb = new StringBuffer();
        for(int i=0; i < a.length; i++) {
            s[i] = String.valueOf(a[i]);
        }

        Arrays.sort(s, new Comparator<String>(){
            public int compare(String s1, String s2) {
                System.out.println("S1 is " + s1 + "..." + " S2 is" + s2);
                return (s2+s1).compareTo(s1+s2);
            }
        });

        for(String str : s) {
            sb.append(str);
        }

        while(sb.charAt(0) =='0' && sb.length() > 1)
            sb.deleteCharAt(0);

        return Integer.parseInt(sb.toString());
    }

    private static void segregate(int a[]) {
        if (a == null || a.length == 0) return;
        int s = 0;
        int e = a.length;
        int index = 0;
        while (s < e) {
            if (a[s] <= 0) {
                int temp = a[s];
                if (s > 0) {
                    System.arraycopy(a, index, a, index + 1, s - index);
                    a[index] = temp;
                }
                index++;
            }
            s++;
        }

        System.out.println(a);
        System.arraycopy(a, 0, a, 1 , 2);
    }



    public static void main(String a[]) {
        //System.out.println(FindDuplicate.findDuplicate(new int[]{2,5,9,6,9,3,8,9,7,1}));
        //System.out.println(FindDuplicate.findDuplicate1(new int[]{1,2,3,4,5,6,7}));
        //FindDuplicate.findRepetitiveAndMissing(new int[]{1,2,3,5,5});
        //FindDuplicate.findLargest(new int[]{3, 30, 34, 5, 9});
        //FindDuplicate.missingInteger1(new int[]{2,3,4,5,8,-1,-10,15});
        /*FindDuplicate.missingInteger(new int[]{417, 929, 845, 462, 675, 175, 73, 1, 2, 867,
                14, 201, 777, 407, 80, 882, 785, 563, 209, 261, 776, 362, 730, 74, 649,
                465, 353, 801, 503, 154, 998, 286, 520, 692, 68, 805, 835, 210, 819, 341,
                564, 215, 984, 643, 381, 793, 726, 213, 866, 706, 97, 538, 308, 797, 883,
                59, 328, 743, 694, 607, 729, 821, 32, 672, 130, 13, 76, 724, 384, 444,
                884, 192, 917, 75, 551, 96, 418, 840, 235, 433, 290, 954, 549, 950, 21,
                711, 781, 132, 296, 44, 439, 164, 401, 505, 923, 136, 317, 548, 787, 224,
                23, 185, 6, 350, 822, 457, 489, 133, 31, 830, 386, 671, 999, 255, 222,
                944, 952, 637, 523, 494, 916, 95, 734, 908, 90, 541, 470, 941, 876, 264, 880, 761, 535, 738, 128, 772, 39, 553, 656, 603, 868, 292, 117, 966, 259, 619, 836, 818, 493, 592, 380, 500, 599, 839, 268, 67, 591, 126, 773, 635, 800, 842, 536, 668, 896, 260, 664, 506, 280, 435, 618, 398, 533, 647, 373, 713, 745, 478, 129, 844, 640, 886, 972, 62, 636, 79, 600, 263, 52, 719, 665, 376, 351, 623, 276, 66, 316, 813, 663, 831, 160, 237, 567, 928, 543, 508, 638, 487, 234, 997, 307, 480, 620, 890, 216, 147, 271, 989, 872, 994, 488, 291, 331, 8, 769, 481, 924, 166, 89, 824, -4, 590, 416, 17, 814, 728, 18, 673, 662, 410, 727, 667, 631, 660, 625, 683, 33, 436, 930, 91, 141, 948, 138, 113, 253, 56, 432, 744, 302, 211, 262, 968, 945, 396, 240, 594, 684, 958, 343, 879, 155, 395, 288, 550, 482, 557, 826, 598, 795, 914, 892, 690, 964, 981, 150, 179, 515, 205, 265, 823, 799, 190, 236, 24, 498, 229, 420, 753, 936, 191, 366, 935, 434, 311, 920, 167, 817, 220, 219, 741, -2, 674, 330, 909, 162, 443, 412, 974, 294, 864, 971, 760, 225, 681, 689, 608, 931, 427, 687, 466, 894, 303, 390, 242, 339, 252, 20, 218, 499, 232, 184, 490, 4, 957, 597, 477, 354, 677, 691, 25, 580, 897, 542, 186, 359, 346, 409, 655, 979, 853, 411, 344, 358, 559, 765, 383, 484, 181, 82, 514, 582, 593, 77, 228, 921, 348, 453, 274, 449, 106, 657, 783, 782, 811, 333, 305, 784, 581, 746, 858, 249, 479, 652, 270, 429, 614, 903, 102,
                378, 575, 119, 196, 12, 990, 356, 277, 169, 70, 518, 282, 676, 137, 622, 616, 357, 913, 161, 3, 589, 327});*/
        /*FindDuplicate.missingInteger(new int[]{
                948, 20, 84, 710, 471, 606, 995, 581, -4, 428, 149, 832, 740, 943, 450, 974, 829, 721, 821, 476, 763, 4, 523, 937, 814, 624, 935, 87, 127, 816, 239, 33, 561, 999, 904, 282, 844, 923, 750, 551, 432, 9, 373, 387, 114, 376, 265, 801, 228, 454, 474, 764, 268, 680, 472, 431, 133, 785, 752, 643, 441, 151, 969, 395, 437, 94, 259, 973, 535, 272, 456, 546, 79, 677, 0, 109, 522, 295, 466, 956, 723, 157, 772, 865, 997, 771, 922, 980, 567, 939, 651, 478, 852, 926, 913, 494, 882, 207, 915, 645, 754, 385, 874, 554, 706, 722, 10, 374, 96, 647, 280, 418, 737, 538, 867, 850, 600, 23, 730, 742, 224, 511, 361, 251, 809, 907, 271, 319, 866, 848, 594, 566, 113, 211, 334, 644, 826, 430, 929, 603, 165, 147, 788, 529, 539, 633, 275, 602, 544, 540, 853, 123, -1, 443, 942, 386, 68, 465, 782, 250, 458, 174, 70, 919, 462, 347, 26, 589, 880, 648, 237, 294, 641, 707, 516, 507, 802, 989, 779, 519, 62, 619, 584, 358, 362, 277, 43, 198, 467, 625, 611, 212, 468, 767, 778, 173, 791, 331, 11, 461, 572, 97, 902, 558, 413, 28, 179, 370, 842, 568, 500, 311, 550, 464, 345, 411, 274, 181, 396, 339, 39, 760, 575, 327, 889, 579, 840, 734, 254, 934, 532, 29, 622, 780, 73, 479, 322, 2, 599, 227, 685, 65, 510, 716, 289, 912,
                574, 262, 916, 924, 304, 57, 353, 40, 341, 521, 131, 307, 526, 398, 225, 63, 776
        });*/
        //FindDuplicate.missingInteger1(new int[]{1});
        FindDuplicate.segregate(new int[]{-1, 1, 3, 2, -2});
    }
}
