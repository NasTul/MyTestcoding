package nastul.nodex.com.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Calculator extends Activity implements View.OnClickListener {
    //对按钮进行初始化
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn0;
    Button add;
    Button min;
    Button mul;
    Button div;
    Button equ;
    Button cls;
    Button del;
    Button pos;
    EditText editText;
    Boolean flag=true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

    //找到控件
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);
        btn5=(Button)findViewById(R.id.btn5);
        btn6=(Button)findViewById(R.id.btn6);
        btn7=(Button)findViewById(R.id.btn7);
        btn8=(Button)findViewById(R.id.btn8);
        btn9=(Button)findViewById(R.id.btn9);
        btn0=(Button)findViewById(R.id.btn0);
        add=(Button)findViewById(R.id.add);
        min=(Button)findViewById(R.id.min);
        mul=(Button)findViewById(R.id.mul);
        div=(Button)findViewById(R.id.div);
        equ=(Button)findViewById(R.id.equ);
        cls=(Button)findViewById(R.id.cls);
        del=(Button)findViewById(R.id.del);
        pos=(Button)findViewById(R.id.pos);
        editText=(EditText)findViewById(R.id.edittext);
//设置监听
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        add.setOnClickListener(this);
        min.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        cls.setOnClickListener(this);
        equ.setOnClickListener(this);
        pos.setOnClickListener(this);
        del.setOnClickListener(this);




    }


    @Override
    public void onClick(View v) {
        String str=editText.getText().toString();

        switch (v.getId()){

            case R.id.btn0:
            case R.id.btn1:
            case R.id.btn2:
            case R.id.btn3:
            case R.id.btn4:
            case R.id.btn5:
            case R.id.btn6:
            case R.id.btn7:
            case R.id.btn8:
            case R.id.btn9:
            case R.id.pos:

               if(flag){
                    flag=false;
                   str="";
                    editText.setText("");

                }
            editText.setText(str+((Button)v).getText());
            break;
            case R.id.add:
            case R.id.min:
            case R.id.mul:
            case R.id.div:
                if(flag){
                    flag=false;
                    str="";
                    editText.setText("");

                }
                editText.setText(str+" "+((Button)v).getText()+" ");
                break;
            case R.id.cls:
                flag=false;
                editText.setText("");
                break;
            case R.id.del:
                if(flag){
                    flag=false;
                    str="";
                    editText.setText("");

                }
                else if(str!=null&&!(str.equals(""))){
                editText.setText(str.substring(0,str.length()-1));

                }
                break;
            case R.id.equ:
                getResult();
                break;
        }
    }
//进行运算的函数
    private void getResult(){
        String con=editText.getText().toString();
        if(con==null||con.equals("")){
                   return;
            }
        if(!con.contains(" ")){
                return;
        }
         if(flag){
            flag=false;

            return;
        }
       flag=true;
        double result=0;
        String star=con.substring(0,con.indexOf(" "));
        String ope=con.substring(con.indexOf(" ")+1,con.indexOf(" ")+2);
        String end=con.substring(con.indexOf(" ")+3);

        if(!star.equals("")&&!end.equals("")){
        double start1=Double.parseDouble(star);
        double end1=Double.parseDouble(end);
        if(ope.equals("+")){
            result=start1+end1;
        }else if(ope.equals("-")){
            result=start1-end1;

        }
        else if(ope.equals("*")){
            result=start1*end1;
    }
        else if(ope.equals("/")) {
            if(end1==0){
                result=0;
            }else{
                result=start1/end1;
            }
        }
        if(!star.contains(".")&&!end.contains(".")&&!ope.equals("/")){

            int in=(int)result;
            editText.setText(in+"");
        }else{
            editText.setText(result+"");
        }

    }else if(!star.equals("")&&end.equals("")){
        editText.setText(con);

        }



        else if(star.equals("")&&!end.equals("")){

            double end1=Double.parseDouble(end);
            if(ope.equals("+")){
                result=0+end1;
            }else if(ope.equals("-")){
                result=0-end1;

            }
            else if(ope.equals("*")){
                result=0;
            }
            else if(ope.equals("/")) {
                if(end1==0){
                    result=0;

                }
            }
            if(!end.contains(".")){

                int in=(int)result;
                editText.setText(in+"");
            }else{
                editText.setText(result+"");
            }

        }else{
            editText.setText("");
        }

    }
}
