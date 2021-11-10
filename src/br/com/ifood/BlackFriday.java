package br.com.ifood;

public class BlackFriday {

    private int id;
    private int desconto;
    private String descricao;

    public BlackFriday(int id, int desconto, String descricao) {
        this.id = id;
        this.desconto = desconto;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "BlackFriday{" +
                "id=" + id +
                ", desconto=" + desconto +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
