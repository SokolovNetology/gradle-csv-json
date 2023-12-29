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

public class Main  {
    private static Parser parser = new Parser();
    public static void main(String[] args) throws IOException,ParserConfigurationException,SAXException {

        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName1 = "data/data.csv";
        List<Employee> list = parser.parseCSV(columnMapping, fileName1);
        String json = parser.listToJson(list);
        parser.writeString(json, "data/data.json");
        String fileName2 = "data/data.xml";
        List<Employee> list1 = parser.parseXML(fileName2);

    }

}