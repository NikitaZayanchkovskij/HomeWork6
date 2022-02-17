package hw6_WarAndPeace.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {
    public static String readFile(String filePath){

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            StringBuilder builder = new StringBuilder();

            while(reader.ready()){
                builder.append(reader.readLine()).append("\n");
            }
            return builder.toString();

        } catch (IOException e) {
            throw new RuntimeException("Ошибка работы с файлом", e);
        }

    }
}
