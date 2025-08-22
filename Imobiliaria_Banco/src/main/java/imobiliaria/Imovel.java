package imobiliaria;

public class Imovel {
    private int id;
    private String endereco;
    private String tipo;
    private int quartos;
    private double valorAluguel;
    private boolean disponivel;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getQuartos() { return quartos; }
    public void setQuartos(int quartos) { this.quartos = quartos; }

    public double getValorAluguel() { return valorAluguel; }
    public void setValorAluguel(double valorAluguel) { this.valorAluguel = valorAluguel; }

    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
}
