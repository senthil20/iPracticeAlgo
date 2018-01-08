package ds.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Devise a function that accepts an arbitrarily-nested array with elements of arbitrary types,
 * and returns a flattened version of it. Do not solve the task using a built-in function that can accomplish the whole task on its own.
 Example:
 ["This is a string", 1, 2, [3], [4, [5, 6]], [[7]], 8, "[10, 11]"] -> ["This is a string", 1, 2, 3, 4, 5, 6, 7, 8, "[10, 11]"]
 */

public class ToptalTest {

    List list = new ArrayList();
    public Object[] flattenArray(Object[] input) {
        if (input == null || input.length == 0) return new Object[]{};
        for (Object obj : input) {
            if (obj instanceof String || obj instanceof Integer) {
                list.add(obj);
            }
            else {
                Object[] temp = (Object[])obj;
                if (temp.length == 1) {
                    for (Object val : temp)
                        list.add(val);
                }
                else {
                    for (Object o : temp) {
                        flattenArray(new Object[]{o}); //[4, [5, 6]]
                    }
                }
            }
        }
        Object[] result = new Object[list.size()];
        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i);
        return result;
    }

    public static void main(String a[]) {
        ToptalTest test = new ToptalTest();
        Object[] result = test.flattenArray(new Object[]{"This is a string", 1, 2, new Object[]{3}, new Object[]{4, new Object[]{5, 6}}, new Object[]{new Object[]{7}}, 8, "10, 11"});
        for (Object obj : result) {
            System.out.println(obj);
        }
    }
}
