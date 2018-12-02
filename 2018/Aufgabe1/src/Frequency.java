import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Frequency {

    public void processFrequencysA() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Aufgabe1/src/Input.txt"));

            int freq = 0;
            String line;
            while ((line = br.readLine()) != null) {
                freq += Integer.valueOf(line);
            }
            //Answer
            System.out.println("Aufgabe 1a: " + freq);
        } catch (IOException e) {
            throw new RuntimeException("File not found", e);
        }
    }

    public void processFrequencysB() {
        try {
            boolean found = false;
            List<Integer> reachedFreqs = new ArrayList<>();
            int freq = 0;
            String line;
            while (!found) {
                BufferedReader br = new BufferedReader(new FileReader("Aufgabe1/src/Input.txt"));
                while ((line = br.readLine()) != null) {
                    reachedFreqs.add(freq);
                    freq += Integer.valueOf(line);
                    if (reachedFreqs.contains(freq)) {
                        //Answer
                        System.out.println("Aufgabe 1b: " + freq);
                        found = true;
                        break;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found", e);
        }

    }

    public static void main(String[] args) {
        Frequency freq = new Frequency();
        freq.processFrequencysA();
        freq.processFrequencysB();
    }
}
