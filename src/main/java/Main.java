
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";
        List<Employee> list = parseCSV(columnMapping, fileName);

    }

    public static List<Employee> parseCSV(String[] columnMapping, String fileName) throws IOException {
        List<Employee> list = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader("data.csv"))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // Работаем с прочитанными данными.
                System.out.println(Arrays.toString(nextLine));
            } }catch (IOException e){
                e.printStackTrace();

            }
          return list;
        }

    }

}