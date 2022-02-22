package com.sketch.facultymodule2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AttendenceAdapter_IT extends RecyclerView.Adapter<AttendenceAdapter_IT.MyViewHolder> {

    Context context;
    ArrayList<Student_IT> list;
    Intent intent;

    public AttendenceAdapter_IT(Context context, ArrayList<Student_IT> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.custom_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Student_IT students = list.get(position);
        holder.sName.setText(students.getStudentName_IT());
        holder.sRollno.setText(students.getRollNo_IT());
        holder.sDepartment.setText(students.getDepartment_IT());
        holder.sBatch.setText(students.getBatches_IT());
        holder.sYear.setText(students.getYears_IT());
        holder.rbPresent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                intent= new Intent(context,AttendenceActivity.class);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView sName,sRollno,sDepartment,sBatch,sYear,sPresent,sAbsent;
        RadioGroup rgAttendence;
        RadioButton rbPresent,rbAbsent;
        HorizontalScrollView scrollView;
        private RadioGroup radioGroupAttendence;
        public Students students;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sName = itemView.findViewById(R.id.sName);
            sRollno = itemView.findViewById(R.id.sRollno);
            sDepartment = itemView.findViewById(R.id.sDepart);
            sBatch = itemView.findViewById(R.id.sBatch);
            sYear = itemView.findViewById(R.id.sYear);
            sPresent = itemView.findViewById(R.id.labelPresent_cs_attendence);
            sAbsent = itemView.findViewById(R.id.labelAbsent_cs_attendence);
            rbAbsent = itemView.findViewById(R.id.rbAbsent);
            rbPresent = itemView.findViewById(R.id.rbPresent);
            radioGroupAttendence = itemView.findViewById(R.id.rgAttendance);

            radioGroupAttendence.setOnCheckedChangeListener(
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

            radioGroupAttendence.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String Present = rbPresent.getText().toString();
                    String Absent = rbAbsent.getText().toString();


                    if(rbPresent.isChecked()){
                        students.setDepartment(Present);


                    }else{
                        students.setDepartment(Absent);
                    }
                    Intent i = new Intent(v.getContext(),AttendenceActivity.class);
                    i.putExtra("attendence",getAdapterPosition());
                    v.getContext().startActivity(i);
                }
            });



        }
    }
}
