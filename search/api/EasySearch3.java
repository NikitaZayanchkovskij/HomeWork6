/**
 * 4. Реализовать интерфейс ISearchEngine:
 * 	 4.1 Написать класс EasySearch. Реализовать поиск используя метод indexOf из класса String.
 * 	 В данной реализации запрещено использовать регулярные выражения в любом виде, для любых задач.
 * 	 Данный класс ищет слова с учётом регистра.
 */

package hw6_WarAndPeace.search.api;

public class EasySearch3 implements ISearchEngine{

    @Override
    public long search(String text, String word) {
        int index = -1;
        long count = 0;

      //3 Вариант как можно сделать.
        do {
            index = text.indexOf(word, index + 1);
            if(index != -1){
                count++;
            }
        } while (index != -1);

        return count;
    }

}
