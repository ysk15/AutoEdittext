package com.example.autotextinput;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Ociuz on 7/28/2017.
 */

public class CreateInputs {
    private    Context cx;
    private String[] names;
    private   RelativeLayout rl;
    private   Drawable dr;


    public CreateInputs(Context cx, String[] names, RelativeLayout rl,Drawable dr) {
        this.cx = cx;
        this.names = names;
        this.rl = rl;
        this.dr = dr;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void create(){
        LinearLayout li = new LinearLayout(cx);
        li.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        li.setOrientation(LinearLayout.VERTICAL);
        for(int i=0;i<names.length;i++){
            EditText ed = new EditText(cx);
            ed.setHint(names[i]);
            ed.setId(i);
            ed.setBackground(dr);
            ed.setPadding(5,5,5,5);
            ed.setGravity(View.TEXT_ALIGNMENT_CENTER);
            ed.setMaxLines(1);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(30,20,30,20);
            ed.setLayoutParams(params);
            if(names[i].contains(":")){
                if(names[i].split(":")[1].equals("number")){
                    ed.setInputType(InputType.TYPE_CLASS_PHONE );
                    ed.setHint(names[i].split(":")[0]);

                }
                else if(names[i].split(":")[1].equals("password")){
                    ed.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    ed.setHint(names[i].split(":")[0]);
                }
            }
            li.addView(ed);
        }
        rl.addView(li);
    }
    public  ArrayList<String> getvalues(RelativeLayout rl){
        ArrayList<String> arr = new ArrayList<>();
        for(int i=0;i<names.length;i++){
            EditText ed = (EditText)rl.findViewById(i);
            if(!ed.getText().toString().equals("")){
                arr.add(ed.getText().toString());
            }
        }
        return arr;

    }




}
