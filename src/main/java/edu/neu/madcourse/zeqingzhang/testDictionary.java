package edu.neu.madcourse.zeqingzhang;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Scanner;


public class testDictionary extends ListActivity {
    Button clear;
    Button acknowledgements;
    Button returnToMenu;
    EditText text;
    TextView bigText;
    private static BloomFilter<String> dictionary;
    private static boolean wordsLoaded = false;
    ArrayAdapter<String> wordsAdapter;


    ArrayList<String> wordsListed = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dictionary);
        loadDictionary();
        clear = (Button)findViewById(R.id.clear);
        acknowledgements = (Button)findViewById(R.id.acknowledgements);
        returnToMenu = (Button)findViewById(R.id.returnToMenu);
        text = (EditText)findViewById(R.id.dictionaryText);
        bigText = (TextView)findViewById(R.id.largeDisplay);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("");

            }
        });
        wordsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, wordsListed);
        this.setListAdapter(wordsAdapter);




        returnToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToMainMenu = new Intent(testDictionary.this, MainMenuActivity.class);
                startActivity(intentToMainMenu);
            }
        });

//        final ArrayList<String> array = new ArrayList<>();
//        double falsePositiveProbability = 0.1;
//        int expectedNumberOfElements = 432334;
//        BloomFilter<String> bloomFilter = new BloomFilter<String>(falsePositiveProbability, expectedNumberOfElements);
//
//        String line = null;
//        try {
//            BufferedReader r = new BufferedReader(new FileReader("/Users/zeqingzhang/Desktop/wordlist.txt"));
//            while((line = r.readLine())!=null){
//                bloomFilter.add(line);
//            }
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        Boolean b2 = bloomFilter.contains("hello");
//        Log.d("testBloomFilter", Boolean.toString(b2));
//        Log.d("testDictionary",text.getText().toString().toLowerCase().trim());


        bigText.setText("The Entered Word");
        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                Log.d("Terry","textChanges");
                Boolean b1 = dictionary.contains(text.getText().toString().toLowerCase().trim());
                Log.d("testDictionary",text.getText().toString().toLowerCase().trim());

                Log.d("testDictionary","Check whether we found the word: " + Boolean.toString(b1));
                if(text.getText().toString().length()>=3&&dictionary.contains(text.getText().toString().toLowerCase().trim())){
                    Log.d("Terry","FoundWord");
//                    array.add(text.getText().toString());
                   String word =  text.getText().toString().toLowerCase().trim();
                    bigText.setText(text.getText().toString());
                    wordsListed.add(0, word);
                    wordsAdapter.notifyDataSetChanged();
                    try {
                        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                        Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                        r.play();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });

    }



    private void loadDictionary() {
        //BloomFilter<String> newDictionary = new BloomFilter<String>(0.0000001, 432334);
        if (wordsLoaded) return;
        InputStream inputStream = getResources().openRawResource(R.raw.wordslist);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            dictionary = (BloomFilter) objectInputStream.readObject();
            objectInputStream.close();
            wordsLoaded = true;
        }
        catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public void returnToMenu(View v){
        Intent intent = new Intent(this,MainMenuActivity.class);
        startActivity(intent);
    }






}
