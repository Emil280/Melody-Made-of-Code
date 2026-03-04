import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Day1Part3 {
    public static int BinToInt(String bin) {
        int ans = 0;
        int bits = bin.length()-1;
        for (int j = 0; j <= bits; j++) {
            if (bin.charAt(j) < 97) {
                ans += (int) Math.pow(2,bits-j);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        try {
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day1\\Part3\\src\\Input.txt").toString()));

            int ans = 0;

            int[][] groups = new int[6][2];

            String[] input;
            while (myReader.ready()) {
                input = myReader.readLine().split(":");
                String[] colours = input[1].split(" ");
                int[] colourVals = new int[3];
                int shine = BinToInt(colours[3]);
                if (shine == 31 || shine == 32) {
                    continue;
                }
                for (int i = 0; i < 3; i++) {
                    colourVals[i] = BinToInt(colours[i]);
                }
                if (colourVals[0] > colourVals[1] && colourVals[0] > colourVals[2]) {
                    if (shine < 31){
                        groups[0][0]++;
                        groups[0][1] += Integer.parseInt(input[0]);
                    } else {
                        groups[1][0]++;
                        groups[1][1] += Integer.parseInt(input[0]);
                    }
                } else if (colourVals[1] > colourVals[0] && colourVals[1] > colourVals[2]){
                    if (shine < 31){
                        groups[2][0]++;
                        groups[2][1] += Integer.parseInt(input[0]);
                    } else {
                        groups[3][0]++;
                        groups[3][1] += Integer.parseInt(input[0]);
                    }
                } else if (colourVals[2] > colourVals[0] && colourVals[2] > colourVals[1]){
                    if (shine < 31){
                        groups[4][0]++;
                        groups[4][1] += Integer.parseInt(input[0]);
                    } else {
                        groups[5][0]++;
                        groups[5][1] += Integer.parseInt(input[0]);
                    }
                }
            }

            int i = 0;
            for (int j = 1; j < 6; j++) {
                if (groups[i][0] < groups[j][0]){
                    i=j;
                }
            }
            System.out.println(groups[i][1]);

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }
}