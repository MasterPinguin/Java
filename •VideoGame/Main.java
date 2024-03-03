import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("file/file.json"));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            JSONObject jsonObject = new JSONObject(sb.toString());
            // usa l'oggetto JSONObject qui
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
