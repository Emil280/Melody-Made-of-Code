import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Day1Part1 {
    public static void main(String[] args) {
        try {
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day1\\Part1\\src\\Input.txt").toString()));

            int ans = 0;

            String[] input;
            while (myReader.ready()) {
                input = myReader.readLine().split(":");
                String[] colours = input[1].split(" ");
                int[] colourVals = new int[3];
                for (int i = 0; i < 3; i++) {
                    int bits = colours[i].length();
                    for (int j = 0; j < bits; j++) {
                        if (colours[i].charAt(j) < 97) {
                            colourVals[i] += (int) Math.pow(2,bits-j);
                        }
                    }
                }
                if (colourVals[1] > colourVals[0] && colourVals[1] > colourVals[2]) {
                    ans+= Integer.parseInt(input[0]);
                }
            }

            System.out.println(ans);

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }
}