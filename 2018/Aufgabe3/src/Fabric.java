import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Fabric {
    public void fabricClaim() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Aufgabe3/src/Input.txt"));

            List<String[]> listOfClaims = new ArrayList<>();
            String line;
            String[] values;
            while ((line = br.readLine()) != null) {
                line = line.replaceAll(".*@ ", "").replaceAll("[:x]", ",").replaceAll(" ", "");
                values = line.split(",");
                listOfClaims.add(values);
            }

            int[][] theFabric = new int[1000][1000];
            int column;
            int row;
            int width;
            int height;

            // Aufgabe A
            for (int i = 0; i < listOfClaims.size(); i++) {
                column = Integer.valueOf(listOfClaims.get(i)[0]);
                row = Integer.valueOf(listOfClaims.get(i)[1]);
                width = Integer.valueOf(listOfClaims.get(i)[2]);
                height = Integer.valueOf(listOfClaims.get(i)[3]);
                for (int j = column; j < column + width; j++) {
                    for (int k = row; k < row + height; k++) {
                        theFabric[j][k]++;
                    }
                }
            }

            int count = 0;
            for (int i = 0; i < theFabric.length; i++) {
                for (int j = 0; j < theFabric.length; j++) {
                    if (theFabric[i][j] > 1) {
                        count++;
                    }
                }
            }

            //Answer
            System.out.println("Aufgabe 3a: " + count);

            // Aufgabe B
            boolean found;
            for (int i = 0; i < listOfClaims.size(); i++) {
                column = Integer.valueOf(listOfClaims.get(i)[0]);
                row = Integer.valueOf(listOfClaims.get(i)[1]);
                width = Integer.valueOf(listOfClaims.get(i)[2]);
                height = Integer.valueOf(listOfClaims.get(i)[3]);
                found = true;
                for (int j = column; j < column + width; j++) {
                    for (int k = row; k < row + height; k++) {
                        if (theFabric[j][k] > 1) {
                            found = false;
                        }
                    }
                }
                if (found) {
                    System.out.println("Aufgabe 3b: " + (i + 1));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found", e);
        }
    }

    public static void main(String[] args) {
        Fabric fabric = new Fabric();
        fabric.fabricClaim();
    }
}
