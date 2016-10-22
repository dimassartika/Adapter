package com.example.pustikom.adapterplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pustikom.adapterplay.com.example.pustikom.adapter.StudentArrayAdapter;
import com.example.pustikom.adapterplay.com.example.pustikom.user.Student;

import java.util.ArrayList;

/**
 * Created by pustikom on 07/10/16.
 */

public class StudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        ArrayList<Student> students = new StudentArrayList().getList();
        StudentArrayAdapter studentArrayAdapter = new StudentArrayAdapter(this,students);
        ListView list_item = (ListView) findViewById(R.id.list_item);
        list_item.setAdapter(studentArrayAdapter);
        studentArrayAdapter.notifyDataSetChanged();


        list_item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(), "Clicked "+position, Toast.LENGTH_LONG).show();
				
				//
                Intent intent = new Intent(getApplicationContext(),EditStudentActivity.class);
				//putExtra buat ngirim data "no"/Id yg mau di edit to EditStudentActivity
                intent.putExtra("no", position);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.createDummy:
                createDummy();
				//notify on the bottom
                Toast.makeText(this, "Create Dummy Success", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.clearList:
                clearList();
				//notify
                Toast.makeText(this, "Clear List", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.addStudent:
                Intent intent = new Intent(this, AddStudentActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void clearList() {
        StudentArrayList studentArrayList = StudentArrayList.getInstance();
        studentArrayList.clearStudentList();
        StudentArrayAdapter studentArrayAdapter = new StudentArrayAdapter(this, studentArrayList.getList());
        ListView list_item = (ListView) findViewById(R.id.list_item);
        list_item.setAdapter(studentArrayAdapter);
        studentArrayAdapter.notifyDataSetChanged();
    }

    public void createDummy(){
        ArrayList<Student> students = populateStudentDummies();
        StudentArrayAdapter studentArrayAdapter = new StudentArrayAdapter(this,students);
        ListView list_item = (ListView) findViewById(R.id.list_item);
        list_item.setAdapter(studentArrayAdapter);
		//refresh the listview?
        studentArrayAdapter.notifyDataSetChanged();
    }

    private ArrayList<Student> populateStudentDummies(){
        StudentArrayList studentList = StudentArrayList.getInstance();
        studentList.addStudent(new Student(studentList.sizeStudentList()+1,"3145136214","Dimas Sartika","081219190281","dimassartika@mhs.unj.acs.id"));
        studentList.addStudent(new Student(studentList.sizeStudentList()+1,"3145136188","TRI FEBRIANA SIAMI","0858xxxxxx","tri@mhs.unj.ac.id"));
        studentList.addStudent(new Student(studentList.sizeStudentList()+1,"3145136192","Ummu Kultsum","0813xxxxxx","ummu@mhs.unj.ac.id"));
        return studentList.getList();
    }
}
