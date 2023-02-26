/* 
Ex_1. Дана строка sql-запроса "select * from students where ". 
Сформируйте часть WHERE этого запроса, используя StringBuilder. 
Данные для фильтрации приведены ниже в виде json строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: 
{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Ex_01 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("forEx_01.json"));
        String line = bf.readLine();
        while (line != null) {
            int index1 = line.indexOf('{');
            int index2 = line.indexOf('}');
            String resultStr = line;
            if (index1 >= 0 && index2 >= 0) {
                resultStr = resultStr.substring(index1 + 1, index2).replace("\":\"", " = ").replace("\"", " ");
            }
            String[] line2 = resultStr.split(", ");
            int count = line2.length;
            StringBuilder queryString = new StringBuilder("select * from students where");
            ArrayList<String> listOfStrings = new ArrayList<String>();
            if (count > 1) {
                int countNull = 0;
                for (int i = 0; i < count; i++) {
                    if (!line2[i].contains(" null ")) {
                        listOfStrings.add(line2[i]);
                        countNull++;
                    }
                }
                if (countNull > 0) {
                    String line3 = String.join("and", listOfStrings);
                    System.out.println(queryString + line3);
                }
            }
           
            line = bf.readLine();
        }
        bf.close();
    }
}