//https://acmp.ru/index.asp?main=task&id_task=743
/*
(Время: 1 сек. Память: 16 Мб Сложность: 42%)
        Алхимики средневековья владели знаниями о превращении различных химических веществ друг в друга. Это подтверждают и недавние исследования археологов.
        В ходе археологических раскопок было обнаружено m глиняных табличек, каждая из которых была покрыта непонятными на первый взгляд символами. В результате расшифровки выяснилось, что каждая из табличек описывает одну алхимическую реакцию, которую умели проводить алхимики.
        Результатом алхимической реакции является превращение одного вещества в другое. Задан набор алхимических реакций, описанных на найденных глиняных табличках, исходное вещество и требуемое вещество. Необходимо выяснить: возможно ли преобразовать исходное вещество в требуемое с помощью этого набора реакций, а в случае положительного ответа на этот вопрос — найти минимальное количество реакций, необходимое для осуществления такого преобразования.
        Входные данные
        Первая строка входного файла INPUT.TXT содержит целое число m (0 ≤ m ≤ 1000) – количество записей в книге. Каждая из последующих m строк описывает одну алхимическую реакцию и имеет формат вещество1 -> вещество2, где вещество1 – название исходного вещества, вещество2 – название продукта алхимической реакции. m+2-ая строка входного файла содержит название вещества, которое имеется исходно, m+3-ая – название вещества, которое требуется получить.
        Во входном файле упоминается не более 100 различных веществ. Название каждого из веществ состоит из строчных и заглавных английских букв и имеет длину не более 20 символов. Строчные и заглавные буквы различаются.
        Выходные данные
        В выходной файл OUTPUT.TXT выведите минимальное количество алхимических реакций, которое требуется для получения требуемого вещества из исходного, или -1, если требуемое вещество невозможно получить.
*/
import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
//не получилось заставить работать JavaFX, поэтому консольный вариант
//import static sun.security.krb5.Confounder.intValue;

//TIP Чтобы <b>запустить</b> код, нажмите <shortcut actionId="Run"/> или
// нажмите на значок <icon src="AllIcons.Actions.Execute"/> в поле.
public class Alchemestry {


    public static void main(String[] args) {    //TIP Нажмите <shortcut actionId="ShowIntentionActions"/>, когда курсор находится на выделенном тексте
        // чтобы увидеть, как OpenIDE предлагает это исправить.
        Scanner sc = new Scanner(System.in);


        int receptCount = 0;//количество рецептов в книге
        int variantCount = 2;//количество вариантов
        int variantNumber = -1;//количество вариантов

        while ((variantNumber < 0) || (variantNumber > 1)) {
            System.out.println("Введите номер варианта расчета, 0 или 1 ");
            variantNumber = sc.nextInt();
        }

        String filePath = "book" + variantNumber + ".txt";
        int lineCount = LineCounter.countLines(filePath); // Считаем количество строк
        receptCount = lineCount;

        String stateBefore;
        String stateAfter;
        String[][] state = new String[lineCount][2];
        ReceptBook[] book = new ReceptBook[lineCount]; //+ 1 так как в первой строке заданное условиями задачи превращение
        String[] words = new String[2];
        //помню пожелания про выделение блоков в отдельные функции, но без их унификации особого смысла от этого нет
        //заполняем книгу рецептами из файла book0.txt или book1.txt в зависимости от введенного варианта


        //int lineCount = LineCounter.countLines(filePath); // Считаем количество строк
        System.out.println("Количество строк в файле: " + lineCount);
//читаем построчно из файла
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filePath));
            int jj = 0;
            while (scanner.hasNextLine()) {

                //надо сделать разбор прочитанной строки.
                String line = scanner.nextLine();
                words = line.split("\\s->\\s"); //удаляем разделители
                state[jj][0] = words[0];//сразу через regexp не получилось
                state[jj][1] = words[1];//сразу через regexp не получилось

                System.out.println("список превращений веществ " + Arrays.toString(words));
                jj++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        int i, j;
        stateBefore = state[0][0];
        stateAfter = state[0][1];


        //int nMax=(lineCount);//-1;//количество конечных рецептов, может быть меньше будет
        String[][] totalRecept = new String[lineCount - 1][lineCount - 1];
                String[] tempString = new String[lineCount];//временная строка
        int k = 0; //счетчик итоговых вариантов рецептов
        int tempIndex = 1; //временный индекс.

        for (int i1 = 1; i1 < lineCount; i1++) {
            {
                totalRecept[i1 - 1][0] = stateBefore;

                for (int i2 = 1; i2 < lineCount; i2++) {  //нумерация со сдвигом на 1 так как первая строка в файле заданное условием задачи превращение
                    if ((totalRecept[i1 - 1][i2 - 1]!=null)&&(totalRecept[i1 - 1][i2 - 1].equals(state[i1][0]))) {
                        totalRecept[i1 - 1][i2 - 1] = state[i1][1];
                    } else {
                        totalRecept[i1 - 1][i2 - 1] += '#';
                    }

                    //}
                }
                System.out.println(Arrays.deepToString(totalRecept));
            }

        }
    }
}
    //------------------------------------------------------------------------------------------------------
//не забыть проверить все символы и удалить их после обнаружения требумого условиями задачи вещества


