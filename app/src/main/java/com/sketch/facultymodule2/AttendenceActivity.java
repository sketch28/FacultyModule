package com.sketch.facultymodule2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AttendenceActivity extends AppCompatActivity {

//   private RecyclerView recyclerView;
//   private Button btnAllPresent, btnAllAbsent,btnSave;
//    DatabaseReference database,database2;
//    FirebaseDatabase firebaseDatabase;
//    ArrayList<Students> list ;
//    public Students students;
//    AttendenceAdapter attendenceAdapter;
//    RadioButton radioButton1;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence);
        tabLayout = findViewById(R.id.tabLayout_attendence);
        viewPager = findViewById(R.id.viewPager2_attendence);

        tabLayout.setupWithViewPager(viewPager);

        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        vpAdapter.addFragment(new CsAttendenceFragment(),"Computer Science");
        vpAdapter.addFragment(new ITFragment(),"Info.Tech");
        viewPager.setAdapter(vpAdapter);

    }
}