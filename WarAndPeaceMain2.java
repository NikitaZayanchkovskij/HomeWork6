/**
 * 2. Работа с коллекциями:
 * 	2.1 Найти в тексте все использованные слова и поместить их в коллекцию Set.
 */

package hw6_WarAndPeace;

import hw6_WarAndPeace.search.api.ISearchEngine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class WarAndPeaceMain2 {
    public static void main(String[] args) {
        WarAndPeaceMain2 job = new WarAndPeaceMain2();
        String text = job.readFile("Война и мир_книга.txt");

        String[] words = text.replaceAll
                ("(\\p{Punct}|\\p{Space}|\\p{Graph}){1,}", " ").split(" ");
        /** Мы здесь написали, что если в процессе выполнения встретится 1 и более знак пунктуации, пробел,
         * или граф этот - замени на пробел.
         */

        Set<String> uniqueWords = new HashSet<>();

        for (String word : words) {
            uniqueWords.add(word);
        }

        System.out.println("Было использовано " + uniqueWords.size() + " уникальных слов.");

        ISearchEngine engine = null;

        long result1 = engine.search("привет, как дела!", "дела");//Результат: одно слово "дела".
        long result2 = engine.search("привет,какдела!", "дела");//0
        long result3 = engine.search("привет;какдела!", "дела");//0
        long result4 = engine.search("как дела!.Что делаешь?", "дела");//1
        long result5 = engine.search("Привет-привет", "привет");//0
        long result6 = engine.search("Привет -привет", "привет");//1
        long result7 = engine.search("4-х", "4");//0
        long result8 = engine.search("один и 1", "1");//1
        long result9 = engine.search("бабушка бабушке бабушку", "бабушка");//1

        long result10 = engine.search(text, "война");//?
        long result11 = engine.search(text, "и");//?
        long result12 = engine.search(text, "мир");//?
    }

    public String readFile(String filePath){

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
