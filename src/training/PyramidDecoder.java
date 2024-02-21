package training;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PyramidDecoder {

    public static void main(String[] args) {
        String inputFileName = "C:\\Users\\Nihal\\Downloads\\coding_input.txt";
        Map<Integer, String> wordMap = readAndStoreFile(inputFileName);
        Map<Integer, String> sortedMap = new TreeMap<>(wordMap);
        StringBuilder sb = new StringBuilder();
        int k=1;
        for (int i = 1; i <= sortedMap.size(); i=i+k) {
            sb.append(sortedMap.get(i)).append(" ");
            k++;
        }
        System.out.println(sb);
    }

    public static Map<Integer, String> readAndStoreFile(String fileName) {
        Map<Integer, String> wordMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length == 2) {
                    int number = Integer.parseInt(parts[0]);
                    String word = parts[1];
                    wordMap.put(number, word);
                }
            }
        } catch (IOException e) {
        }
        return wordMap;
    }
}
