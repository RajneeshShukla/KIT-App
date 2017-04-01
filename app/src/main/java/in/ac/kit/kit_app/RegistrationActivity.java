package in.ac.kit.kit_app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener{


    private Button RegistrationBtn;
    private EditText EmailEditTaxt;
    private  EditText PasswordEditTaxt;
    private  TextView LoginText;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        EmailEditTaxt = (EditText)findViewById(R.id.EditTextEmail);
        PasswordEditTaxt = (EditText)findViewById(R.id.EditTextPassword);
        RegistrationBtn = (Button)findViewById(R.id.RegistrationButton);
        LoginText = (TextView)findViewById(R.id.go_on_signin_activity);

        RegistrationBtn.setOnClickListener(this);
        LoginText.setOnClickListener(this);


    }

    //this method id called when user click on Register buttn
    private void RegisterUser(){
        String email = EmailEditTaxt.getText().toString().trim();
        String password = PasswordEditTaxt.getText().toString().trim();

        //make toast if email is emplty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this ,"Please enter mail" ,Toast.LENGTH_LONG).show();
            return;
        }

        //make toast if password is empty
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this ,"Please enter mail" ,Toast.LENGTH_LONG).show();
            return;
        }

        progressDialog.setMessage("Registering user...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email ,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //when authentication task is complted
                        if(task.isSuccessful()){
                            //this show user Register successfully
                            // now maove to tha main activity
                            Toast.makeText(RegistrationActivity.this, "Registration Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegistrationActivity.this ,MainActivity.class));
                        }
                    }
                });

    }//end registrationUser method



    @Override
    public void onClick(View view){
        if(view == RegistrationBtn){
            RegisterUser();
        }

        //if Already Registered tet is clicked
        if(view == LoginText){
            Toast.makeText(this ,"Register Yourself Now" ,Toast.LENGTH_LONG).show();
            finish();
            startActivity(new Intent(RegistrationActivity.this ,LoginActivity.class));
        }
    }


}
