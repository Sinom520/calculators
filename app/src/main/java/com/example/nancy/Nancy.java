package com.example.nancy;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.math.BigDecimal;
import java.util.Objects;

import static com.example.nancy.R.id.txt;

public class Nancy extends AppCompatActivity{
    private BigDecimal num = new BigDecimal("0");
    private BigDecimal num1 = new BigDecimal("0");//计算中临时储存数字的地方，用于加减法中。
    private BigDecimal num2 = new BigDecimal("0");//计算中临时储存数字的地方。
    private BigDecimal num3 = new BigDecimal("1");//计算中临时储存数字的地方，用于乘除法中。
    private BigDecimal num4 = new BigDecimal("0");//用来连续等于时记录不变的num2.
    private BigDecimal sum = new BigDecimal("0");//最后输出的结果。
    private StringBuffer str1 = new StringBuffer();//用来叠加数字和储存数字。
    private String str2 = "0";//用以在特殊情况下显示在显示框中。
    private String str3;//用来判断输出数字的美观性。
    private String str;//用在加减号判断中。
    private String result1 = "除数不能为零";
    private String result2 = "结果未定义";
    private String result3 = "结果超出15位数";
    private int op=0;//用来判断执行哪种运算。
    private int op1=0;//用来在连续按等号时判断进行哪种运算。
    private boolean flag1 = true;//判断是否按下过等号。
    private boolean flag2 = true;//判断是否连续按等号。
    private boolean flag3;//判断是否按下多个运算符。

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nancy);
        final TextView text=(TextView)findViewById(R.id.txt);
        text.setText("0");
        Button Btn1 = (Button) findViewById(R.id.Btn1);
        Button Btn2 = (Button) findViewById(R.id.Btn2);
        Button Btn3 =(Button) findViewById(R.id.Btn3);
        Button Btn4 =(Button) findViewById(R.id.Btn4);
        Button Btn5 =(Button) findViewById(R.id.Btn5);
        Button Btn6 =(Button) findViewById(R.id.Btn6);
        Button Btn7 =(Button) findViewById(R.id.Btn7);
        Button Btn8 =(Button) findViewById(R.id.Btn8);
        Button Btn9 =(Button) findViewById(R.id.Btn9);
        Button Btn0 =(Button) findViewById(R.id.Btn0);
        Button BtnPoint =(Button) findViewById(R.id.BtnPoint);
        Button BtnPlus =(Button) findViewById(R.id.BtnPlus);
        Button BtnMinus =(Button) findViewById(R.id.BtnMinus);
        Button BtnMultiply =(Button) findViewById(R.id.BtnMultiply);
        Button BtnDivide =(Button) findViewById(R.id.BtnDivide);
        Button BtnEqual =(Button) findViewById(R.id.BtnEqual);
        Button BtnSign =(Button) findViewById(R.id.BtnSign);
        Button BtnSquare =(Button) findViewById(R.id.BtnSquare);
        Button BtnReciprocal =(Button) findViewById(R.id.BtnReciprocal);
        Button BtnRooting =(Button) findViewById(R.id.BtnRooting);
        Button BtnC =(Button) findViewById(R.id.BtnC);
        Button BtnCE =(Button) findViewById(R.id.BtnCE);
        Button BtnBack =(Button) findViewById(R.id.BtnBack);
        Button button_1 =(Button) findViewById(R.id.button_1);


        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str1.length()<15){
                    str1.append("1");
                }
                text.setText(str1.toString());
            }
        });
        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str1.length()<15){
                    str1.append("2");
                }
                text.setText(str1.toString());
            }
        });
        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str1.length()<15){
                    str1.append("3");
                }
                text.setText(str1.toString());
            }
        });
        Btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str1.length()<15){
                    str1.append("4");
                }
                text.setText(str1.toString());
            }
        });
        Btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str1.length()<15){
                    str1.append("5");
                }
                text.setText(str1.toString());
            }
        });
        Btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str1.length()<15){
                    str1.append("6");
                }
                text.setText(str1.toString());
            }
        });
        Btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str1.length()<15){
                    str1.append("7");
                }
                text.setText(str1.toString());
            }
        });
        Btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str1.length()<15){
                    str1.append("8");
                }
                text.setText(str1.toString());
            }
        });
        Btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str1.length()<15){
                    str1.append("9");
                }
                text.setText(str1.toString());
            }
        });
        Btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str1.length()==0) {
                    text.setText(str2.toString());
                }
                else
                  if (str1.length()<15){
                      str1.append("0");
                      text.setText(str1.toString());
                  }
                  else text.setText(str1.toString());
            }
        });
        BtnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = text.getText().toString();
                if (!str.contains(".")){
                    if (str1.length()==0){
                        str1.append("0");
                        str1.append(".");
                    }
                    else {
                        str1.append(".");
                    }
                }
                text.setText(str1.toString());
            }
        });
        BtnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = text.getText().toString();
                double account = Double.parseDouble(str);
                if (account>0){
                    str = "-"+str;
                }
                else {
                    if (account<0){
                        str = str.replace("-","");
                    }
                    else {
                        if (account==0&&str.contains("0.")&&!str.contains("-")){
                            str = "-"+str;
                        }
                        else {
                            if (account==0&&str.contains("0.")&&str.contains("-")){
                                str = str.replace("-","");
                            }
                        }
                    }
                }
                text.setText(str);
                str1 = new StringBuffer(str1);
            }
        });
        BtnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str1.length()==0&&op==1) {
                    text.setText(num1.toString());
                }
                else {
                    if (flag1) {
                        num2 = new BigDecimal(text.getText().toString());
                        sum = new BigDecimal("" + num1.add(num2));
                        text.setText(sum.toString());
                        num1 = new BigDecimal(text.getText().toString());
                        str1 = new StringBuffer();
                        flag2 = true;
                        op = 1;
                        op1 = 0;
                    }
                    else {
                        num1 = new BigDecimal(text.getText().toString());
                        text.setText(num1.toString());
                        str1 = new StringBuffer();
                        flag2 = true;
                        op = 1;
                        op1 = 0;
                    }
                    }
            }
        });
        BtnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str1.length()==0&&op==2){
                    text.setText(num1.toString());
                }
                else {
                    if (flag1) {
                        num2 = new BigDecimal(text.getText().toString());
                        sum = new BigDecimal("" + num2.subtract(num1));
                        text.setText(sum.toString());
                        num1 = new BigDecimal(text.getText().toString());
                        str1 = new StringBuffer();
                        flag2 = true;
                        op = 2;
                        op1 = 0;
                    }
                    else  {
                        num1 = new BigDecimal(text.getText().toString());
                        text.setText(num1.toString());
                        flag2 = true;
                        op = 2;
                        op1 = 0;
                    }
                    }

            }
        });
        BtnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str1.length()==0&&op==3){
                    text.setText(str1.toString());
                }
                else {
                    if (flag1) {
                        num2 = new BigDecimal(text.getText().toString());
                        sum = new BigDecimal("" + num2.multiply(num3));
                        text.setText(sum.toString());
                        num3 = new BigDecimal(text.getText().toString());
                        op = 3;
                        op1 = 0;
                        flag2 = true;
                        str1 = new StringBuffer();
                    }
                    else  {
                        num1 = new BigDecimal(text.getText().toString());
                        text.setText(num1.toString());
                        flag2 = true;
                        op = 3;
                        op1 = 0;
                    }
                }
            }
        });
        BtnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str1.length()==0&&op==4){
                    text.setText(str.toString());
                }
                else {
                    if (flag1) {
                        num2 = new BigDecimal(text.getText().toString());
                        sum = new BigDecimal("" + num2.divide(num3));
                        text.setText(sum.toString());
                        num3 = new BigDecimal(text.getText().toString());
                        str1 = new StringBuffer();
                        flag2 = true;
                        op = 4;
                        op1 = 0;
                    }
                    else  {
                        num1 = new BigDecimal(text.getText().toString());
                        text.setText(num1.toString());
                        flag2 = true;
                        op = 4;
                        op1 = 0;
                    }
                }
            }
        });
        BtnRooting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num=new BigDecimal(text.getText().toString());
                double a=num.setScale(15, BigDecimal.ROUND_HALF_UP).doubleValue();
                double b=Math.sqrt(a);
                String c=String.valueOf(b);
                if (c.indexOf(".") > 0) {
                    c = c.replaceAll("0+?$", "");//去掉多余的0
                    c = c.replaceAll("[.]$", "");//如最后一位是.则去掉
                }
                    text.setText(c);
                    str1 = new StringBuffer(c);
                    flag2 = true;
            }
        });
        BtnReciprocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num=new BigDecimal(text.getText().toString());
                double a=num.setScale(15, BigDecimal.ROUND_HALF_UP).doubleValue();
                if (a!=0) {
                    double b = 1 / a;
                    String c = String.valueOf(b);
                    if (c.indexOf(".") > 0) {
                        c = c.replaceAll("0+?$", "");//去掉多余的0
                        c = c.replaceAll("[.]$", "");//如最后一位是.则去掉
                    }
                        text.setText(c);
                        str1 = new StringBuffer(c);
                        flag2 = true;
                }
                else {
                    text.setText(result1);
                }
            }
        });
        BtnSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num=new BigDecimal(text.getText().toString());
                double a=num.setScale(20, BigDecimal.ROUND_HALF_UP).doubleValue();
                double b = Math.pow(a,2);
                String c = String.valueOf(b);
                if (c.indexOf(".") > 0) {
                    c = c.replaceAll("0+?$", "");//去掉多余的0
                    c = c.replaceAll("[.]$", "");//如最后一位是.则去掉
                    }
                        text.setText(c);
                        str1 = new StringBuffer(c);
                        flag2 = true;
            }
        });

        BtnEqual.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                flag1 = false;
                if (flag2) {
                    switch (op) {
                        case 1: {
                            num2 = new BigDecimal(text.getText().toString());
                            num4 = new BigDecimal(String.valueOf(num2));
                            sum = new BigDecimal("" + num1.add(num2));
                            num1 = new BigDecimal(String.valueOf(sum));
                            str3 = String.valueOf(sum);
                            if (str3.indexOf(".") > 0) {
                                str3 = str3.replaceAll("0+?$", "");//去掉多余的0
                                str3 = str3.replaceAll("[.]$", "");//如最后一位是.则去掉
                            }
                            if (str3.length()>15){
                                text.setText(result3);
                            }
                            else {
                                text.setText(str3);
                                str1 = new StringBuffer(str3);
                                op = 0;
                                op1 = 1;
                            }
                        }
                        break;
                        case 2: {
                            num2 = new BigDecimal(text.getText().toString());
                            num4 = new BigDecimal(String.valueOf(num2));
                            sum = new BigDecimal("" + num1.subtract(num2));
                            num1 = new BigDecimal(String.valueOf(sum));
                            str3 = String.valueOf(sum);
                            if (str3.indexOf(".") > 0) {
                                str3 = str3.replaceAll("0+?$", "");//去掉多余的0
                                str3 = str3.replaceAll("[.]$", "");//如最后一位是.则去掉
                            }
                            if (str3.length()>15){
                                text.setText(result3);
                            }
                            else {
                                text.setText(str3);
                                str1 = new StringBuffer(str3);
                                op = 0;
                                op1 = 2;
                            }
                        }
                        break;
                        case 3: {
                            num2 = new BigDecimal(text.getText().toString());
                            num4 = new BigDecimal(String.valueOf(num2));
                            sum = new BigDecimal("" + num3.multiply(num2));
                            num3 = new BigDecimal(String.valueOf(sum));
                            str3 = String.valueOf(sum);
                            if (str3.indexOf(".") > 0) {
                                str3 = str3.replaceAll("0+?$", "");//去掉多余的0
                                str3 = str3.replaceAll("[.]$", "");//如最后一位是.则去掉
                            }
                            if (str3.length()>15){
                                text.setText(result3);
                            }
                            else {
                                text.setText(str3);
                                str1 = new StringBuffer(str3);
                                op = 0;
                                op1 = 3;
                            }
                        }
                        break;
                        case 4: {
                            num2 = new BigDecimal(text.getText().toString());
                            if (Objects.equals(num2, new BigDecimal("0")) && Objects.equals(num3, new BigDecimal("0"))) {
                                text.setText(result2);
                            } else {
                                if (Objects.equals(num2, new BigDecimal("0"))) {
                                    text.setText(result1);
                                } else {
                                    sum = new BigDecimal("" + num3.divide(num2));
                                    num3 = new BigDecimal(String.valueOf(sum));
                                    str3 = String.valueOf(sum);
                                    if (str3.indexOf(".") > 0) {
                                        str3 = str3.replaceAll("0+?$", "");//去掉多余的0
                                        str3 = str3.replaceAll("[.]$", "");//如最后一位是.则去掉
                                    }
                                    if (str3.length()>15){
                                        text.setText(result3);
                                    }
                                    else {
                                        num4 = new BigDecimal(String.valueOf(num2));
                                        text.setText(str3);
                                        str1 = new StringBuffer(str3);
                                        op = 0;
                                        op1 = 4;
                                    }
                                }
                            }
                            break;
                        }
                    }
                    flag2 = false;
                }
                else {
                    switch (op1){
                        case 1: {
                            num1 = new BigDecimal(text.getText().toString());
                            sum = new BigDecimal(String.valueOf(num1.add(num4)));
                            text.setText(sum.toString());
                        }
                        break;
                        case 2:{
                            num1 = new BigDecimal(text.getText().toString());
                            sum = new BigDecimal(String.valueOf(num1.subtract(num4)));
                            text.setText(sum.toString());
                        }
                        break;
                        case 3:{
                            num1 = new BigDecimal(text.getText().toString());
                            sum = new BigDecimal(String.valueOf(num1.multiply(num4)));
                            text.setText(sum.toString());
                        }
                        break;
                        case 4:{
                            num1 = new BigDecimal(text.getText().toString());
                            sum = new BigDecimal(String.valueOf(num1.divide(num4)));
                            text.setText(sum.toString());
                        }
                        break;
                        }
                    }
                }
        });
        BtnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                op = 0;
                num1 = new BigDecimal("0");
                num2 = new BigDecimal("0");
                num3 = new BigDecimal("1");
                str1 = new StringBuffer();
                sum = new BigDecimal("0");
                text.setText(str2.toString());
                flag1 = true;
            }
        });
        BtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str1.length()>1){
                    str1.deleteCharAt(str1.length()-1);
                    text.setText(str1);
                }
                else {
                    if (str1.length()==1){
                        str1 = new StringBuffer();
                        text.setText(str2);
                    }
                    else {
                        text.setText(str2);
                    }
                }

            }
        });
        BtnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num2 = new BigDecimal("0");
                text.setText(str2);
                str1 = new StringBuffer();
            }
        });
    }
}