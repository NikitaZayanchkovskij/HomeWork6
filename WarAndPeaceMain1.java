/**
 * Задача на умение работать с: строками, Set, Map, регулярные выражения*, работа с файлами**.
 * В задаче запрещено использовать stream
 *
 * Падежи, склонения, форма слова, опечатки, переносы и прочие проблемы текста - не ваша проблема!
 * Вообще не думайте над тем как исправить текст, думайте над правилами разбиения текста на слова.
 * Отдельно стоящие знаки препинания, пробелы и переводы строк - это не слова.
 * Регистр в словах имеет значение.
 *
 * На основании вопросов от студентов рассмотрим некоторые варианты текстов с вариантами разбиения
 * на слова:
 * 	1. "привет, как дела!" - тут три слова "привет", "как", "дела";
 * 	2. "привет,какдела!" - тут два слова "привет", "какдела";
 * 	3. "привет;какдела!" - тут два слова "привет", "какдела";
 * 	4. "как дела!.Что делаешь?"- тут четыре слова "как", "дела", "Что", "делаешь";
 * 	5. "Привет-привет" - тут одно слово "Привет-привет";
 * 	6. "Привет -привет" - тут два слова "Привет", "привет";
 * 	7. "4-х" - тут одно слово "4-х";
 * 	8. "один и 1" - тут три слова "один", "и", "1"
 * 	9. "бабушка бабушке бабушку" - тут три слова "бабушка", "бабушке", "бабушку"
 *
 * Совет по выполнению данного ДЗ. Сначала воспользоваться "простым" правилом разбиения на слова.
 * Например, ориентируюсь по пробелам. Выполнить подсчёт слов, отсортировать их и проверить что в целом
 * всё остальное работает. А потом уже заниматься усложнением правила разбиения в соответствии с
 * примерами написанными выше. Так вы более грамотно распределите своё время на выполнение данного
 * задания.
 *
 * Война и мир:
 * 1. Скачать книгу "Война и мир" https://...... на компьютер.
 * Для чтения данного файла можно воспользоваться статьёй
 * https://howtodoinjava.com/java/io/java-read-file-to-string-examples
 * Разделами 1 и 3, второй раздел использовать запрещено.
 */

package hw6_WarAndPeace;

import hw6_WarAndPeace.search.api.ISearchEngine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WarAndPeaceMain1 {
    public static void main(String[] args) {
        WarAndPeaceMain1 job = new WarAndPeaceMain1();
        String text = job.readFile("Война и мир_книга.txt");

        System.out.println(text);

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
