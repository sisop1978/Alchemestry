import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
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
        receptCount=lineCount;

        String stateBefore;
        String stateAfter;
        String[][] state = new  String[receptCount][2];
        ReceptBook[] book = new ReceptBook[receptCount];
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
                //System.out.println("начальное состояние: "+ state[jj][0] + ", конечное состояние: "+ state[jj][1]);
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
        int i,j;
        stateBefore = state[0][0];
        stateAfter = state[0][1];

        //System.out.println("начальное состояние " + state[0][0]+" -> "+ state[0][1]);
        //System.out.println("начальное состояние " + stateBefore+" -> "+ stateAfter);

        //System.out.println("печатаем массив состояний" + Arrays.deepToString(state));
        //теперь по циклу анализируем файл массив words, на предмет продолжения рецепта.

        for (int i1 = 1; i1 < lineCount; i1++) {
            if (state[i1][0]==stateBefore)
           {   }

            for (int i2 = 1; i2 < lineCount; i2++) {


        }}
    }

    }
    //------------------------------------------------------------------------------------------------------

    }

