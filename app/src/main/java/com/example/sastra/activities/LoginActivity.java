package com.example.sastra.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sastra.R;
import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {
    private static EditText username;
    private static EditText password;
    private static TextView attempts;
    private static Button login_btn;
    int attempt_counter = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginButton();
    }
    public  void LoginButton() {
        username = (EditText)findViewById(R.id.usrnameeditText);
        password = (EditText)findViewById(R.id.userpassedittext);
        attempts = (TextView)findViewById(R.id.no_of_attempts);
        login_btn = (Button)findViewById(R.id.visitorsave);

        attempts.setText(Integer.toString(attempt_counter));

        login_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(username.getText().toString().equals("admin") &&
                                password.getText().toString().equals("admin")  ) {
                            Snackbar.make( v,"Successfully LoggedIn", Snackbar.LENGTH_SHORT)
                                    .setAction("Action", null).show();
                            startActivity(new Intent(LoginActivity.this, ChangePasswordActivity.class));
                        } else {
                            attempts.setVisibility(View.VISIBLE);
                            attempt_counter--;
                            attempts.setText(Integer.toString(attempt_counter));
                            if(attempt_counter == 0){
                                Toast.makeText(LoginActivity.this,"YOu Are Blocked Permnently",
                                        Toast.LENGTH_SHORT).show();

                                login_btn.setEnabled(false);

                            }
                        }

                    }
                }
        );
    }
}
