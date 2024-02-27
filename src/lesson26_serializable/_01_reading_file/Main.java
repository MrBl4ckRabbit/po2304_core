package lesson26_serializable._01_reading_file;

import java.io.*;
import java.util.stream.Collectors;

public class Main {
    public static final String INPUT_TXT = "src/lesson26_serializable/lesson26_serializable_01_reading_file/input.txt";
    public static final String OUTPUT_TXT = "src/lesson26_serializable/lesson26_serializable_01_reading_file/output.txt";

    public static void main(String[] args) {
//        try (Scanner sc = new Scanner(new FileInputStream(INPUT_TXT));
//             OutputStream os = new FileOutputStream(OUTPUT_TXT)) {
//            while (sc.hasNextLine()) {
//                var bytes = sc.nextLine().getBytes();
//                os.write(bytes);
//                os.write("\n".getBytes());
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        try (var br = new BufferedReader(new FileReader(INPUT_TXT));
             var stream = br.lines();
             var os = new FileOutputStream(OUTPUT_TXT)) {
            var collect = stream.collect(Collectors.joining("\n"));
            os.write(collect.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
