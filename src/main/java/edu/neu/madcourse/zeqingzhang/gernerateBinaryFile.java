package edu.neu.madcourse.zeqingzhang;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by zeqingzhang on 2/4/16.
 */
public class gernerateBinaryFile {
   public static void main(String[] args){
        double falsePositiveProbability = 0.1;
        int expectedNumberOfElements = 432334;
        BloomFilter<String> bloomFilter = new BloomFilter<String>(falsePositiveProbability, expectedNumberOfElements);

        String line = null;
        try {
            BufferedReader r = new BufferedReader(new FileReader("/Users/zeqingzhang/Desktop/wordlist.txt"));
            while((line = r.readLine())!=null){
                bloomFilter.add(line);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }





       try {
           FileOutputStream fout = new FileOutputStream("/Users/zeqingzhang/Desktop/code2/ticTacToev6/src/main/res/dictionary/wordsList.dat");
           ObjectOutputStream oos = new ObjectOutputStream(fout);
           oos.writeObject(bloomFilter);
           oos.close();
           System.out.println("Done");
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }

   }
}
