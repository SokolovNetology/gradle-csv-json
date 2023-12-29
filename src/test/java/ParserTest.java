import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;


class ParserTest {

    @Test
    void parseCSV() throws IOException {
        Parser parser = new Parser();
        // ожидаемый результат
        List<Employee> list = List.of(
                new Employee(1, "John", "Smith", "USA", 25), // 0 элемент
                new Employee(2, "Ivan", "Petrov", "RU", 23)); // 1 элемент
        // аргумент 1
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        // аргумент 2
        String fileName1 = "data/data.csv";
        // вызов метода
        List<Employee> employees = parser.parseCSV(columnMapping, fileName1);
        // сравнение ожидаемого и фактического результатов
        Assertions.assertEquals(list.get(0).firstName, employees.get(0).firstName);
        Assertions.assertEquals(list.get(1).firstName, employees.get(1).firstName);
    }

    @Test
    void listToJson() {
        Parser parser = new Parser();
        // ожидаемый результат
        String expected = "[{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Smith\",\"country\":\"USA\",\"age\":25},{\"id\":2,\"firstName\":\"Ivan\",\"lastName\":\"Petrov\",\"country\":\"RU\",\"age\":23}]";
        // аргумент
        List<Employee> list = List.of(
                new Employee(1, "John", "Smith", "USA", 25),
                new Employee(2, "Ivan", "Petrov", "RU", 23));
        // вызов метода
        String actual = parser.listToJson(list);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void writeString() {
    }

    @Test
    void parseXML() throws IOException, ParserConfigurationException, SAXException {
        Parser parser = new Parser();
        List<Employee> list = List.of(
                new Employee(1, "John", "Smith", "USA", 25),
                new Employee(2, "Ivan", "Petrov", "RU", 23));
        String fileName2 = "data/data.xml";
        List<Employee> employees = parser.parseXML(fileName2);
        Assertions.assertEquals(list.get(0).firstName, employees.get(0).firstName);
    }
}