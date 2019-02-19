package br.edu.ifpb.atividadenotification;

import java.io.Serializable;
import java.util.Objects;

public class Noticia implements Serializable {

    private String title;
    private String summary;
    private String content;

    public Noticia(String title, String summary, String content) {
        this.title = title;
        this.summary = summary;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Noticia noticia = (Noticia) o;
        return Objects.equals(title, noticia.title) &&
                Objects.equals(summary, noticia.summary) &&
                Objects.equals(content, noticia.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, summary, content);
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
