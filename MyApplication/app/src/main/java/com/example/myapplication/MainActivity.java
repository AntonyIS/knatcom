package com.example.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inputNames, inputAge;
    TextView txtNumbers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inputNames=findViewById(R.id.inputNames);
        inputAge=findViewById(R.id.inputAge);
        txtNumbers=findViewById(R.id.txtNumbers);

        getStudentNumbers();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               saveDetails();
            }
        });
    }

    private void getStudentNumbers() {
        int number = MyDatabase.getInstance(this).studentDao().getStudentNumber();
        txtNumbers.setText(number+"");
    }

    private void saveDetails() {

        String names = inputNames.getText().toString().trim();
        String age_string = inputAge.getText().toString().trim();

        if (names.isEmpty() || age_string.isEmpty()){
            Toast.makeText(this, "Provide all the values", Toast.LENGTH_SHORT).show();
            return;
        }

        int age = Integer.parseInt(age_string);

        final Student student=new Student();
        student.setNames(names);
        student.setAge(age);
        new Thread(new Runnable() {
            @Override
            public void run() {
                MyDatabase.getInstance(MainActivity.this).studentDao().insert(student);
            }
        }).start();

        inputAge.setText("");
        inputNames.setText("");
        getStudentNumbers();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
