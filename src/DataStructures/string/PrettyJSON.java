package DataStructures.string;

import java.util.ArrayList;

/**
 * Created by senthil on 8/9/16.
 */
public class PrettyJSON {


    public ArrayList<String> prettyJSON(String a) {
        ArrayList<String> list = new ArrayList<>();

        if (a == null || a.length() == 0) return list;

        int s = 0;
        int e = a.length();
        int tabSpace = 0;
        String tmp = "";
        String string = "";

        while (s < e) {

            char c = a.charAt(s);

            if (c == '{' || c == '[') {
                if (string != "") {
                    list.add(tmp + string);
                    list.add(tmp + c);
                    string = "";
                }
                else {
                    list.add(tmp + c);
                }
                tabSpace++;
            }

            else if (c == '}' || c == ']') {
                if(string != "") {
                    list.add(tmp + string);
                    string = "";
                }
                tabSpace--;
            }

            else if (c == ',') {
                if (string == "") {
                    int n = list.size();
                    String temp = list.get(list.size()-1);
                    temp = temp + (tmp+c);
                    list.set(n-1, temp);
                }
                else {
                    list.add(tmp + string + c);
                }

                string = "";
                s++;
                continue;
            }

            else {
                string += c;
                s++;
                continue;
            }

            int t = 0;
            tmp = "";
            while (t < tabSpace) {
                tmp += "\t";
                t++;
            }

            if (c == '}' || c == ']') {
                list.add(tmp + c);
            }
            s++;
        }
        return list;
    }


    public static void main(String a[]) {
        PrettyJSON pj = new PrettyJSON();
        //pj.printJsonString("\"{\"id\": \"0001\",\t\"type\": \"donut\",\"name\": \"Cake\",\"ppu\": 0.55, \"batters\":{\"batter\":[{ \"id\": \"1001\", \"type\": \"Regular\" },{ \"id\": \"1002\", \"type\": \"Chocolate\" }]},\"topping\":[{ \"id\": \"5001\", \"type\": \"None\" },{ \"id\": \"5002\", \"type\": \"Glazed\" }]}\"");
        //pj.prettyJSON("\"{\"id\":100,\"firstName\":\"Jack\",\"lastName\":\"Jones\",\"age\":12}\"");
        pj.prettyJSON("\"{\"attributes\":[{\"nm\":\"ACCOUNT\",\"lv\":[{\"v\":{\"Id\":null,\"State\":null},\"vt\":\"java.util.Map\",\"cn\":1}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":13585},{\"nm\":\"PROFILE\",\"lv\":[{\"v\":{\"Party\":null,\"Ads\":null},\"vt\":\"java.util.Map\",\"cn\":2}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":41962}]}\"");
    }
}
