package myvaluededproject.cursoandroid.mac.listacontatosedownloads.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import myvaluededproject.cursoandroid.mac.listacontatosedownloads.Model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongDAO extends BaseDAO {


    public SongDAO(Context context) {
        super(context);
    }

    public void salva(Song song) {
        ContentValues values = new ContentValues();

        values.put("nome", song.getNome());
        values.put("foto", song.getFoto());
        values.put("mediaLocal", song.getMediaLocal());
        values.put("urlSong", song.getUrlSong());


        getWritableDatabase().insert("Song", null, values);
    }

    public void deletar(Song song) {
        String[] args = {String.valueOf(song.getId())};
        getWritableDatabase().delete("Song", "id=?", args);
    }

    public List<Song> getLista() {
        String[] colunas = {"id", "nome", "foto", "mediaLocal", "urlSong"};

        Cursor cursor = getWritableDatabase().query("Song", colunas, null, null, null, null, null);

        List<Song> songs = new ArrayList<>();

        while (cursor.moveToNext()) {
            Song song = new Song();
            song.setId(cursor.getInt(0));
            song.setNome(cursor.getString(1));
            song.setFoto(cursor.getString(2));
            song.setMediaLocal(cursor.getString(3));
            song.setUrlSong(cursor.getString(4));

            songs.add(song);
        }

        return songs;
    }

    public void alterar(Song song) {
        ContentValues values = new ContentValues();

        values.put("nome", song.getNome());
        values.put("foto", song.getFoto());
        values.put("mediaLocal", song.getMediaLocal());
        values.put("urlSong", song.getUrlSong());

        String[] args = {String.valueOf(song.getId())};
        getWritableDatabase().update("Song", values, "id=?", args);

    }
}
