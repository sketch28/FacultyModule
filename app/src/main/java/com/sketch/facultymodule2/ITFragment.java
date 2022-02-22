package com.sketch.facultymodule2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ITFragment extends Fragment {

    private RadioGroup radioGroupDepartment, radioGroupYears, radioGroupBatches;
    private RadioButton rbCs,rbIt;
    private RadioButton rb1yr,rb2yr,rb3yr,rb4yr;
    private RadioButton rb1batch,rb2batch;
    private Button btnAddStudents, btnClear;
    private TextInputLayout ilName,ilRollno;
    private TextInputEditText iledtName,iledtRollno;
    DatabaseReference reference;
    FirebaseDatabase firebaseDatabase;
    public Student_IT students_IT;

    private View ITView;

    public ITFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        ITView= inflater.inflate(R.layout.fragment_i_t, container, false);
        btnAddStudents = (Button) ITView.findViewById(R.id.add_students_rb_it);
        btnClear = (Button) ITView.findViewById(R.id.btn_clear_rb);
        radioGroupDepartment = (RadioGroup) ITView.findViewById(R.id.gr_Department);
        radioGroupYears = (RadioGroup) ITView.findViewById(R.id.gr_Years);
        radioGroupBatches = (RadioGroup) ITView.findViewById(R.id.gr_batches);
        //Department
//        rbCs = (RadioButton) getView().findViewById(R.id.rb_CS);
        rbIt = (RadioButton) ITView.findViewById(R.id.rb_IT);
        //Years
        rb1yr = (RadioButton) ITView. findViewById(R.id.rb_first_year);
        rb2yr = (RadioButton) ITView.findViewById(R.id.rb_second_year);
        rb3yr = (RadioButton) ITView. findViewById(R.id.rb_third_year);
        rb4yr = (RadioButton) ITView.findViewById(R.id.rb_fourth_year);
        //Batches
        rb1batch = (RadioButton) ITView.findViewById(R.id.rb_first_batch);
        rb2batch = (RadioButton) ITView.findViewById(R.id.rb_second_batch);

        ilName = (TextInputLayout) ITView.findViewById(R.id.tLayoutName);
        ilRollno = (TextInputLayout) ITView.findViewById(R.id.tLayoutRollNo);
        iledtName = (TextInputEditText) ITView.findViewById(R.id.TIedtName);
        iledtRollno = (TextInputEditText) ITView.findViewById(R.id.TIedtRollNo);
        students_IT = new Student_IT();
        reference = FirebaseDatabase.getInstance().getReference().child("Students_it");


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

                String D1 = rbIt.getText().toString();

                students_IT.setStudentName_IT(iledtName.getText().toString().trim());
                students_IT.setRollNo_IT(iledtRollno.getText().toString().trim());

                if(rbIt.isChecked()){
                    students_IT.setDepartment_IT(D1);

                }
                String Y1 = rb1yr.getText().toString();
                String Y2= rb2yr.getText().toString();
                String Y3= rb3yr.getText().toString();
                String Y4= rb4yr.getText().toString();
                if(rb1yr.isChecked()){
                    students_IT.setYears_IT(Y1);
                }
                else if(rb2yr.isChecked()){
                    students_IT.setYears_IT(Y2);
                }
                else if(rb3yr.isChecked()){
                    students_IT.setYears_IT(Y3);
                }else
                {
                    students_IT.setYears_IT(Y4);
                }
                String B1 = rb1batch.getText().toString();
                String B2 = rb2batch.getText().toString();
                if(rb1batch.isChecked()){
                    students_IT.setBatches_IT(B1);
                }
                else{
                    students_IT.setBatches_IT(B2);
                }
                reference.push().setValue(students_IT);
           Toast.makeText(getActivity(), "Student Added", Toast.LENGTH_SHORT).show();
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
        return ITView;
    }
}