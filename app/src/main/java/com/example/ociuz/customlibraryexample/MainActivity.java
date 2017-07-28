package com.example.ociuz.customlibraryexample;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.autotextinput.CreateInputs;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String [] names = {"name","age:number","place","mob:number","email","username","pass:password"};
        final RelativeLayout rl = (RelativeLayout)findViewById(R.id.activity_main);
       final Drawable dr = getResources().getDrawable(R.drawable.shape);
        new CreateInputs(MainActivity.this,names,rl,dr).create();
        final Button b = (Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> nm = new ArrayList<String>(new CreateInputs(MainActivity.this,names,rl,dr).getvalues(rl)) ;
                if(nm.size()==names.length){
                    String name = nm.get(0);
                    String age = nm.get(1);
                    String place = nm.get(2);
                    String mob = nm.get(3);
                    String email = nm.get(4);
                    String username = nm.get(5);
                    String pass = nm.get(6);
                    b.setText(name+"\n"+age+"\n"+place+"\n"+mob+"\n"+email+"\n"+username+"\n"+pass+"\n");
                }
                else {
                    Toast.makeText(MainActivity.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public  static void create(Context cx, String [] names, RelativeLayout rl,Drawable dr){
        LinearLayout li = new LinearLayout(cx);
        li.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        li.setOrientation(LinearLayout.VERTICAL);
        int sdk = android.os.Build.VERSION.SDK_INT;
        int jellyBean = android.os.Build.VERSION_CODES.JELLY_BEAN;
        for(int i=0;i<names.length;i++){
            EditText ed = new EditText(cx);
            ed.setHint(names[i]);
            ed.setId(i);
            ed.setBackground(dr);
            ed.setPadding(5,5,5,5);
            ed.setHintTextColor(Color.BLACK);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(30,15,30,15);
            ed.setLayoutParams(params);
            li.addView(ed);

        }
        rl.addView(li);


    }
}
