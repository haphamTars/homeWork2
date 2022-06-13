package com.example.currnecyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String mode[] ={"VND", "USD" ,"YEN"};
    private TextView display1, display2;
    private Spinner currency1, currency2;
    private boolean newConversion = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display1=findViewById(R.id.convert1);
        display2=findViewById(R.id.convert2);

        currency1=findViewById(R.id.currency1);
        currency2=findViewById(R.id.currency2);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,mode);
        currency1.setAdapter(adapter);
        currency2.setAdapter(adapter);
    }

    private  void updateText(String appendString){
        if(newConversion){
            newConversion=false;
            display1.setText("");
        }
        String str=display1.getText().toString();
        str+=appendString;
        display1.setText(str);
    }

    public void zeroBtn(View view){
        updateText("0");
    }

    public void oneBtn(View view){
        updateText("1");
    }

    public void twoBtn(View view){
        updateText("2");
    }

    public void threeBtn(View view){
        updateText("3");
    }

    public void fourBtn(View view){
        updateText("4");
    }

    public void fiveBtn(View view){
        updateText("5");
    }

    public void sixBtn(View view){
        updateText("6");
    }

    public void sevenBtn(View view){
        updateText("7");
    }

    public void eightBtn(View view){
        updateText("8");
    }

    public void nightBtn(View view){
        updateText("9");
    }

    public void dotBtn(View view){
        updateText(".");
    }

    public void backspaceBtn(View view){
        String str = display1.getText().toString();
        if(str.length()==1){
            display1.setText("0");
            newConversion=true;
        }
        else {
            String newStr = str.substring(0,str.length()-1);
            display1.setText(newStr);
        }
    }

    public void clearBtn(View view){
        newConversion=true;
        display1.setText("0");
    }

    public void equalBtn(View view){
        Double res;
        Double amount = Double.parseDouble(display1.getText().toString());

        String from = currency1.getSelectedItem().toString();
        String to = currency2.getSelectedItem().toString();

        if(from.equals(to)) res = amount;
        else if(from == "VND" && to == "USD"){
            res = amount * 1.0/23182;
        }
        else if(from == "USD" && to == "VND"){
            res = amount * 23182;
        }
        else if (from == "YEN" && to == "VND"){
            res = amount * 172.44;
        }
        else if (from == "VND" && to == "YEN"){
            res = amount * 1.0/172.44;
        }
        else if (from == "USD" && to == "YEN"){
            res = amount * 134.42;
        }
        else if (from == "YEN" && to == "USD"){
            res = amount * 1.0/134.42;
        }
        else {
            res = 0d;
        }
        display2.setText(res.toString());
    }
}