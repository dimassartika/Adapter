package com.example.pustikom.adapterplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pustikom.adapterplay.com.example.pustikom.user.Student;

import java.util.ArrayList;

public class EditStudentActivity extends AppCompatActivity {

    EditText name, phone, noreg, email;
    Button editButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        noreg = (EditText) findViewById(R.id.txtNoreg2);
        name = (EditText) findViewById(R.id.txtName2);
        phone = (EditText) findViewById(R.id.txtPhone2);
        email = (EditText) findViewById(R.id.txtMail2);

        editButton = (Button) findViewById(R.id.btnEdit);

        final int value = getIntent().getExtras().getInt("no");

        Student students = new StudentArrayList().getList().get(value);

        noreg.setText(students.getNoreg());
        name.setText(students.getName());
        phone.setText(students.getPhone());
        email.setText(students.getMail());

        editButton = (Button) findViewById(R.id.btnEdit);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editStudent(value);
                Intent intent = new Intent(getApplicationContext(), StudentActivity.class);
                startActivity(intent);
            }
        });
    }

    public void editStudent(int value){
        noreg = (EditText) findViewById(R.id.txtNoreg2);
        name = (EditText) findViewById(R.id.txtName2);
        phone = (EditText) findViewById(R.id.txtPhone2);
        email = (EditText) findViewById(R.id.txtMail2);
        ArrayList<Student> student = new StudentArrayList().getList();
        student.set(value, new Student(
                value+1,
                noreg.getText().toString(),
                name.getText().toString(),
                phone.getText().toString(),
                email.getText().toString()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.editRemove:
                remove();
                //balik ke studentActivity
                Intent intent = new Intent(getApplicationContext(), StudentActivity.class);
                startActivity(intent);

                Toast.makeText(this, "Remove Success", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
	
	//remove student
    private void remove() {
        int value = getIntent().getExtras().getInt("no"); // .getInt('no") -->ambil id nomernya
        ArrayList<Student> students = new StudentArrayList().getList();
        students.remove(value);
    }
}
