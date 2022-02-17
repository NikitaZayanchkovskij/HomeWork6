/**
 * 4. Реализовать интерфейс ISearchEngine:
 * 	 4.1 Написать класс EasySearch. Реализовать поиск используя метод indexOf из класса String.
 * 	 В данной реализации запрещено использовать регулярные выражения в любом виде, для любых задач.
 * 	 Данный класс ищет слова с учётом регистра.
 */

package hw6_WarAndPeace.search.api;

public class EasySearch implements ISearchEngine{

    @Override
    public long search(String text, String word) {
        int index = text.indexOf(word);
        long count = 0;

      //1 Вариант как можно сделать.
        while(index != -1){
            count ++;
            index = text.indexOf(word, index + 1);
        }
        return count;
    }

}
