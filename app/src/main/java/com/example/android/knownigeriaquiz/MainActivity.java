package com.example.android.knownigeriaquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    String userName; int result = 0; String failed = ""; String message = "";

    /*
    *.........Get all the views for each question ...........................................
    */

    LinearLayout intro_view; LinearLayout result_view;
    LinearLayout question_1_view; LinearLayout question_2_view; LinearLayout question_3_view; //LinearLayout question_4_view;



//    LinearLayout question_5_view = (LinearLayout) findViewById(R.id.question_5_view);
//    LinearLayout question_6_view = (LinearLayout) findViewById(R.id.question_6_view);
//    LinearLayout question_7_view = (LinearLayout) findViewById(R.id.question_7_view);
//    LinearLayout question_8_view = (LinearLayout) findViewById(R.id.question_8_view);
//    LinearLayout question_9_view = (LinearLayout) findViewById(R.id.question_9_view);
//    LinearLayout question_10_view = (LinearLayout) findViewById(R.id.question_10_view);




    public void startQuiz(View view){
        intro_view = (LinearLayout) findViewById(R.id.intro_view);
        result_view = (LinearLayout) findViewById(R.id.result_view);
        question_1_view = (LinearLayout) findViewById(R.id.question_1_view);
        question_2_view = (LinearLayout) findViewById(R.id.question_2_view);
        question_3_view = (LinearLayout) findViewById(R.id.question_3_view);
        //question_4_view = (LinearLayout) findViewById(R.id.question_4_view);

        EditText user_name = (EditText) findViewById(R.id.name);
        userName = user_name.getText().toString().toUpperCase();

        if(userName.equals("")){
            Toast.makeText(this, getString(R.string.no_name), Toast.LENGTH_SHORT).show();
        }else {
            intro_view.setVisibility(View.GONE);
            question_1_view.setVisibility(View.VISIBLE);
        }
    }

    public void gotoQuestion_2(View view){
        RadioGroup group_option = (RadioGroup) findViewById(R.id.question_1_group);
        int user_choice = group_option.getCheckedRadioButtonId();

        // Check if question is answered before moving to the next page

        if(user_choice != -1) {

            // questions is answered so check if answer is correct or not

            RadioButton option_d = (RadioButton) findViewById(R.id.question_1_d);
            boolean question_1_d = option_d.isChecked();

            if (question_1_d){
            result += 1;
            message += getString(R.string.message_info_1) + " \n";
            }else{
                failed += "Question 1 \n";
            }

            question_1_view.setVisibility(View.GONE);
           question_2_view.setVisibility(View.VISIBLE);

        }else{

            // Question is not answered to display a toast....

            Toast.makeText(this, "Answer the question pleas", Toast.LENGTH_SHORT).show();
        }


    }

    public void gotoQuestion_3(View view){
        RadioGroup group_option = (RadioGroup) findViewById(R.id.question_2_group);
        int user_choice = group_option.getCheckedRadioButtonId();

        // Check if question is answered before moving to the next page

        if(user_choice != -1) {

            // questions is answered so check if answer is correct or not

            RadioButton option_c = (RadioButton) findViewById(R.id.question_2_c);
            boolean question_2_c = option_c.isChecked();

            if (question_2_c){
                result += 1;
                message += getString(R.string.message_info_2) + " \n";
            }else{
                failed += "Question 2 \n";
            }

            question_2_view.setVisibility(View.GONE);
            question_3_view.setVisibility(View.VISIBLE);

        }else{

            // Question is not answered to display a toast....

            Toast.makeText(this, "Answer the question pleas", Toast.LENGTH_SHORT).show();
        }
    }

    public void gotoQuestion_4(View view){
        CheckBox option_a = (CheckBox) findViewById(R.id.question_3_a);
        boolean question_3_a = option_a.isChecked();

        CheckBox option_b = (CheckBox) findViewById(R.id.question_3_b);
        boolean question_3_b = option_b.isChecked();

        CheckBox option_c = (CheckBox) findViewById(R.id.question_3_c);
        boolean question_3_c = option_c.isChecked();

        CheckBox option_d = (CheckBox) findViewById(R.id.question_3_d);
        boolean question_3_d = option_d.isChecked();

        if(question_3_a || question_3_b || question_3_c || question_3_d){
            if(question_3_a && !question_3_b && question_3_c && question_3_d){
                result += 1;
                message += getString(R.string.message_info_3) + " \n";
            }else{
                failed += "Question 3 \n";
            }

            question_3_view.setVisibility(View.GONE);

            show_result();
            result_view.setVisibility(View.VISIBLE);
        }else{
            Toast.makeText(this, "Answer the question pleas", Toast.LENGTH_SHORT).show();
        }

    }

    public void reset(View view){
        result = 0; message = ""; userName = ""; failed = "";
        result_view.setVisibility(View.INVISIBLE);
        intro_view.setVisibility(View.VISIBLE);
    }

    public void email(View view){

    }

    private void show_result(){

        TextView display_result = (TextView) findViewById(R.id.result);
        display_result.setText(userName + "\n You got " + result + " questions correctly");

        TextView display_failed = (TextView) findViewById(R.id.failed);
        display_failed.setText("You failed \n" + failed);

    }

}
