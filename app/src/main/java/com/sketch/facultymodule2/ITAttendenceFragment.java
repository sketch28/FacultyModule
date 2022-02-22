package com.sketch.facultymodule2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class ITAttendenceFragment extends Fragment {

    private RecyclerView recyclerView;
    private Button btnAllPresent, btnAllAbsent,btnSave;
    DatabaseReference database,database2;
    FirebaseDatabase firebaseDatabase;
    ArrayList<Student_IT> list ;
    public Student_IT students_IT;
    AttendenceAdapter_IT attendenceAdapter;
    RadioButton radioButton1;

    public ITAttendenceFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_it_attendence, container, false);

        recyclerView = view.findViewById(R.id.lvStudents_it_attendence);
        btnSave = view.findViewById(R.id.btnSaveAttendance_it_attendence);

        students_IT = new Student_IT();

        database = FirebaseDatabase.getInstance().getReference("Students_it");
        database2 = FirebaseDatabase.getInstance().getReference("Students Attendence");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList<>();

        attendenceAdapter = new AttendenceAdapter_IT(getContext(),list);
        recyclerView.setAdapter(attendenceAdapter);


        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Student_IT students_IT = dataSnapshot.getValue(Student_IT.class);
                    list.add(students_IT);
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

        return view;
    }
}