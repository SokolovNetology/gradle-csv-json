
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";
        List<Employee> list = parseCSV(columnMapping, fileName);
        String json = listToJson(list);
    }

    public static List<Employee> parseCSV(String[] columnMapping, String fileName) throws IOException {

        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            ColumnPositionMappingStrategy<Employee> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(Employee.class);
            strategy.setColumnMapping(columnMapping);
            CsvToBean<Employee> csv = new CsvToBeanBuilder<Employee>(csvReader)
                    .withMappingStrategy(strategy)
                    .build();
            return csv.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

       public static <T> String listToJson(List<Employee>List<T> list){
           GsonBuilder builder = new GsonBuilder();
           Gson gson = builder.create();
           Type listType = new TypeToken<List<T>>() {}.getType();
    }get.Type();
         return gson.toJson(list,listType);
    }

