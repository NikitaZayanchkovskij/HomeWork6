/**
 * 4. Реализовать интерфейс ISearchEngine:
 * 	 4.1 Написать класс EasySearch. Реализовать поиск используя метод indexOf из класса String.
 * 	 В данной реализации запрещено использовать регулярные выражения в любом виде, для любых задач.
 * 	 Данный класс ищет слова с учётом регистра.
 */

package hw6_WarAndPeace.search.api;

public class EasySearch4 implements ISearchEngine{
  //Здесь делаем, чтобы учитывал пробелы, запятые и т.д.

//    private final char[] stopChars = {' ', ',', ';', ':', '!', '.'};
//    /** Помещаем сюда символы, которые будут обозначать границы слов.
//     * Массив делаем для того, чтобы не писать каждый раз if пробел, if запятая,
//     * if точка с запятой и т.д.
//     */

    private final String stopChars = " !\"#$%&'()*+,-./:;<=>?@[\\]^_'{|}~";

    @Override
    public long search(String text, String word) {
        int index = -1;
        long count = 0;
        int textLength = text.length();
        int wordLength = word.length();

        do {
            index = text.indexOf(word, index + 1);//index обозначает начало слова, которое мы
          //искали, значит нам надо получить символ предыдущий
            if(index != -1){

                if(index == 0){
                    count++;
                    break;
                }

                char beforeChar = text.charAt(index - 1);

                if(isStopChar(beforeChar)){//Если перед словом то, что нужно - проверяем что после него.

                    int afterCharIndex = index + wordLength;

                    if(textLength >= afterCharIndex){
                        if(textLength == afterCharIndex){
                            count++;
                            break;
                        }

                        char afterChar = text.charAt(index + wordLength);
                        if(isStopChar(afterChar)){
                            count++;
                        }
                    }
                }
            }
        } while (index != -1);

        return count;
    }

//    private boolean isStopChar(char c){
//        for (char stopChar : stopChars) {
//            if(c == stopChar){
//                return true;
//            }
//        }
//        return false;
//    }

    private boolean isStopChar(char c){
        return stopChars.indexOf(c) != -1;
    }
}
