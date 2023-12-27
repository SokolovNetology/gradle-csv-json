import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.opencsv.*;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName1 = "data.csv";
        List<Employee> list = parseCSV(columnMapping, fileName1);
        String json = listToJson(list);
        String fileName2 = "data.xml";
        List<Employee> list = parseXML(fileName2);

    }

    public static List<Employee> parseCSV(String [] columnMapping1, String fileName2) throws IOException {

        try (CSVReader reader = new CSVReader(new FileReader(fileName1))) {
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

    public static void writeString(String json, String fileName) {
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(json);
            file.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<Employee> parseXML(String fileName) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(fileName));
        Node root = doc.getDocumentElement();
        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i < nodeList.getLenth(); i++) {
            Node node = nodeList.item(i);
            Element employee = (Element) node;
            Employee employee = new Employee();
            employee.id = Long.parseLong(element.getElementsByTagName("id").item(0).getTextContent());
            employee.firstName = element.getElementsByTagName("firstName").item(0).getTextContent();
            employee.lastName = element.getElementsByTagName("lastName").item(0).getTextContent();
            employee.country = element.getElementsByTagName("country").item(0).getTextContent();
            employee.age = Integer.parseInt(element.getElementsByTagName("age").item(0).getTextContent());
            list.add(employee);
        }
        return list;
    }
}
