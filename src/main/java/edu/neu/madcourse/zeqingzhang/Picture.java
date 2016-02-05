package edu.neu.madcourse.zeqingzhang;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.view.View;
import android.widget.*;



public class Picture extends Activity {
//    PopupWindow popUp;
//    LinearLayout layout;
//    TextView tv;
//    LayoutParams params;
//    LinearLayout mainLayout;
//    ImageButton but;
//    boolean click = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
//        popUp = new PopupWindow(this);
//        layout = new LinearLayout(this);
//        mainLayout = new LinearLayout(this);
//        tv = new TextView(this);
//        but = (ImageButton)findViewById(R.id.myImageButton);
//
        TelephonyManager t1 = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        final TextView IMEI = (TextView) findViewById(R.id.IMEItextView);
        String phoneID = t1.getDeviceId();
        IMEI.setText(Html.fromHtml("<u>" + phoneID + "</u>"));
//        params = new LayoutParams(LayoutParams.WRAP_CONTENT,
//                LayoutParams.WRAP_CONTENT);
//        layout.setOrientation(LinearLayout.VERTICAL);
//        tv.setText("Hi this is a sample text for popup window");
//        layout.addView(tv, params);
//        popUp.setContentView(layout);
//        // popUp.showAtLocation(layout, Gravity.BOTTOM, 10, 10);
//        mainLayout.addView(but, params);
//        setContentView(mainLayout);



    }

    public void showMyInformation(View v){
        new AlertDialog.Builder(Picture.this)
                .setTitle("Who is Zeqing?")
                .setMessage(Html.fromHtml("Name: Zeqing Zhang" + "<br/>" + "Email: zhang.ze@husky.neu.edu"
                + "<br/>" + "Year: Forth Year" + "<br/>" + "<u>"+"Degree Program: Mathematics and Computer Science"+"</u>"))
//                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        // continue with delete
//                    }
//                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }


    }







