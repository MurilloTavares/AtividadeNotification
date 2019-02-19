package br.edu.ifpb.atividadenotification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class NoticiaAlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v("NoticiaAlarmReceiver", "Iniciando novo servico de busca");
        Intent i = new Intent(context, NoticiasPuller.class);
        context.startService(i);
    }
}
