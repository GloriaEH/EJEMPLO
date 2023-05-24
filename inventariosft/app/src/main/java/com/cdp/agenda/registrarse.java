package com.cdp.agenda;

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

public class registrarse extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText gmail,contra;
    private Button buttonrg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);


        auth = FirebaseAuth.getInstance();
        gmail = findViewById(R.id.correo1);
        contra = findViewById(R.id.contra1);
        buttonrg = findViewById(R.id.rg1);

        buttonrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = gmail.getText().toString().trim();
                String pass = contra.getText().toString().trim();

                if (user.isEmpty()){

                    gmail.setError("El correo electronico no puede estar vacio");
                }
                if (pass.isEmpty()){
                    contra.setError("La contraseña no puede estar vacia");
                }else
                    auth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(registrarse.this,"Signup Succerful",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(registrarse.this,iniciarsesion.class));
                            }else{

                                Toast.makeText(registrarse.this,"signup Failed"+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
            }
        });




    }

}