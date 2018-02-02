package com.example.shivam.firebaseintegrationtutorial;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    EditText name,roll_no;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        name = (EditText)findViewById(R.id.name_text);
        roll_no = (EditText)findViewById(R.id.roll_no_text);
        submit = (Button)findViewById(R.id.submit_btn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_val = name.getText().toString();
                String rollno_val = roll_no.getText().toString();
                if (name_val.trim().length()!=0 && rollno_val.trim().length()!=0){
                   MyUser user = new MyUser(name_val,rollno_val);
                   databaseReference.child(rollno_val).setValue(user);
                    //Intent intent = new Intent(MainActivity.this,UserListActivity.class);
                    //startActivity(intent);
                    //finish();
                }
                else {
                    Toast.makeText(MainActivity.this,"Values Can't Be Empty",Toast.LENGTH_LONG).show();
                    Snackbar.make(view,"Values Can't Be Empty",Snackbar.LENGTH_LONG).
                            setAction("Action", null).show();
                }
            }
        });
    }



}
