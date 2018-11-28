package myvaluededproject.cursoandroid.mac.listacontatosedownloads.View;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import myvaluededproject.cursoandroid.mac.listacontatosedownloads.DAO.SongDAO;
import myvaluededproject.cursoandroid.mac.listacontatosedownloads.Model.Song;
import myvaluededproject.cursoandroid.mac.listacontatosedownloads.R;
import myvaluededproject.cursoandroid.mac.listacontatosedownloads.View.Adapter.AdapterSong;

import java.io.IOException;
import java.util.List;

public class ListMusicActivity extends AppCompatActivity {
    private List<Song> songs;
    private int positionCurrent = 0;
    private ListView listaSongs;
    private MediaPlayer mediaPlayer;
    private Song music;
    private TextView namePlay;
    private ImageButton play;
    private ImageButton prev;
    private ImageButton next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_music);

        listaSongs = findViewById(R.id.lista_Musica);
        namePlay = findViewById(R.id.namePlay);
        play = findViewById(R.id.buttonPlay);
        prev = findViewById(R.id.buttonPrev);
        next = findViewById(R.id.buttonNext);


        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        listaSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (positionCurrent != i) {
                    positionCurrent = i;


                }
                if (positionCurrent == i && !mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                    play.setImageResource(android.R.drawable.ic_media_pause);
                }
                if (positionCurrent == i && mediaPlayer.isPlaying()) {

                } else {
                    setMusic(i);
                }

            }
        });


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    play.setImageResource(android.R.drawable.ic_media_play);

                } else {
                    mediaPlayer.start();
                    if (mediaPlayer.isPlaying()) {
                        play.setImageResource(android.R.drawable.ic_media_pause);
                    }
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (positionCurrent == songs.size() - 1) {
                    positionCurrent = 0;
                } else {
                    positionCurrent++;
                    setMusic(positionCurrent);
                }
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (positionCurrent == 0) {
                    mediaPlayer.stop();
                    try {
                        mediaPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mediaPlayer.start();
                } else {
                    positionCurrent--;
                    setMusic(positionCurrent);
                }
            }
        });


    }

    private void setMusic(int position) {
        music = songs.get(position);
        namePlay.setText(music.getNome());

        Uri myUri = Uri.parse(music.getMediaLocal());

        try {
            mediaPlayer.setDataSource(getApplicationContext(), myUri);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.start();
        play.setImageResource(android.R.drawable.ic_media_pause);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SongDAO songDAO = new SongDAO(this);
        songs = songDAO.getLista();
        songDAO.close();

        AdapterSong adapterContato = new AdapterSong(this, songs);

        listaSongs.setAdapter(adapterContato);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_superior, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.id_add:
                Intent intent = new Intent(this, AddMusicActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}