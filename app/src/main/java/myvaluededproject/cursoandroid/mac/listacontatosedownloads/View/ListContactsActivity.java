package myvaluededproject.cursoandroid.mac.listacontatosedownloads.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import myvaluededproject.cursoandroid.mac.listacontatosedownloads.DAO.ContatoDAO;
import myvaluededproject.cursoandroid.mac.listacontatosedownloads.Model.Contato;
import myvaluededproject.cursoandroid.mac.listacontatosedownloads.R;
import myvaluededproject.cursoandroid.mac.listacontatosedownloads.View.Adapter.AdapterContato;

import java.util.List;

public class ListContactsActivity extends AppCompatActivity {

    private ListView listaContatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contacts);

        listaContatos = findViewById(R.id.lista_contatos);

        registerForContextMenu(listaContatos);

        listaContatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        ContatoDAO contatoDAO = new ContatoDAO(this);
        List<Contato> constatos = contatoDAO.getLista();
        contatoDAO.close();

        AdapterContato adapterContato = new AdapterContato(this, constatos);

        listaContatos.setAdapter(adapterContato);
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
                Intent intent = new Intent(this, AddContactsActivity.class);
                intent.putExtra("position", listaContatos.getCount());
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
