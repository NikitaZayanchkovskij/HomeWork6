/**
 * 4. Реализовать интерфейс ISearchEngine:
 * 	 4.1 Написать класс EasySearch. Реализовать поиск используя метод indexOf из класса String.
 * 	 В данной реализации запрещено использовать регулярные выражения в любом виде, для любых задач.
 * 	 Данный класс ищет слова с учётом регистра.
 */

package hw6_WarAndPeace.search.api;

public class EasySearch2 implements ISearchEngine {

    @Override
    public long search(String text, String word) {
        int index = -1;
        long count = 0;

      //2 Вариант как можно сделать.
        while ((index = text.indexOf(word, index + 1)) != -1) ;
        {
            count++;
        }
        return count;
    }
}
