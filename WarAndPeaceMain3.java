/**
 * 2.2 Найти в тексте топ N (настраиваемое значение) слов и вывести количество этих слов
 * используя Map и List. Отсортировать по количеству. Распечатать в консоль.
 * 		Пример: Война - 200 раз, Мир - 100 раз и так далее. Знаки препинания, пробелы и
 * 		переводы строк - это не слова.
 */

package hw6_WarAndPeace;

import hw6_WarAndPeace.search.RegExSearch;
import hw6_WarAndPeace.search.RegExSearch2;
import hw6_WarAndPeace.search.api.EasySearch;
import hw6_WarAndPeace.search.api.EasySearch4;
import hw6_WarAndPeace.search.api.ISearchEngine;
import hw6_WarAndPeace.utils.FileUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WarAndPeaceMain3 {
    public static void main(String[] args) {
        String text = FileUtils.readFile("Война и мир_книга.txt");

        String[] words = text.replaceAll
                ("(\\p{Punct}|\\p{Space}|\\p{Graph}){1,}", " ").split(" ");

        Set<String> uniqueWords = new HashSet<>();

        for (String word : words) {
            uniqueWords.add(word);
        }

        System.out.println("Было использовано " + uniqueWords.size() + " уникальных слов.");

        Map<String, Integer> wordsUseCount = new HashMap<>();

        for (String word : words){
            if(!wordsUseCount.containsKey(word)){
                wordsUseCount.put(word, 1);
            } else {
                Integer count = wordsUseCount.get(word);
                count++;
                wordsUseCount.put(word, count);
            }
        }

//        System.out.println(wordsUseCount);

      //Вывести топ слов.
//        Map<Integer, List<String>> countOfUse = new HashMap<>();
        Map<Integer, List<String>> countOfUse = new TreeMap<>((o1, o2) -> Integer.compare(o2, o1));


//      //1 Вариант как можно сделать
//        for (String uniqueWord : uniqueWords) {
//            Integer count = wordsUseCount.get(uniqueWord);
//            if(!countOfUse.containsKey(count)){
//                List<String> wordsOnCount = new ArrayList<>();
//                wordsOnCount.add(uniqueWord);
//                countOfUse.put(count, wordsOnCount);
//            } else {
//                List<String> wordsOnCount = countOfUse.get(count);
//                wordsOnCount.add(uniqueWord);
//                countOfUse.put(count, wordsOnCount);
//            }
//        }


        /** 2 Вариант как можно сделать.
         * Он более красивый,
         * но менее понятный, если вы плохо разбираетесь с тем, как работает память.
         */
        for (String uniqueWord : uniqueWords) {
            Integer count = wordsUseCount.get(uniqueWord);

            List<String> wordsOnCount = countOfUse.get(count);

            if(wordsOnCount == null){
                wordsOnCount = new ArrayList<>();
                countOfUse.put(count, wordsOnCount);
            }

            wordsOnCount.add(uniqueWord);
        }


//      //3 Вариант
//        for (String uniqueWord : uniqueWords) {
//            Integer count = wordsUseCount.get(uniqueWord);
//
//            List<String> wordsOnCount = countOfUse.computeIfAbsent(count, k -> new ArrayList<>());
//
//            wordsOnCount.add(uniqueWord);
//        }


        Set<Map.Entry<Integer, List<String>>> entries = countOfUse.entrySet();
        /** Map Entry это связка ключ + значение. */

//        Set<Integer> integers = countOfUse.keySet();//Нужен для того, чтобы поработать только с ключами.
//      //Например: вывести ключи, т.е. в данном примере количества слов, которые (кол-ва) встречаются.
//        Collection<List<String>> values = countOfUse.values();//То же самое, только по значениям, т.е.
//      //в данном примере по словам.

        int index = 10;//Топ 10 слов выводим.
        for(Map.Entry<Integer, List<String>> entry : entries){
            System.out.println(entry.getKey() + ": " + entry.getValue());
            index--;
            if(index <= 0){
                break;
            }
        }

        System.out.println("______________________");


        /**
         * 4. Реализовать интерфейс ISearchEngine:
         * 	 4.1 Написать класс EasySearch. Реализовать поиск используя метод indexOf из класса String.
         * 	 В данной реализации запрещено использовать регулярные выражения в любом виде, для любых задач.
         * 	 Данный класс ищет слова с учётом регистра.
         */
        ISearchEngine engine = new RegExSearch();

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

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
        System.out.println(result7);
        System.out.println(result8);
        System.out.println(result9);

        System.out.println(result10);
        System.out.println(result11);
        System.out.println(result12);
    }
}
