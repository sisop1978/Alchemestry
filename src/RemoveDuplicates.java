import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveDuplicates {
    //from https://translated.turbopages.org/proxy_u/en-ru.ru.8c4bd08f-6adb04b2-070cbf1a-74722d776562/https/stackoverflow.com/questions/42770863/how-can-i-eliminate-duplicate-words-from-string-in-java
    //удаляет только целиком повторяющиеся фразы. отдельные слова не работает. Надо regexp менять.
    static String [] phrases   = {
            "this is a first sentence",
            "hello my name is Chris",
            "what's up man what's up man",
            "today is tuesday",
            "this is a very long sentence this is a very long sentence",
            "single word single word",
            "hey google hey"
    };
    public static void main(String[] args) throws Exception {
        String duplicatePattern = "\\b([\\w\\s']+) \\1\\b";
        Pattern p = Pattern.compile(duplicatePattern);
        for (String phrase : phrases) {
            Matcher m = p.matcher(phrase);
            if (m.matches()) {
                System.out.println(m.group(1));
            } else {
                System.out.println(phrase);
            }
        }
    }
}