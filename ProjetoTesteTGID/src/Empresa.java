public class Empresa {
    private String nome;
    private String cnpj;
    private double saldo;
    private double taxaSistema;

    public Empresa(String nome, String cnpj, double saldo, double taxaSistema) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.saldo = saldo;
        this.taxaSistema = taxaSistema;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getTaxaSistema() {
        return taxaSistema;
    }

    public void setTaxaSistema(double taxaSistema) {
        this.taxaSistema = taxaSistema;
    }
}
