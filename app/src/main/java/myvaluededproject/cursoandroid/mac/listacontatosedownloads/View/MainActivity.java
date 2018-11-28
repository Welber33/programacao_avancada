package myvaluededproject.cursoandroid.mac.listacontatosedownloads.View;
//made by John Welber

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import myvaluededproject.cursoandroid.mac.listacontatosedownloads.R;

public class MainActivity extends AppCompatActivity {
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] options = {"Contatos", "Musicas", "Videos"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, options);
        ListView menu = findViewById(R.id.menu);

        menu.setAdapter(adapter);

        menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                switch (i) {
                    case 0:
                        intent = new Intent(MainActivity.this, ListContactsActivity.class);

                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, ListMusicActivity.class);

                        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                        } else {
                            startActivityResult(intent);
                        }
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, ListVideoActivity.class);

                        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                        } else {
                            startActivityResult(intent);
                        }
                        break;
                }
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startActivityResult(intent);
                }
        }
    }

    private void startActivityResult(Intent intent) {
        startActivity(intent);
    }
}
