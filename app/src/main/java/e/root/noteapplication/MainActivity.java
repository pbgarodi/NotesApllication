package e.root.noteapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.SharedPreferences.Editor;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTextUsername,editTextPassword;
    Button buttonLogin, buttonRegistration;

    int count =0;
    SharedPreferences sharedPreferences;
    Editor editor ;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);

        buttonLogin = findViewById(R.id.buttonLogin);
        buttonRegistration = findViewById(R.id .buttonRegistration);

        sharedPreferences = getSharedPreferences("sharePreference",MODE_PRIVATE);



        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            String name =  sharedPreferences.getString("username",null);
            String pass = sharedPreferences.getString("password",null);



            String username = editTextUsername.getText().toString();
            String password = editTextPassword.getText().toString();



            if(username == null || password == null){

                Toast.makeText(MainActivity.this, "Please enter username and password", Toast.LENGTH_SHORT).show();

            }
            if(username.equals(name) && password.equals(pass)){


                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);

            }else {


                Toast.makeText(MainActivity.this, "Invalid Username or password", Toast.LENGTH_SHORT).show();
            }



            }
        });



        buttonRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,RegistrationActivity.class);
                startActivityForResult(intent,1);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        editor = sharedPreferences.edit();



        if (requestCode==1){

            String username = data.getStringExtra("name");
            String password = data.getStringExtra("password");
            String rollNo = data.getStringExtra("rollNo");
            String email = data.getStringExtra("email");

            editor.putString("username",username);
            editor.putString("password",password);
            editor.putString("rollNo",rollNo);
            editor.putString("email",email);
            editor.commit();

            }


    }




}
