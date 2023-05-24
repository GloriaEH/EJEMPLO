package com.cdp.agenda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class iniciarsesion extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText loginemail, logincontra;
    private Button buttonlg1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciarsesion);

        auth =FirebaseAuth.getInstance();
        loginemail = findViewById(R.id.correolg);
        logincontra = findViewById(R.id.contralg);
        buttonlg1 = findViewById(R.id.btninicio);

        buttonlg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = loginemail.getText().toString();
                String pass =logincontra.getText().toString();

                if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {if(!pass.isEmpty()){

                    auth.signInWithEmailAndPassword(email,pass)
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    Toast.makeText(iniciarsesion.this, "Login Sucessful", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(iniciarsesion.this,pantallaprincipal.class));
                                    finish();

                                }


                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(iniciarsesion.this, "Login Failed", Toast.LENGTH_SHORT).show();
                                }
                            });



                }else{
                    logincontra.setError("La contraseña no puede estar vacia");
                }

                }else{
                    if(email.isEmpty()){
                        loginemail.setError("El correo no puede estar vacio");
                    }else{
                        loginemail.setError("Porfavor introduzca un correo valido");
                    }
                }

            }
        });




    }
}