package e.root.noteapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity {


    EditText editTextName ,editTextRegistrationPassword ,editTextRollNo, editTextEmail;
    Button buttonRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        editTextName = findViewById(R.id.editTextName);
        editTextRegistrationPassword =  findViewById(R.id.editTextRegistrationPassword);
        editTextRollNo =  findViewById(R.id.editTextRolllNo);
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonRegister =findViewById(R.id.buttonRegister);


        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = editTextName.getText().toString();
                String password = editTextRegistrationPassword.getText().toString();
                String rollNo = editTextRollNo.getText().toString();
                String email = editTextEmail.getText().toString();

                Intent intent = new Intent(RegistrationActivity.this,MainActivity.class);
                intent.putExtra("name",uname);
                intent.putExtra("password",password);
                intent.putExtra("rollNo",rollNo);
                intent.putExtra("email",email);
                setResult(1,intent);

                finish();




            }
        });



    }
}
