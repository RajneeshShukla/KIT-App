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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button LoginBtn;
    private EditText EmailEditTaxt;
    private  EditText PasswordEditTaxt;
    private TextView LoginText;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() != null){
            //open main activity
            startActivity(new Intent(LoginActivity.this , MainActivity.class));
        }

        progressDialog = new ProgressDialog(this);

        EmailEditTaxt = (EditText)findViewById(R.id.EditTextEmailLogin);
        PasswordEditTaxt = (EditText)findViewById(R.id.EditTextPasswordLogin);
        LoginBtn = (Button)findViewById(R.id.LoginButton);
        LoginText = (TextView)findViewById(R.id.login_textview);

        LoginBtn.setOnClickListener(this);
        LoginText.setOnClickListener(this);

    }

    private void UserLogin(){
        String email = EmailEditTaxt.getText().toString().trim();
        String password = PasswordEditTaxt.toString().trim();

        //ckecking if email and password are empty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        //if the email and password are not empty
        //display the progress bar
        progressDialog.setMessage("Please wait...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email ,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        finish();
                        //start the mainActivity
                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                        Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    @Override
    public void onClick(View view){
        if(view == LoginBtn){
            UserLogin();
        }

        if(view == LoginText){
            finish();
            startActivity(new Intent(LoginActivity.this ,RegistrationActivity.class));
            Toast.makeText(this, "Register Yourself First", Toast.LENGTH_SHORT).show();
        }
    }


}
