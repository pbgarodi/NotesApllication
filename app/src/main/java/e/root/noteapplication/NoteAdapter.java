package e.root.noteapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by root on 27/11/17.
 */

public class NoteAdapter extends BaseAdapter{

    Context context;
    ArrayList<Note>  notes = new ArrayList<>();

    public NoteAdapter(Context context,ArrayList<Note> list) {
        this.context = context;
        notes =list ;
    }

    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        LayoutInflater  inflater =  LayoutInflater.from(context);
       View rootView= inflater.inflate(R.layout.lite_view_item,viewGroup,false);


        TextView textViewTitle = rootView.findViewById(R.id.textViewTitle);
        TextView  textViewdescription = rootView.findViewById(R.id.textViewDescription);

        textViewTitle.setText(" Title : "+notes.get(position).getTitle());
        textViewdescription.setText("Description : "+notes.get(position).getDiscription());

        return rootView;
    }

    public void addNote(Note note){

        notes.add(note);

    }
}



