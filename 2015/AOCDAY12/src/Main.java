import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        System.out.println("Current Working Directory: " + System.getProperty("user.dir"));
        System.out.println("===========================================");
        try {
            // Read JSON from file
            String content = Files.readString(Paths.get("src\\input.txt"));

            Object json;
            if (content.trim().startsWith("[")) {
                json = new JSONArray(content);
            } else {
                json = new JSONObject(content);
            }

            // Call the method to get the sum
            int total = sumNumbers(json);
            System.out.println("Total sum of numbers: " + total);

            //Part2
            int totalp2 = sumNumbersEXLUDE_RED(json);
            System.out.println("Total sum of number P2: " + totalp2);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int sumNumbers(Object obj) {
        int sum = 0;

        if (obj instanceof JSONObject jsonObj) {
            for (String key : jsonObj.keySet()) {
                sum += sumNumbers(jsonObj.get(key)); // Process values recursively
            }
        } else if (obj instanceof JSONArray jsonArray) {
            for (Object item : jsonArray) {
                sum += sumNumbers(item); // Process array elements
            }
        } else if (obj instanceof Number num) {
            sum += num.intValue(); // Add number to sum
        }

        return sum;
    }
    private static int sumNumbersEXLUDE_RED(Object obj) {
        int sum = 0;

        if (obj instanceof JSONObject jsonObj) {
            if(jsonObj.toMap().containsValue("red")){
                return 0;
            }
            for (String key : jsonObj.keySet()) {
                sum += sumNumbersEXLUDE_RED(jsonObj.get(key)); // Process values recursively
            }
        } else if (obj instanceof JSONArray jsonArray) {
            for (Object item : jsonArray) {
                sum += sumNumbersEXLUDE_RED(item); // Process array elements
            }
        } else if (obj instanceof Number num) {
            sum += num.intValue(); // Add number to sum
        }

        return sum;
    }
}