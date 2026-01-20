package br.com.exercicio.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AdvicesClip {
    private String conselho;

    public AdvicesClip(AdvicesClipJson advicesClipJson) {
        this.conselho = advicesClipJson.slip().advice();
    }

    public String getConselho() {
        return conselho;
    }

    @Override
    public String toString() {
        return "Conselho:\n" + conselho;
    }

}
