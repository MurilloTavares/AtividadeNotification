package br.edu.ifpb.atividadenotification;

import android.util.Log;

import java.util.ArrayList;

public class NoticiasEmMemoria {

    private ArrayList<Noticia> noticias;

    public NoticiasEmMemoria() {
        noticias = new ArrayList<>();
    }

    public NoticiasEmMemoria(ArrayList<Noticia> noticias) {
        this.noticias = noticias;
    }

    // Adiciona e compara novas noticias com noticias da memoria
    // Caso a noticia seja nova, adiciona na memoria
    // No final retorna as novas noticias que foram salvas
    public ArrayList<Noticia> addAngGetNovasNoticias(ArrayList<Noticia> noticiasParam){
        ArrayList<Noticia> novasNoticias = new ArrayList<>();
        for(Noticia noticiaParam : noticiasParam) {
            if(!this.noticias.contains(noticiaParam)){
                novasNoticias.add(noticiaParam);
                this.noticias.add(noticiaParam);
            }
        }
        return novasNoticias;
    }

    public void setNoticias(ArrayList<Noticia> noticias){
        this.noticias = noticias;
    }

    public ArrayList<Noticia> getNoticias(){
        return this.noticias;
    }

}
