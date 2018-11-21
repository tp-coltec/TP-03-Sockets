package com.example.haasi.tp_03;

public class Chat {
    private String Nome;
    private String Porta;
    private int Foto;

    public Chat (String nome, String porta, int foto){
        this.Nome = nome;
        this.Porta = porta;
        this.Foto = foto;
    }

    public int getFoto() {
        return Foto;
    }

    public void setFoto(int foto) {
        Foto = foto;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getPorta() {
        return Porta;
    }

    public void setPorta(String porta) {
        Porta = porta;
    }



}
