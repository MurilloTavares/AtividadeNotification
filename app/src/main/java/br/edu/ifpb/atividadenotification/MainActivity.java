package br.edu.ifpb.atividadenotification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lista = (ListView) findViewById(R.id.main_lvNoticias);
        ArrayList<Noticia> noticias = getNoticias();
        ArrayAdapter adpter = new NoticiaAdapter(this, noticias);
        lista.setAdapter(adpter);
    }

    private ArrayList<Noticia> getNoticias(){

        Noticia a = new Noticia("TITULO A", "SUMARIO A", "CONTEUDO A");
        Noticia b = new Noticia("TITULO B", "SUMARIO B", "CONTEUDO B");
        Noticia c = new Noticia("Cajazeirense filha de secretário adjunto Gilberto Rolim de apenas 22 anos comemora aprovação na OAB",
                "<p>Ela é filha do secretário adjunto da Agricultura da prefeitura de Cajazeiras, Gilberto Rolim</p>\n" +
                        "<p>The post <a rel=\"nofollow\" href=\"https://www.showdiario.com.br/noticias/cidades/358811/cajazeirense-filha-de-secretario-adjunto-gilberto-rolim-de-apenas-22-anos-comemora-aprovacao-na-oab.html\">Cajazeirense filha de secretário adjunto Gilberto Rolim de apenas 22 anos comemora aprovação na OAB</a> appeared first on <a rel=\"nofollow\" href=\"https://www.diariodosertao.com.br\">Diário do Sertão</a>.</p>\n",
                "<p>A jovem Gabriela Rodrigues Rolim, 22 anos, da cidade de Cajazeiras, Sertão do estado, comemorou juntamente com sua família a aprovação no exame de ordem da OAB (Ordem dos Advogados do Brasil).</p>\n" +
                        "<p>O resultado foi divulgado na terça-feira (12), e a comemoração tomou de conta de todos os amigos e membros da família.</p>\n" +
                        "<p>Gabriela concluiu o curso de direito em dezembro de 2018.</p>\n" +
                        "<p>Ela é filha do secretário adjunto da Agricultura da prefeitura de <a href=\"https://www.diariodosertao.com.br/cidade/cajazeiras\">Cajazeiras</a>, Gilberto Rolim.</p>\n" +
                        "\n" +
                        "<div class='row' style='margin-top:20px;margin-bottom:20px;'>     <div class='col-sm-6'>         <div data-premium='' data-adunit='DIARIO_DO_SERTAO_INTERNA_FINAL_1' data-sizes-desktop='[[300,250]]' data-sizes-mobile='[[300,250],[320,100],[320,50]]'></div>     </div>     <div class='col-sm-6'>         <div data-premium='' data-adunit='DIARIO_DO_SERTAO_INTERNA_FINAL_2' data-sizes-desktop='[[300,250]]' data-sizes-mobile='[[300,250],[320,100],[320,50]]'></div>     </div></div><p class=\"more-post-info\">\n" +
                        "            Leia mais notícias no <a href=\"www.showdiario.com.br\">www.showdiario.com.br</a>, \n" +
                        "            siga nas redes sociais: \n" +
                        "            <a href=\"https://www.facebook.com/portaldiariodosertao\" target=\"_blank\">Facebook</a>, \n" +
                        "            <a href=\"https://twitter.com/diariodosertao\" target=\"_blank\">Twitter</a>, \n" +
                        "            <a href=\"https://www.instagram.com/diariodosertao/\" target=\"_blank\">Instagram</a> \n" +
                        "            e veja nossos vídeos no <a href=\"https://wwww.diariodosertao.com.br/videos\" target=\"_blank\">Play Diário</a>. \n" +
                        "            Envie informações à Redação do Portal Diário do Sertão pelo \n" +
                        "            WhatsApp (83) 9 9156-5774.\n" +
                        "        </p><p>The post <a rel=\"nofollow\" href=\"https://www.showdiario.com.br/noticias/cidades/358811/cajazeirense-filha-de-secretario-adjunto-gilberto-rolim-de-apenas-22-anos-comemora-aprovacao-na-oab.html\">Cajazeirense filha de secretário adjunto Gilberto Rolim de apenas 22 anos comemora aprovação na OAB</a> appeared first on "
        );

        ArrayList<Noticia> noticias = new ArrayList<>();
        noticias.add(a);
        noticias.add(c);
        noticias.add(b);
        return noticias;
    }

}
