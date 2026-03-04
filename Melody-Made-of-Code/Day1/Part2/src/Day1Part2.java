import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;


public class Day1Part2 {
    public static int BinToInt(String bin) {
        int ans = 0;
        int bits = bin.length();
        for (int j = 0; j < bits; j++) {
            if (bin.charAt(j) < 97) {
                ans += (int) Math.pow(2,bits-j);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        try {
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day1\\Part2\\src\\Input.txt").toString()));

            int ans = 0;

            int maxShine = 0;
            int minBrightness = Integer.MAX_VALUE;

            String[] input;
            while (myReader.ready()) {
                input = myReader.readLine().split(":");
                String[] colours = input[1].split(" ");
                int shine = BinToInt(colours[3]);
                if (shine >= maxShine) {
                    int brightness = 0;
                    for (int i = 3; i > -1; i--) {
                        brightness += BinToInt(colours[i]);
                    }
                    if (shine > maxShine) {
                        maxShine = shine;
                        minBrightness = brightness;
                        ans = Integer.parseInt(input[0]);
                    } else {
                        if (minBrightness > brightness) {
                            ans = Integer.parseInt(input[0]);
                        }
                    }
                }
            }

            System.out.println(ans);

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }
}