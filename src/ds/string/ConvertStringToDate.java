package ds.string;

public class ConvertStringToDate {

    public int solution(int N) {
        //529
        //1000010001
        if (N == 0) return 0;
        String binaryStr = Integer.toBinaryString(N);
        int maxGap = 0;
        int start = 1;
        for (int i = 1; i < binaryStr.length(); i++) {
            char c = binaryStr.charAt(i);
            if (binaryStr.charAt(i) == '1' && binaryStr.charAt(i - 1) == '1') {
                start = i;
                continue;
            }
            if (c == '1') {
                maxGap = Math.max(maxGap, i - start);
                start = i;
            }

        }
        System.out.println("Max Gap is " + maxGap);
        return maxGap;
    }

    private String convertStringToDate(String str, int days) {

        int[] actuals = new int[]{21,01,2016};
        int[] yearsAndDays = yearsAndDays(days);

        if (actuals[2] + yearsAndDays[0] > 9999) return null;
        else actuals[2] = actuals[2] + yearsAndDays[0]; //2019

        int remDays = yearsAndDays[1];

        while (remDays > 0) {
            int day = actuals[0];
            int month = actuals[1];
            int year = actuals[2];
            int target = 0;
            if (month == 2 && isLeapYear(year)) {
                target = 29;
            }
            else if (month == 2 && !isLeapYear(year)) {
                target = 28;
            }
            else if (month % 2 == 0) {
                if (month == 8) target = 31;
                else target = 30;
            }
            else target = 31;
            target++;
            if (remDays < target) new int[]{remDays, month, year}.toString();
            else {
                remDays = remDays - (target - day);
                month++;
                if (month > 12) year++;
                if (year > 9999) return null;
                actuals[1] = month;
                actuals[2] = year;
            }
        }
        return actuals.toString();
    }

    public boolean isLeapYear(int year) {
        return (year % 4 == 0);
    }
    public int[] yearsAndDays(int num) {
        int years = 0;
        while (num > 0) {
            if (num > 365) {
                years += num / 365;
                num = num % 365;
            }
        }
        return new int[]{years, num};
    }

    public static void main(String a[]) {
        ConvertStringToDate cd = new ConvertStringToDate();
        //System.out.println(cd.convertStringToDate("21-JAN-2016", 790));
        cd.solution(9);
    }
}
