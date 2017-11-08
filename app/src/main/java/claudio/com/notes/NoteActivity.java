package claudio.com.notes;


import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by IFSP- on 07/11/2017.
 */

public class NoteActivity extends AppCompatActivity {

    static final ArrayList<Note> noteList=new ArrayList<>();

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);


        final EditText edtTitulo = findViewById(R.id.edt_texto);
        final EditText edtDescricao = findViewById(R.id.edt_descricao);

        Button buttonSalvar = findViewById(R.id.btnSalvar);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Note note = new Note();


                String title = edtTitulo.getText().toString();
                String description = edtDescricao.getText().toString();

                note.setTitle(title);
                note.setDescription(description);

                // Mostra o titulo da nota via Toast e finaliza a activicty
                Toast.makeText(NoteActivity.this, note.getTitle() +" salvo!", Toast.LENGTH_SHORT).show();
                noteList.add(note);
                finish();
            }
        });




    }
}
