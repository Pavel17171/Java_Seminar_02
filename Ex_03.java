/* 
Ex_3.** Дана json строка (можно сохранить 
в файл и читать из файла)

[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]

Написать метод(ы), который распарсит json и, используя StringBuilder, 
создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].

Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Ex_03 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("forEx_03.json"));
        String line = bf.readLine();

        while (line != null) {
            int index1 = line.indexOf('{');
            int index2 = line.indexOf('}');
            String resultStr = line;

            if (index1 >= 0 && index2 >= 0) {
                resultStr = resultStr.substring(index1 + 1, index2).replace(":", ",").replace("\"", "").replace(" ",
                        "");
                String[] line2 = resultStr.split(",");
                HashMap<String, String> map = new HashMap<>();
                for (int i = 0; i < line2.length - 1; i += 2) {
                    String a = line2[i];
                    String b = line2[i + 1];
                    map.put(a, b);
                }
                String name = map.get(line2[0]);
                String estimation = map.get(line2[2]);
                String subject = map.get(line2[4]);

                StringBuilder queryString = new StringBuilder("Студент " + name + " получил " + estimation + " по предмету " + subject);
                System.out.println(queryString);
            }

            line = bf.readLine();
        }
        bf.close();
    }
}