package com.example.sulavtimsina.driveastate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.sulavtimsina.driveastate.model.DriveRequest;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.R.attr.key;

public class NeedDrive extends AppCompatActivity implements View.OnClickListener {

    EditText etfrom,etTo;
    DatePicker datePicker;
    TimePicker timePicker;
    Button btnNeedDrive;

    FirebaseDatabase database;
    DatabaseReference databaseRef;
    DriveRequest driveRequest;
    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_need_drive);
        bindViews();
        setUpDatabase();
        btnNeedDrive.setOnClickListener(this);
    }

    private void setUpDatabase() {
        database = FirebaseDatabase.getInstance();
        databaseRef = database.getReference().child("DriveRequests");
    }

    private void bindViews() {
        etfrom = (EditText) findViewById(R.id.etFrom);
        etTo = (EditText) findViewById(R.id.etTo);
        datePicker = (DatePicker) findViewById(R.id.datePicker1);
        timePicker = (TimePicker)findViewById(R.id.timePicker1);
        btnNeedDrive = (Button) findViewById(R.id.btnNeedDrive);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnNeedDrive){
            driveRequest = new DriveRequest();
            key = databaseRef.push().getKey();
            driveRequest.setKey(key);

            driveRequest.setUid(FirebaseAuth.getInstance().getCurrentUser().getUid());
            driveRequest.setDay(datePicker.getDayOfMonth());
            driveRequest.setFrom(etfrom.getText().toString());
            driveRequest.setHr(timePicker.getHour());
            driveRequest.setMin(timePicker.getMinute());
            driveRequest.setMonth(datePicker.getMonth());
            driveRequest.setTo(etTo.getText().toString());
            driveRequest.setYear(datePicker.getYear());

            databaseRef.child(key).setValue(driveRequest);
            Toast.makeText(getApplicationContext(), "Drive Request Made!!!", Toast.LENGTH_LONG).show();

        }
    }
}
