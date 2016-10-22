package com.example.pustikom.adapterplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.pustikom.adapterplay.com.example.pustikom.user.Student;


public class AddStudentActivity extends AppCompatActivity {

    EditText name, phone, noreg, email;
    Button addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        //no = (EditText) findViewById(R.id.txtNo);
        noreg = (EditText) findViewById(R.id.txtNoreg);
        name = (EditText) findViewById(R.id.txtName);
        phone = (EditText) findViewById(R.id.txtPhone);
        email = (EditText) findViewById(R.id.txtMail);

        addButton = (Button) findViewById(R.id.btnAdd);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validation()) {
                    addStudent();
                    Intent intent = new Intent(getApplicationContext(), StudentActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean validation() {
        /*
        if(no.getText().toString().isEmpty()){
            no.setError("Insert this field");
            return false;
        }
        */

        if(noreg.getText().toString().isEmpty()){
            noreg.setError("Insert this field");
            return false;
        }
        if(name.getText().toString().isEmpty()){
            name.setError("Insert this field");
            return false;
        }
        if(phone.getText().toString().isEmpty()){
            phone.setError("Insert this field");
            return false;
        }
        if(email.getText().toString().isEmpty()){
            email.setError("Insert this field");
            return false;
        }

        return true;
    }


    private void addStudent(){
        StudentArrayList studentList = StudentArrayList.getInstance();
        studentList.addStudent(new Student(
                studentList.sizeStudentList()+1,
                noreg.getText().toString(),
                name.getText().toString(),
                phone.getText().toString(),
                email.getText().toString()));
    }
}
