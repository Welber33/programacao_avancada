package myvaluededproject.cursoandroid.mac.listacontatosedownloads.View;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import myvaluededproject.cursoandroid.mac.listacontatosedownloads.DAO.ContatoDAO;
import myvaluededproject.cursoandroid.mac.listacontatosedownloads.Model.Contato;
import myvaluededproject.cursoandroid.mac.listacontatosedownloads.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddContactsActivity extends AppCompatActivity {
    private AddContactsHelper helper;
    private String caminhoFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contacts);
        helper = new AddContactsHelper(this);

        final Button salvarContato = findViewById(R.id.salvarContato);

        salvarContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contato contato = helper.salvarContato();

                ContatoDAO contatoDAO = new ContatoDAO(AddContactsActivity.this);

                contatoDAO.salva(contato);

                finish();
            }
        });

        ImageView foto = helper.getFoto();

        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ActivityCompat.checkSelfPermission(AddContactsActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(AddContactsActivity.this, new String[]{Manifest.permission.CAMERA}, 0);
                } else {

                    tirafoto();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 404 && resultCode == RESULT_OK) {
            helper.carregaFoto(caminhoFoto);
        } else {
            caminhoFoto = null;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 0:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    tirafoto();
                }
                return;
        }
    }

    private void tirafoto() {
        int id = getIntent().getExtras().getInt("position");

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        File arquivo = null;
        try {
            arquivo = createImageFile(id);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Uri localImage = FileProvider.getUriForFile(AddContactsActivity.this, getPackageName(), arquivo);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, localImage);

        startActivityForResult(intent, 404);
    }

    private File createImageFile(int id) throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File storageDir = Environment.getExternalStoragePublicDirectory("/FBV/" + Environment.DIRECTORY_PICTURES + "/" + String.valueOf(id) + "_" + timeStamp + ".jpg");

        File image = storageDir.getAbsoluteFile();

        // Save a file: path for use with ACTION_VIEW intents
        caminhoFoto = image.getAbsolutePath();
        return image;
    }
}
