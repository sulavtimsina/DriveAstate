package com.example.sulavtimsina.driveastate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sulavtimsina.driveastate.model.DriverRegRequest;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DriverRegistration extends AppCompatActivity {

    Button btnRegDriver;
    EditText etVin, etPhone;
    DatabaseReference myRef;
    FirebaseDatabase database;
    DriverRegRequest driverRegRequest;
    String uid;
    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_registration);
        bindViews();
        setUpDatabase();
    }

    private void setUpDatabase() {
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child("driverReg");
    }

    private void bindViews() {
        btnRegDriver = (Button) findViewById(R.id.btnRegisterDriver);
        etVin = (EditText) findViewById(R.id.etVin);
        etPhone = (EditText) findViewById(R.id.etPhone);

        btnRegDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                driverRegRequest = new DriverRegRequest();
                key = myRef.push().getKey();
                driverRegRequest.setKey(key);

                driverRegRequest.setUid(FirebaseAuth.getInstance().getCurrentUser().getUid());
                driverRegRequest.setVin(etVin.getText().toString());
                driverRegRequest.setPhone(etPhone.getText().toString());

                myRef.child(key).setValue(driverRegRequest);
                Toast.makeText(getApplicationContext(), "You will be registered once your VIN and phone is verified", Toast.LENGTH_LONG).show();
            }
        });
    }
}
