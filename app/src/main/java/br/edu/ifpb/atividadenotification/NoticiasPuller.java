package br.edu.ifpb.atividadenotification;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class NoticiasPuller extends IntentService {

    private String LOGTAG = "NoticiasPuller";

    public NoticiasPuller() {
        super("NoticiasPuller");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        ArrayList<Noticia> noticias = getNoticias();
        send(noticias);
    }

    private void send (ArrayList<Noticia> noticias){
        Intent intent = new Intent ("android.intent.action.MAIN");
        Bundle bundle = new Bundle();
        bundle.putSerializable("noticias", (Serializable) noticias);
        intent.putExtra("bundle", bundle);
        this.sendBroadcast(intent);
        Log.v(LOGTAG, "mandando noticias broadcast");
    }

    private ArrayList<Noticia> getNoticias(){

        ArrayList<Noticia> noticias = new ArrayList<>();

        try{
            URL url = new URL("https://www.diariodosertao.com.br/feed/atom");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new InputSource(url.openStream()));
            doc.getDocumentElement().normalize();

            NodeList nodelist = doc.getElementsByTagName("entry");

            int numDeElementos = nodelist.getLength();

            for(int i = 0; i < numDeElementos; i++){
                Element item = (Element) nodelist.item(i);

                Node tituloTag = item.getElementsByTagName("title").item(0);
                String titulo = tituloTag.getTextContent();

                Node sumarioTag = item.getElementsByTagName("summary").item(0);
                String sumario = sumarioTag.getTextContent();

                Node conteudoTag = item.getElementsByTagName("content").item(0);
                String conteudo = conteudoTag.getTextContent();

                Noticia noticia = new Noticia(titulo, sumario, conteudo);
                noticias.add(noticia);

                // Log.v(LOGTAG, noticia.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return noticias;
    }

}
