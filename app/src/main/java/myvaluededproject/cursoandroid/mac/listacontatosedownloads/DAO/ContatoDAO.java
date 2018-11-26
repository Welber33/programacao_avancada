package myvaluededproject.cursoandroid.mac.listacontatosedownloads.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import myvaluededproject.cursoandroid.mac.listacontatosedownloads.Model.Contato;

import java.util.ArrayList;
import java.util.List;

public class ContatoDAO extends BaseDAO {


    public ContatoDAO(Context context) {
        super(context);
    }

    public void salva(Contato contato) {
        ContentValues values = new ContentValues();

        values.put("nome", contato.getNome());
        values.put("email", contato.getEmail());
        values.put("urlImagem", contato.getUrlImagem());
        values.put("midiaLocal", contato.getMidiaLocal());

        getWritableDatabase().insert("Contato", null, values);
    }

    public void deletar(Contato contato) {
        String[] args = {String.valueOf(contato.getId())};
        getWritableDatabase().delete("Contato", "id=?", args);
    }

    public List<Contato> getLista() {
        String[] colunas = {"id", "nome", "email", "urlImagem", "midiaLocal"};

        Cursor cursor = getWritableDatabase().query("Contato", colunas, null, null, null, null, null);

        List<Contato> constatos = new ArrayList<>();

        while (cursor.moveToNext()) {
            Contato contato = new Contato();
            contato.setId(cursor.getInt(0));
            contato.setNome(cursor.getString(1));
            contato.setEmail(cursor.getString(2));
            contato.setUrlImagem(cursor.getString(3));
            contato.setMidiaLocal(cursor.getString(4));

            constatos.add(contato);
        }

        return constatos;
    }

    public void alterar(Contato contato) {
        ContentValues values = new ContentValues();

        values.put("nome", contato.getNome());
        values.put("email", contato.getEmail());
        values.put("urlImagem", contato.getUrlImagem());
        values.put("midiaLocal", contato.getMidiaLocal());

        String[] args = {String.valueOf(contato.getId())};
        getWritableDatabase().update("Contato", values, "id=?", args);

    }
}
