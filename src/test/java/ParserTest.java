import com.sun.tools.javac.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;



class ParserTest {

    @Test
    void parseCSV() throws IOException {
        Parser parser = new Parser();
        List<Employee> list = List.of(
                new Employee(1,"John","Smith","USA",25),
                new Employee(2,"Ivan","Petrov","RU",23));
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName1 = "data/data.csv";
        List<Employee> employees = parser.parseCSV(columnMapping, fileName1);
        Assertions.assertEquals(list.get(0).firstName,employees.get(0).firstName);
    }

    @Test
    void listToJson() {
        Parser parser = new Parser();
        String json = "data/data.json";
        List<Employee> list = List.of(
                new Employee(1,"John","Smith","USA",25),
                new Employee(2,"Ivan","Petrov","RU",23));
        List<T> employees = parser.listToJson(list);
        Assertions.assertEquals(list.get(0).firstName,employees.get(0).firstName);
    }


    @Test
    void writeString() {
    }

    @Test
    void parseXML()throws IOException {
        Parser parser = new Parser();
        List<Employee> list = List.of(
                new Employee(1,"John","Smith","USA",25),
                new Employee(2,"Ivan","Petrov","RU",23));
        String fileName2 = "data/data.xml";
        List<Employee> employees = parser.parseXML(fileName2);
        Assertions.assertEquals(list.get(0).firstName,employees.get(0).firstName);
    }
}