package br.edu.ifpb.atividadenotification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    private BroadcastReceiver bReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.main_lvNoticias);
        /*
        bReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.v("MainActivity", "asdasdasdsa");
            }
        }; */
        bReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.v("MAIN ACTIVITY", "noticias recebidas");
                Bundle bundle = intent.getBundleExtra("bundle");
                ArrayList<Noticia> noticias = (ArrayList<Noticia>) bundle.getSerializable("noticias");
                atualizarLista(noticias);
            }
        };

        registerReceiver(bReceiver, new IntentFilter("android.intent.action.MAIN"));

        inicarServico();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(bReceiver);
    }

    private void inicarServico(){
        Intent i = new Intent(MainActivity.this, NoticiasPuller.class);
        startService(i);
    }

    private void atualizarLista(ArrayList<Noticia> noticias){
        ArrayAdapter adpter = new NoticiaAdapter(this, noticias);
        lista.setAdapter(adpter);
    }


}
