package myvaluededproject.cursoandroid.mac.listacontatosedownloads.View;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import myvaluededproject.cursoandroid.mac.listacontatosedownloads.DAO.SongDAO;
import myvaluededproject.cursoandroid.mac.listacontatosedownloads.Model.Song;
import myvaluededproject.cursoandroid.mac.listacontatosedownloads.R;

public class AddMusicActivity extends AppCompatActivity {
    private AddMusicHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_music);
        helper = new AddMusicHelper(this);

        Button saveSong = findViewById(R.id.saveSong);

        saveSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Song song = helper.salvarSong();

                SongDAO songDAO = new SongDAO(AddMusicActivity.this);
                songDAO.salva(song);
                songDAO.close();

                finish();
            }
        });

        ImageView imageSong = helper.getImageSong();

        imageSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("teste", MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString());
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 2:
                    helper.carregaFoto(data.getDataString());
                    break;
            }
        }
    }
}
