package com.sketch.facultymodule2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AttendenceActivity extends AppCompatActivity {

   private RecyclerView recyclerView;
   private Button btnAllPresent, btnAllAbsent,btnSave;
    DatabaseReference database,database2;
    FirebaseDatabase firebaseDatabase;
    ArrayList<Students> list ;
    public Students students;
    AttendenceAdapter attendenceAdapter;
    RadioButton radioButton1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence);
        recyclerView = findViewById(R.id.lvStudents);
        btnSave = findViewById(R.id.btnSaveAttendance);

        students = new Students();

        database = FirebaseDatabase.getInstance().getReference("Students");
        database2 = FirebaseDatabase.getInstance().getReference("Students Attendence");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        attendenceAdapter = new AttendenceAdapter(this,list);
        recyclerView.setAdapter(attendenceAdapter);


        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Students students = dataSnapshot.getValue(Students.class);
                    list.add(students);
                }

                attendenceAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}