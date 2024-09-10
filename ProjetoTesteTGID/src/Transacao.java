public class Transacao {
    private Cliente cliente;
    private Empresa empresa;
    private double valor;
    private String forma;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }


    public Transacao(Cliente cliente, Empresa empresa, double valor, String forma) {
        this.cliente = cliente;
        this.empresa = empresa;
        this.valor = valor;
        this.forma = forma;

    }

}
