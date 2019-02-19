package br.edu.ifpb.atividadenotification;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String LOGTAG = "MainActivity";

    private ListView lista;
    private BroadcastReceiver bReceiver;
    private NoticiasEmMemoria noticiasEmMemoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.main_lvNoticias);
        noticiasEmMemoria = new NoticiasEmMemoria();

        bReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Bundle bundle = intent.getBundleExtra("bundle");
                ArrayList<Noticia> noticias = (ArrayList<Noticia>) bundle.getSerializable("noticias");
                Log.v(LOGTAG, noticias.size() + " noticias recebidas via broadcast");
                atualizarLista(noticias);

            }
        };

        registerReceiver(bReceiver, new IntentFilter("android.intent.action.MAIN"));

        inicarServico();
        setAlarm();
    }

    public void setAlarm() {
        AlarmManager am = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, NoticiaAlarmReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(this, 0, intent, 0);
        long trigger = (1000 * 60 * 5);
        long interval = (1000 * 60 * 5);
        am.setRepeating(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + trigger,
                interval,
                pi
        );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(bReceiver);
    }

    private void inicarServico() {
        Intent i = new Intent(this, NoticiasPuller.class);
        startService(i);
    }

    private void atualizarLista(ArrayList<Noticia> noticias) {
        ArrayList<Noticia> novas = noticiasEmMemoria.addAngGetNovasNoticias(noticias);
        Log.v(LOGTAG, "atualizando listview "+noticiasEmMemoria.getNoticias().size());
        ArrayAdapter adpter = new NoticiaAdapter(this, noticiasEmMemoria.getNoticias());
        lista.setAdapter(adpter);
        Log.v(LOGTAG, "noticias novas: " + novas.size());
        /*int id = R.drawable.ic_launcher_background;
        for(Noticia noticia : novas){
            notificarNoticia(noticia, id++);
        }*/
        if(!novas.isEmpty()) {
            notificarNoticia(novas.size() + " Novas noticias", R.drawable.ic_launcher_background);
        }

    }

    public void notificarNoticia(String text, int id){

        Log.v(LOGTAG, "Notificando novas noticias");

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setTicker("Diário do Sertão")
                .setContentTitle("Diário do Sertão")
                .setContentText(text)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background))
                .setAutoCancel(true);

        Notification n = builder.build();
        nm.notify(id, n);
    }


}
