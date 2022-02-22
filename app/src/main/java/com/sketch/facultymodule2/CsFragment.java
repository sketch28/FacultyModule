package com.sketch.facultymodule2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class CsFragment extends Fragment {

    private RadioGroup radioGroupDepartment, radioGroupYears, radioGroupBatches;
    private RadioButton rbCs,rbIt;
    private RadioButton rb1yr,rb2yr,rb3yr,rb4yr;
    private RadioButton rb1batch,rb2batch;
    private Button btnAddStudents, btnClear;
    private TextInputLayout ilName,ilRollno;
    private TextInputEditText iledtName,iledtRollno;
    DatabaseReference reference;
    FirebaseDatabase firebaseDatabase;
    public Students students;

    public CsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        btnAddStudents = (Button) getView().findViewById(R.id.add_students_rb_cs);
        btnClear = (Button) getView().findViewById(R.id.btn_clear_rb_cs);
        radioGroupDepartment = (RadioGroup) getView().findViewById(R.id.gr_Department_cs);
        radioGroupYears = (RadioGroup) getView().findViewById(R.id.gr_Years_cs);
        radioGroupBatches = (RadioGroup) getView().findViewById(R.id.gr_batches_cs);
        //Department
        rbCs = (RadioButton) getView().findViewById(R.id.rb_CS);
//        rbIt = (RadioButton) getView().findViewById(R.id.rb_IT);
        //Years
        rb1yr = (RadioButton) getView(). findViewById(R.id.rb_first_year_cs);
        rb2yr = (RadioButton) getView().findViewById(R.id.rb_second_year_cs);
        rb3yr = (RadioButton)getView(). findViewById(R.id.rb_third_year_cs);
        rb4yr = (RadioButton) getView().findViewById(R.id.rb_fourth_year_cs);
        //Batches
        rb1batch = (RadioButton) getView().findViewById(R.id.rb_first_batch_cs);
        rb2batch = (RadioButton) getView().findViewById(R.id.rb_second_batch_cs);

        ilName = (TextInputLayout) getView().findViewById(R.id.tLayoutName_cs);
        ilRollno = (TextInputLayout) getView().findViewById(R.id.tLayoutRollNo_cs);
        iledtName = (TextInputEditText) getView().findViewById(R.id.TIedtName_cs);
        iledtRollno = (TextInputEditText) getView().findViewById(R.id.TIedtRollNo_cs);
        students = new Students();
        reference = FirebaseDatabase.getInstance().getReference().child("Students_cs");


        radioGroupDepartment.clearCheck();
        radioGroupYears.clearCheck();
        radioGroupBatches.clearCheck();

        // Add the Listener to the RadioGroup
        radioGroupDepartment.setOnCheckedChangeListener(
                new RadioGroup
                        .OnCheckedChangeListener() {
                    @Override

                    // The flow will come here when
                    // any of the radio buttons in the radioGroup
                    // has been clicked

                    // Check which radio button has been clicked
                    public void onCheckedChanged(RadioGroup group,
                                                 int checkedId) {

                        // Get the selected Radio Button
                        RadioButton
                                radioButton
                                = (RadioButton) group
                                .findViewById(checkedId);
                    }
                });

        radioGroupYears.setOnCheckedChangeListener(
                new RadioGroup
                        .OnCheckedChangeListener() {
                    @Override

                    // The flow will come here when
                    // any of the radio buttons in the radioGroup
                    // has been clicked

                    // Check which radio button has been clicked
                    public void onCheckedChanged(RadioGroup group,
                                                 int checkedId) {

                        // Get the selected Radio Button
                        RadioButton
                                radioButton
                                = (RadioButton) group
                                .findViewById(checkedId);
                    }
                });

        // Add the Listener to the Submit Button
        btnAddStudents.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String D1 = rbCs.getText().toString();
                String D2 = rbIt.getText().toString();

                students.setStudentName(iledtName.getText().toString().trim());
                students.setRollNo(iledtRollno.getText().toString().trim());

                if(rbCs.isChecked()){
                    students.setDepartment(D1);


                }else{
                    students.setDepartment(D2);
                }
                String Y1 = rb1yr.getText().toString();
                String Y2= rb2yr.getText().toString();
                String Y3= rb3yr.getText().toString();
                String Y4= rb4yr.getText().toString();
                if(rb1yr.isChecked()){
                    students.setYears(Y1);
                }
                else if(rb2yr.isChecked()){
                    students.setYears(Y2);
                }
                else if(rb3yr.isChecked()){
                    students.setYears(Y3);
                }else
                {
                    students.setYears(Y4);
                }
                String B1 = rb1batch.getText().toString();
                String B2 = rb2batch.getText().toString();
                if(rb1batch.isChecked()){
                    students.setBatches(B1);
                }
                else{
                    students.setBatches(B2);
                }
                reference.push().setValue(students);
//                Toast.makeText(AddStudentsActivity.this, "Student Added", Toast.LENGTH_SHORT).show();
            }
        });
        // Add the Listener to the Submit Button
        btnClear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Clear RadioGroup
                // i.e. reset all the Radio Buttons
                radioGroupDepartment.clearCheck();
                radioGroupYears.clearCheck();
                radioGroupBatches.clearCheck();
                iledtName.setText("");
                iledtRollno.setText("");


            }
        });
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cs, container, false);
    }
}