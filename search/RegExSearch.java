/**
 * 4.2 Написать класс RegExSearch реализующий интерфейс ISearchEngine. Реализовать поиск при помощи
 * класса Matcher. Данный класс ищет слова с учётом регистра.
 */

package hw6_WarAndPeace.search;

import hw6_WarAndPeace.search.api.ISearchEngine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExSearch implements ISearchEngine {

  //1 Вариант
    @Override
    public long search(String text, String word) {
        String regex = "\\b" + word + "\\b";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(text);
        return matcher.results().count();
    }

}
