package e.root.noteapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

ListView listView ;
    NoteAdapter adapter;
    ArrayList<Note> list ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        listView = findViewById(R.id.listView);


        list = getAllNotes();
         adapter = new NoteAdapter(HomeActivity.this,list);


        listView.setAdapter(adapter);

        adapter.notifyDataSetChanged();

       // registerForContextMenu(listView);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

      int id =  item.getItemId();

      if(id == R.id.actionAddNote){

          Intent intent = new Intent(HomeActivity.this,NoteActivity.class);
          startActivityForResult(intent,1);


      }


        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

            if(requestCode==1){

                String title = data.getStringExtra("title");
                String description = data.getStringExtra("description");


                NoteDB noteDB = new NoteDB(HomeActivity.this);

               SQLiteDatabase database = noteDB.getWritableDatabase();
                ContentValues values =new ContentValues();
                values.put("title",title);
                values.put("description",description);
               Long inserdId = database.insert(NoteDB.TABLE_NAME,null,values);

               System.out.println(inserdId);

               Note note = new Note();
               note.setTitle(title);
               note.setDiscription(description);

               adapter.addNote(note);
               adapter.notifyDataSetChanged();



            }




    }


    public ArrayList<Note> getAllNotes(){

        ArrayList<Note>  noteArrayList = new ArrayList<>();
        NoteDB noteDB = new NoteDB(HomeActivity.this);
        SQLiteDatabase database = noteDB.getReadableDatabase();
        Cursor cursor = database.query(NoteDB.TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToFirst();



        while(!cursor.isAfterLast()){
            Note note = new Note();

            note.setTitle(cursor.getString(cursor.getColumnIndex("title")));
            note.setDiscription(cursor.getString(cursor.getColumnIndex("description")));

            System.out.println(cursor.getString(cursor.getColumnIndex("title")));
            System.out.println(cursor.getString(cursor.getColumnIndex("description")));
            noteArrayList.add(note);
            cursor.moveToNext();

        }

        return noteArrayList;
    }

}
