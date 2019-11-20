package DataStructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Study {

    int bookId;
    String contents;

    Study(int bookId, String content) {
        this.bookId = bookId;
        this.contents = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Study study = (Study) o;

        if (bookId != study.bookId) return false;
        return contents.equals(study.contents);
    }

    @Override
    public int hashCode() {
        int result = bookId;
        result = 31 * result + contents.hashCode();
        return result;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
public class Test {

    public static void main(String a[]) {
        String str = "tete       ,,,,,,,      ,asrararara    ,           ra";
        //str = str.replaceAll("[,;\\s+]", " ");
        String[] values = str.replaceAll("^[,\\s]+", "").split("[,\\s]+");
        str = Arrays.toString(values);
        System.out.println(str);


        List<Study> list = new ArrayList<>();
        Study s1 = new Study(1, "TestString");
        Study s2 = new Study(2, "TestString2");
        Study s3 = new Study(1, "TestString");

        if(list.contains(s1)) {
            System.out.println("S1");
        }
        else {
            list.add(s1);
        }

        if(list.contains(s2)) {
            System.out.println("S2");
        }
        else {
            list.add(s2);
        }
        if(list.contains(s3)) {
            System.out.println("S3");
        }
        else {
            list.add(s3);
        }
    }
}
