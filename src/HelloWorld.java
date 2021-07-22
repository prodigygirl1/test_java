import java.util.*;
import java.net.URL;
import java.io.*;

import static java.lang.Character.isLetter;

// File.readAllLines()
public class HelloWorld
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input_url = scanner.nextLine();
        try {
            InputStream ins = new URL(input_url).openStream();
            byte[] data_bytes;
            data_bytes = ins.readAllBytes();
            String data_text = new String(data_bytes);
            String[] words_array;
            words_array = data_text.split("[\\n\\t\\r ]");
            int k = 0;
            for (String s : words_array) {
                if (!s.equals("")) {
                    if (isLetter(s.charAt(0))) k++;
                }
            }
            System.out.println(k);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}