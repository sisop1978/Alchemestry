import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

/*public class RemoveDuplicates {
        public static void main(String args) {
            String text = "Ivan Petr Ivan Egor Egor Fedor";

            // Разбиваем строку на слова, добавляем в LinkedHashSet
            String result = Arrays.stream(text.split(" "))
                    .collect(Collectors.toCollection(LinkedHashSet::new))
                    .collect(Collectors.joining(" "));

            System.out.println(result); // => Ivan Petr Egor Fedor
        }
    }
*/

public class Main {
    static String [] phrases = {
            "this is a first sentence",
            "hello my name is Chris",
            "what's up man what's up man",
            "today is tuesday",
            "this is a very long sentence this is a very long sentence",
            "single word single word",
            "hey hey"
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