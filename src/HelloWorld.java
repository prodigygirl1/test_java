import java.util.*;
import java.net.URL;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import static java.lang.Character.isLetter;

public class HelloWorld
{
    public static void main(String[] args) {
        // reading url from keyboard
        //Scanner scanner = new Scanner(System.in);
        //String input_url = scanner.nextLine();
        String input_url = "http://madbrains.github.io/java_course_test";
        try {
            // getting the data from file
            InputStream ins = new URL(input_url).openStream();
            byte[] data_bytes;
            data_bytes = ins.readAllBytes();
            String data_text = new String(data_bytes);
            String[] words_array;
            // creating an array with words from file
            words_array = data_text.split("[\\n\\t\\r ]");
            int k = 0;
            HashMap <String, Integer> hmap = new HashMap<>();
            for (String s : words_array) {
                if (!s.equals("")) {
                    if (isLetter(s.charAt(0))) {
                        k++;
                        if (hmap.containsKey(s.toLowerCase())){
                            Integer word_count = hmap.get(s.toLowerCase());
                            hmap.put(s.toLowerCase(), word_count+1);
                        } else {
                            hmap.put(s.toLowerCase(), 1);
                        }
                    }

                }
            }
            System.out.println("Количество слов: "+ k);
            hmap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}