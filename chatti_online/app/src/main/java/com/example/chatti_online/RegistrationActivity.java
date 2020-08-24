package com.example.chatti_online;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static com.example.chatti_online.LoginActivity.MyPREFERENCES;


public class RegistrationActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    Button reg;
    EditText email, password,F_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mAuth = FirebaseAuth.getInstance();
        F_name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.pass);
        reg = findViewById(R.id.button);


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });


    }
    private void register()
    {
        final String U_email, U_pass,f_name;
        f_name = F_name.getText().toString();
        U_email = email.getText().toString();
        U_pass = password.getText().toString();
        mAuth.createUserWithEmailAndPassword(U_email,U_pass)
                .addOnCompleteListener(RegistrationActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                      //  SharedPreferences sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

                        if (!task.isSuccessful()) {
                            Toast.makeText(RegistrationActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                        }
                        else
                            {

                        /*       SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("full_name",f_name);
                                editor.putString("user_email",U_email);
                                editor.commit();
*/
                                RegistrationActivity.this.startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
                                RegistrationActivity.this.finish();
                        }
                    }
                });
    }
}