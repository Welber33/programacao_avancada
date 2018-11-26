package myvaluededproject.cursoandroid.mac.listacontatosedownloads.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDAO extends SQLiteOpenHelper {
    private static final String DATABASE = "BaseLocal";
    private static final int version = 1;

    public BaseDAO(Context context) {
        super(context, DATABASE, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createContato = "CREATE TABLE Contato (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT UNIQUE NOT NULL, " +
                "email TEXT NOT NULL, " +
                "urlImagem TEXT," +
                "midiaLocal TEXT);";

        db.execSQL(createContato);

        String createSong = "CREATE TABLE Song (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT UNIQUE NOT NULL, " +
                "foto TEXT, " +
                "mediaLocal TEXT," +
                "urlSong TEXT);";

        db.execSQL(createSong);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String deleteContato = "DROP TABLE IF EXISTS Contato";
        db.execSQL(deleteContato);
        String deleteSong = "DROP TABLE IF EXISTS Song";
        db.execSQL(deleteSong);

        this.onCreate(db);
    }
}
