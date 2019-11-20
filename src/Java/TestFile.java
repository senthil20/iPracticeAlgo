package Java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TestFile {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String ar[]) {
        try{
            List<String> inputList = new ArrayList<>();
            Map<String, Integer> result = new HashMap<>();

            //C://file//hosts_access_log_00.txt
            String filename = scan.nextLine();
            File file = new File(filename);
            scan = new Scanner(file);

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                inputList.add(line);
            }
            scan.close();



            for (String input : inputList) {
                String[] entry = input.split(" ");
                String key = entry[0];
                if (result.containsKey(key)) {
                    int count = result.get(key);
                    result.put(key, count + 1);
                }
                else {
                    result.put(key, 1);
                }
            }
            //Writing to a new file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C://file//records_hosts_access_log_00.txt"))) {
                for (Map.Entry<String, Integer> entry : result.entrySet()) {
                    String key = entry.getKey();
                    Integer val = entry.getValue();
                    String content  = key.concat(" ").concat(String.valueOf(val));
                    bw.write(content);
                    bw.newLine();
                }
                System.out.println("Done");

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
