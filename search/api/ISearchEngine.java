/**
 * 3. Написать интерфейс ISearchEngine. Это будет интерфейс в котором будут методы:
 * 	3.1 long search (String text, String word).
 * 	Метод возвращает информации о количестве раз, которое
 * 	встречается слово в тексте. Первый параметр текст в котором ищем, второй параметр, что ищем в тексте.
 */

package hw6_WarAndPeace.search.api;

/**
 * Реализация поиска текста
 */
public interface ISearchEngine {
    /**
     * Поиск слова по тексту
     * @param text текст, по которому ищем
     * @param word слово, которое ищем
     * @return количество найденных совпадений слов
     */
    long search(String text, String word);

}
