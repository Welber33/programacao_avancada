package myvaluededproject.cursoandroid.mac.listacontatosedownloads.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import myvaluededproject.cursoandroid.mac.listacontatosedownloads.DAO.SongDAO;
import myvaluededproject.cursoandroid.mac.listacontatosedownloads.Model.Song;
import myvaluededproject.cursoandroid.mac.listacontatosedownloads.R;

public class AddMusicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_music);
        final AddMusicHelper helper = new AddMusicHelper(this);

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


    }
}
