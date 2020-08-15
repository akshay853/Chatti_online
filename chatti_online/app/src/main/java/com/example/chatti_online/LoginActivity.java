package com.example.chatti_online;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {
    EditText  email, pass;
    Button Login,Register;
    FirebaseAuth firebaseAuth;
    private FirebaseAuth auth;
    private  FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        Login = findViewById(R.id.button);
        Register = findViewById(R.id.button2);
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user =  firebaseAuth.getCurrentUser();
                if(user != null)
                {
                    Toast.makeText(LoginActivity.this, "user logged in", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(in);
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "login to continue", Toast.LENGTH_SHORT).show();
                }
            }
        };

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ine = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(ine);
            }
        });


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email1,pasword;
                email1= email.getText().toString();
                pasword= pass.getText().toString();
                if(email1.isEmpty())
                {
                    email.setError("Provide your Email first!");
                    email.requestFocus();
                }
                else if (pasword.isEmpty())
                {
                    pass.setError("Provide password");
                    pass.requestFocus();

                }
                else if (email1.isEmpty() && pasword.isEmpty())
                {
                    Toast.makeText(LoginActivity.this, "Please provide email and password", Toast.LENGTH_SHORT).show();
                }
                else if (!(email1.isEmpty() && pasword.isEmpty()))
                {
                    firebaseAuth.signInWithEmailAndPassword(email1,pasword).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful())
                            {
                                Toast.makeText(LoginActivity.this, "login failed or error", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                startActivity(intent);
                            }

                        }
                    });
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "An Error Occurred", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}