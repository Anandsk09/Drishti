package com.example.newpc.drishti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newpc.drishti.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import drishtiCore.Employee;

public class ResultActivity extends AppCompatActivity {
    TextView textView1,tv;
    Button saveInfo;

    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tv= (TextView) findViewById(R.id.textResult);
        tv.setText(getIntent().getExtras().getString("dataInfo"));
        saveInfo = (Button) findViewById(R.id.save);
        databaseReference= FirebaseDatabase.getInstance().getReference("Information");

        saveInfo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                addInformation();
            }
        });


    }
        private void addInformation()
        {
            String information= tv.getText().toString();
            String infoId=databaseReference.push().getKey();
            String[] ar=information.split(",");
            Employee emp=new Employee(infoId,ar[0],ar[1],ar[2],ar[3]);
            databaseReference.child(infoId).setValue(emp);
            Toast.makeText(this,"Information saved",Toast.LENGTH_LONG).show();
        }
}
