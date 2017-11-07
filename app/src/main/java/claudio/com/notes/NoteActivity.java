package claudio.com.notes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by IFSP- on 07/11/2017.
 */

public class NoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        final EditText edtTexto = findViewById(R.id.edt_texto);

        EditText edtDescricao = findViewById(R.id.edt_descricao);

        Button buttonSalvar = findViewById(R.id.btnSalvar);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NoteActivity.this, edtTexto.getText() +" salvo!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }
}
