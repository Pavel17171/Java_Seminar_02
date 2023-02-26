/*
Ex_2.Реализуйте алгоритм сортировки пузырьком числового массива, 
результат после каждой итерации запишите в лог-файл.
*/

import java.util.logging.*;
import java.io.IOException;

public class Ex_02 {
    static boolean flag = true;
    public static void main(String[] agrs) throws SecurityException, IOException {

        Logger logger = Logger.getLogger("LogFile");
        FileHandler fh;
        fh = new FileHandler("Ex_02_LogFile.log");
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);

        int[] intArray = { 1, 5, 2, 6, 7, 5, 5, 3, 8, 9, 4, 0};
        StringBuilder tempString = new StringBuilder();
        tempString.append("Исходный список: \n");

        int countArray = intArray.length;
        for (int i = 0; i < countArray; i++) {
            tempString.append(intArray[i] + " ");
        }

        String a = tempString.toString();        
        logger.info(a);

        while (flag == true) {
        //for (int i = 0; i < countArray; i++) {               
            tempString = new StringBuilder();
            bublSort(intArray);                    
            for (int j = 0; j < countArray; j++) {
                tempString.append(intArray[j] + " ");
            }
            a = tempString.toString();
            logger.info(a);
        }

        logger.info("End");
    }

    public static void bublSort(int[] intArray) {
        int count = 0;
        for (int j = 0; j < intArray.length - 1; j++) {
            if (intArray[j + 1] < intArray[j]) {
                int temp = intArray[j + 1];
                intArray[j + 1] = intArray[j];
                intArray[j] = temp;
                count++;
            }
        }
        if (count == 0) {
            flag = false;
        }
    }
}