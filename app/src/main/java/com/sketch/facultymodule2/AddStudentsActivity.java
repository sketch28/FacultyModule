package com.sketch.facultymodule2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddStudentsActivity extends AppCompatActivity {
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_students);

        btnAddStudents = (Button) findViewById(R.id.add_students_rb);
        btnClear = (Button) findViewById(R.id.btn_clear_rb);
        radioGroupDepartment = (RadioGroup) findViewById(R.id.gr_Department);
        radioGroupYears = (RadioGroup) findViewById(R.id.gr_Years);
        radioGroupBatches = (RadioGroup) findViewById(R.id.gr_batches);
        //Department
        rbCs = (RadioButton) findViewById(R.id.rb_CS);
        rbIt = (RadioButton) findViewById(R.id.rb_IT);
        //Years
        rb1yr = (RadioButton) findViewById(R.id.rb_first_year);
        rb2yr = (RadioButton) findViewById(R.id.rb_second_year);
        rb3yr = (RadioButton) findViewById(R.id.rb_third_year);
        rb4yr = (RadioButton) findViewById(R.id.rb_fourth_year);
        //Batches
        rb1batch = (RadioButton) findViewById(R.id.rb_first_batch);
        rb2batch = (RadioButton) findViewById(R.id.rb_second_batch);



        ilName = (TextInputLayout) findViewById(R.id.tLayoutName);
        ilRollno = (TextInputLayout) findViewById(R.id.tLayoutRollNo);
        iledtName = (TextInputEditText) findViewById(R.id.TIedtName);
        iledtRollno = (TextInputEditText) findViewById(R.id.TIedtRollNo);
        students = new Students();
        reference = FirebaseDatabase.getInstance().getReference().child("Students");


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


//                // When submit button is clicked,
//                // Ge the Radio Button which is set
//                // If no Radio Button is set, -1 will be returned
//                int selectedId = radioGroupDepartment.getCheckedRadioButtonId();
//                if (selectedId == -1) {
//                    Toast.makeText(AddStudentsActivity.this,
//                            "Department not selected",
//                            Toast.LENGTH_SHORT)
//                            .show();
//                } else {
//
//                    RadioButton radioButton
//                            = (RadioButton) radioGroupDepartment
//                            .findViewById(selectedId);
//
//                    // Now display the value of selected item
//                    // by the Toast message
//                    Toast.makeText(AddStudentsActivity.this,
//                            radioButton.getText(),
//                            Toast.LENGTH_SHORT)
//                            .show();
//                }
//
//
//                int selectedId2 = radioGroupYears.getCheckedRadioButtonId();
//                if (selectedId2 == -1) {
//                    Toast.makeText(AddStudentsActivity.this,
//                            "years not  selected",
//                            Toast.LENGTH_SHORT)
//                            .show();
//                } else {
//
//                    RadioButton radioButton
//                            = (RadioButton) radioGroupYears
//                            .findViewById(selectedId);
//
//                    // Now display the value of selected item
//                    // by the Toast message
//                    Toast.makeText(AddStudentsActivity.this,
//                            radioButton.getText(),
//                            Toast.LENGTH_SHORT)
//                            .show();
//                }
//
//                int selectedId3 = radioGroupBatches.getCheckedRadioButtonId();
//                if (selectedId3 == -1) {
//                    Toast.makeText(AddStudentsActivity.this,
//                            " batches not  selected",
//                            Toast.LENGTH_SHORT)
//                            .show();
//                } else {
//
//                    RadioButton radioButton
//                            = (RadioButton) radioGroupBatches
//                            .findViewById(selectedId);
//
//                    // Now display the value of selected item
//                    // by the Toast message
//                    Toast.makeText(AddStudentsActivity.this,
//                            radioButton.getText(),
//                            Toast.LENGTH_SHORT)
//                            .show();
//                }
                //Firebase Coding
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
                Toast.makeText(AddStudentsActivity.this, "Student Added", Toast.LENGTH_SHORT).show();
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

}
