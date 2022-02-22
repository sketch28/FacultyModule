package com.sketch.facultymodule2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class DepartmentActivity extends AppCompatActivity {

    private Button btnAddStudents,btnAttendence,btnViewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);

        btnAddStudents = findViewById(R.id.btn_add_students);
        btnAttendence = findViewById(R.id.btn_attendence);
        btnViewAll = findViewById(R.id.btn_view_all);

        btnAddStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DepartmentActivity.this, AddStudentsActivity.class));
            }
        });

        btnAttendence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DepartmentActivity.this,AttendenceActivity.class));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()== R.id.menu_item_profile){
            startActivity(new Intent(DepartmentActivity.this,Profile.class));
        }
        return super.onOptionsItemSelected(item);
    }

}