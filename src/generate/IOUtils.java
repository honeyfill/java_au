package generate;

import java.io.FileReader;
import java.io.IOException;

public class IOUtils {
    public static String readFile(String source) throws IOException {

        StringBuilder input = new StringBuilder();

        FileReader tfr = new FileReader(source);

        char[] buffer = new char[8096];

        int chars = tfr.read(buffer);

        while (chars != -1) {
            input.append(String.valueOf(buffer, 0, chars));
            chars = tfr.read(buffer);
        }

        tfr.close();

        return input.toString();
    }
}
