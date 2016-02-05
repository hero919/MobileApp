package edu.neu.madcourse.zeqingzhang;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        //getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button b1 = (Button)findViewById(R.id.aboutMe);

//        final ActionBar actionBar = getActionBar();
//        // actionBar
//        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        // titleTextView
//        TextView titleTextView = new TextView(actionBar.getThemedContext());
//        titleTextView.setText("ZEQING ZHANG");
//        // Add titleTextView into ActionBar
//        actionBar.setCustomView(titleTextView);
        setContentView(R.layout.activity_main_menu);
    }



    public void showMyPicture(View v){
        Intent intentToPicture = new Intent(this, Picture.class);
        startActivity(intentToPicture);
    }

    public void playTicTacToc(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void toSimpleDictionary(View v){
        Intent intent = new Intent(this,testDictionary.class);
        startActivity(intent);

    }




    public void generateError(){
        throw new RuntimeException("Crashed because an error.");
    }

    public void exitProgram(View v){
        android.os.Process.killProcess(android.os.Process.myPid());
    }



}
