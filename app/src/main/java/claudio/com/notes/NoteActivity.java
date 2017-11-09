package claudio.com.notes;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.thebluealliance.spectrum.SpectrumDialog;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by IFSP- on 07/11/2017.
 */

public class NoteActivity extends AppCompatActivity {

    static final ArrayList<Note> noteList=new ArrayList<>();
    Note note;
    int color = Color.parseColor("#004D40");

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);


        final EditText edtTitulo = findViewById(R.id.edt_texto);
        final EditText edtDescricao = findViewById(R.id.edt_descricao);

        final View viewSelectColor = findViewById(R.id.viewColor);


        // Definindo uma nova cor para a Nota
        viewSelectColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SpectrumDialog.Builder(NoteActivity.this)
                        .setColors(R.array.card_colors)
                        .setSelectedColorRes(R.color.colorExtra)
                        .setDismissOnColorSelected(true)
                        .setOnColorSelectedListener(new SpectrumDialog.OnColorSelectedListener() {
                            @Override public void onColorSelected(boolean positiveResult, @ColorInt int color) {
                                if (positiveResult) {
                                    viewSelectColor.setBackgroundColor(color);
                                    NoteActivity.this.color= color;
                                    Toast.makeText(NoteActivity.this, "Color selected: #" + Integer.toHexString(color).toUpperCase(), Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(NoteActivity.this, "Dialog cancelled", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).build().show(getSupportFragmentManager(), "dialog_demo_1");
            }
        });

        Button buttonSalvar = findViewById(R.id.btnSalvar);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            Note note = (Note) extras.get("noteExtra");
            edtTitulo.setText(note.getTitle());
            edtDescricao.setText(note.getDescription());

        }


        // Salvando uma nota
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = edtTitulo.getText().toString();
                String description = edtDescricao.getText().toString();
                if(note==null) {
                    note = new Note();
                }

                note.setTitle(title);
                note.setDescription(description);
                note.setColor(color);
                noteList.add(note);

                // Mostra o titulo da nota via Toast e finaliza a activicty
                Toast.makeText(NoteActivity.this, note.getTitle() + " salvo!", Toast.LENGTH_SHORT).show();

                finish();
            }
        });




    }
}
