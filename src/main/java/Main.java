import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.opencsv.*;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName1 = "data.csv";
        List<Employee> list = parseCSV(columnMapping, fileName);
        String json = listToJson(list);
        String fileName2 = "data.xml";
        List<Employee> list = parseXML("data.xml");

    }

    public static List<Employee> parseCSV(String[] columnMapping, String fileName1) throws IOException {

        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            ColumnPositionMappingStrategy<Employee> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(Employee.class);
            strategy.setColumnMapping(columnMapping);
            CsvToBean<Employee> csv = new CsvToBeanBuilder<Employee>(reader)
                    .withMappingStrategy(strategy)
                    .build();
            return csv.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> String listToJson(List<T> list) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Type listType = new TypeToken<List<T>>() {
        }.getType();
        return gson.toJson(list, listType);
    }
         public static void writeString(String json,String fileName){
          try(FileWriter file = new FileWriter(fileName)){
              file.write(json);
              file.flush();

          }catch (Exception e){
              e.printStackTrace();
          }
          public static List<Employee> parseXML(String[] columnMapping,String fileName2){
                 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                 DocumentBuilder builder = factory.newDocumentBuilder();
                 Document doc = builder.parse(new File("data.xml"));
                 Node root = doc.getDocumentElement();
                 System.out.println("Корневой узел: " + root.getNodeName());
                 NodeList nodeList = root.getChildNodes();
                 for (int i=0;i< nodeList.getLenth;i++){
                     Node node = nodeList.item(i);
                     System.out.println("Teкyщий элeмeнт: " + node.getNodeName());
                 }
                 if(Node.ELEMENT_NODE == node.getNodeType()){
                    Element  employee = (Element) node;
                 }
             }
         }
}