import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Checksum {
    public void calculateChecksumA() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Aufgabe2/src/Input.txt"));

            int amounttwos = 0;
            int amountthrees = 0;
            Map<Character, Integer> letters;
            String line;
            while ((line = br.readLine()) != null) {
                letters = new HashMap<>();
                for (int i = 0; i < line.length(); i++) {
                    if (letters.containsKey(line.charAt(i))) {
                        letters.put(line.charAt(i), letters.get(line.charAt(i)) + 1);
                    } else {
                        letters.put(line.charAt(i), 1);
                    }
                }
                if (letters.containsValue(2)) {
                    amounttwos++;
                }
                if (letters.containsValue(3)) {
                    amountthrees++;
                }
            }

            //Answer
            System.out.println("Aufgabe 2a: " + amounttwos * amountthrees);
        } catch (IOException e) {
            throw new RuntimeException("File not found", e);
        }
    }

    public void calculateChecksumB() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Aufgabe2/src/Input.txt"));

            List<String> listOfInputs = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                listOfInputs.add(line);
            }

            StringBuilder result;
            for (int i = 0; i < listOfInputs.size(); i++) {
                for (int j = i + 1; j < listOfInputs.size(); j++) {
                    result = new StringBuilder();
                    for (int k = 0; k < listOfInputs.get(i).length(); k++) {
                        if (listOfInputs.get(i).charAt(k) == listOfInputs.get(j).charAt(k)) {
                            result.append(listOfInputs.get(i).charAt(k));
                        }
                    }
                    if (result.length() == 25) {
                        //Answer
                        System.out.println("Aufgabe 2b: " + result);
                        System.exit(0);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found", e);
        }
    }

    public static void main(String[] args) {
        Checksum checksum = new Checksum();
        checksum.calculateChecksumA();
        checksum.calculateChecksumB();
    }
}
