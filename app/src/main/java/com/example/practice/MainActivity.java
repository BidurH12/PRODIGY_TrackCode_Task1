package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btndiv, btnmul, btnsub, btnadd, btnA, btneql, btnP, btnC, btn;
    TextView textView2, textView;
    private String input, output;
    private String newO,newI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);
        textView2 = findViewById(R.id.textview2);
        assignid(button1, R.id.button1);
        assignid(btn2, R.id.btn2);
        assignid(btn2, R.id.btn2);
        assignid(btn3, R.id.btn3);
        assignid(btn4, R.id.btn4);
        assignid(btn5, R.id.btn5);
        assignid(btn6, R.id.btn6);
        assignid(btn7, R.id.btn7);
        assignid(btn8, R.id.btn8);
        assignid(btn9, R.id.btn9);
        assignid(btn0, R.id.btn0);
        assignid(btndiv, R.id.btndiv);
        assignid(btnmul, R.id.btnmul);
        assignid(btnadd, R.id.btnadd);
        assignid(btnsub, R.id.btnsub);
        assignid(btnA, R.id.btnA);
        assignid(btneql, R.id.btneql);
        assignid(btnP, R.id.btnP);
        assignid(btnC, R.id.btnC);
        assignid(btn, R.id.btn);
    }

    void assignid(Button btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data) {
            case "AC":
                input = null;
                output = null;
                textView2.setText("");
                break;
            case "*":
                input += "*";
                solve();
                break;
            case "C":
                input=input.substring(0,input.length()-1);
                break;
            case "=":
                solve();
                break;
            case "+":
                input += "+";
                solve();
                break;
            case "-":
                input += "-";
                solve();
                break;
            case "/":
                input += "/";
                solve();
                break;
            case "%":
                input += "%";
                double d = Double.parseDouble(textView.getText().toString()) / 100;
                textView2.setText(String.valueOf(d));
                break;
            default:
                if (input == null) {
                    input = "";
                }
                if (data.equals("+") || data.equals("/") || data.equals("-")||data.equals("*")) {
                    solve();
                }
                input += data;
        }
        textView.setText(input);
    }

    private void solve() {
        if (input.split("\\+").length == 2) {
            String numbers[]=input.split("\\+");
            try {
                double d = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
                output=Double.toString(d);
                newO=remove(output);
                textView2.setText(newO);
                input=d+"";
                input=remove(input);
            } catch (Exception e) {
                textView2.setError(e.getMessage().toString());
            }
        } if (input.split("\\-").length == 2) {
            String numbers[]=input.split("\\-");
            try {
                double d = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                output=Double.toString(d);
                newO=remove(output);
                textView2.setText(newO);
                input=d+"";
                input=remove(input);

            } catch (Exception e) {
                textView2.setError(e.getMessage().toString());
            }
        }
        if (input.split("\\*").length == 2) {
            String numbers[]=input.split("\\*");
            try {
                double d = Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
                output=Double.toString(d);
                newO=remove(output);
                textView2.setText(newO);
                input=d+"";
                input=remove(input);
            } catch (Exception e) {
                textView2.setError(e.getMessage().toString());
            }
        }
        if (input.split("\\/").length == 2) {
            String numbers[]=input.split("\\/");
            try {
                double d = Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
                output=Double.toString(d);
                newO=remove(output);
                textView2.setText(newO);
                input=d+"";
                input=remove(input);
            } catch (Exception e) {
                textView2.setError(e.getMessage().toString());
            }
        }
    }
    private String remove(String number){
        String n[]=number.split("\\.");
        if(n.length>1){
            if(n[1].equals("0")){
                number=n[0];
            }
        }
        return number;
    }
}