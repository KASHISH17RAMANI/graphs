

import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

class word_line {
    String word;
    int line;

    word_line(String word, int line)
    {
        this.word = word;
        this.line = line;
    }

}

public class ass11 {

    public static void main(String[] args) {
        try {
            File first = new File("kashish.txt");
            File second = new File("satya.txt");

            ArrayList<word_line> firstarray = new ArrayList();
            ArrayList<word_line> secondarray = new ArrayList();

            Scanner firstScanner = new Scanner(first);
            Scanner secondScanner = new Scanner(second);

            int i = 0;
            while(firstScanner.hasNextLine())
            {
                String[] line = firstScanner.nextLine().split(" ");
                for(String x:line)
                {
                    firstarray.add(new word_line(x, i));
                }
              ++i;  
            }
            firstScanner.close();
            i = 0;
            while(secondScanner.hasNextLine())
            {
                String[] line = secondScanner.nextLine().split(" ");
                for (String x : line) {
                    secondarray.add(new word_line(x, i));
                }
                ++i;
            }
            secondScanner.close();

          






        } catch (

        FileNotFoundException fnfe) {
            System.out.println("File not found!");
            System.exit(0);
        }

    }
}