package e.root.noteapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NoteActivity extends AppCompatActivity {

    EditText editTextTitle;
    EditText editTextDescription;
    Button  buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDescription = findViewById(R.id.editTextDescription);
        buttonSubmit = findViewById(R.id.buttonSave);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title = editTextTitle.getText().toString();
                String description = editTextDescription.getText().toString();

                Intent intent = new Intent(NoteActivity.this,HomeActivity.class);
                intent.putExtra("title",title);
                intent.putExtra("description",description);
                setResult(1,intent);
                finish();





            }
        });







    }
}
