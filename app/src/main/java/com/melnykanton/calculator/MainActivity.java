package com.melnykanton.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText firstDigit;
    private EditText secondDigit;

    private Button plus;
    private Button minus;
    private Button multiple;
    private Button divide;

    private TextView result;

    private String oper = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //views
        result = (TextView) findViewById(R.id.result);
        firstDigit = (EditText) findViewById(R.id.first_digit_input);
        secondDigit = (EditText) findViewById(R.id.second_digit_input);

        //buttons
        plus = (Button) findViewById(R.id.btn_plus);
        minus = (Button) findViewById(R.id.btn_minus);
        multiple = (Button) findViewById(R.id.btn_multiple);
        divide = (Button) findViewById(R.id.btn_divide);

        //set Listener
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiple.setOnClickListener(this);
        divide.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        float num1 = 0;
        float num2 = 0;
        float results = 0;

        if (TextUtils.isEmpty(firstDigit.getText().toString()) || TextUtils.isEmpty(secondDigit.getText().toString())) {
            return;
        }

        //read input
        num1 = Float.parseFloat(firstDigit.getText().toString());
        num2 = Float.parseFloat(secondDigit.getText().toString());

        switch (v.getId()){
            case R.id.btn_plus:
                oper = "+";
                results = num1 + num2;
                break;
            case R.id.btn_minus:
                oper = "-";
                results = num1 - num2;
                break;
            case R.id.btn_multiple:
                oper = "*";
                results = num1 * num2;
                break;
            case R.id.btn_divide:
                oper = "/";
                results = num1/num2;
                break;
            default:
                break;
        }

        result.setText(num1 + " " + oper + " " + num2 + " = " + results);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.calc_context_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.reset:
                firstDigit.setText("");
                secondDigit.setText("");
                result.setText("");
                break;
            case R.id.quit:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
