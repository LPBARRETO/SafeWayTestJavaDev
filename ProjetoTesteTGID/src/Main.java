public class Main {
    public static void main(String[] args) {
        NotificacaoServico notificacaoServico = new NotificacaoServico();
        TransacaoServico transacaoServico = new TransacaoServico(notificacaoServico);

        Cliente cliente = new Cliente("Lucas Barreto e-mail lpbarreto97@gmail.com", "123.456.789-09", 2300.0);
        Empresa empresa = new Empresa("Empresa TGID", "12.345.o678/0001-95", 1200000.0, 0.05); 

        if (!ValidadorCPF.validarCpf(cliente.getCpf())) {
            System.out.println("CPF inválido para o cliente.");
            return;
        }

        if (!ValidadorCNPJ.validarCnpj(empresa.getCnpj())) {
            System.out.println("CNPJ inválido para a empresa.");
            return;
        }

        
        transacaoServico.realizarDeposito(cliente, empresa, 59800.0);
        transacaoServico.realizarSaque(cliente, empresa, 20.0);


        System.out.println("Saldo do Cliente: R$" + cliente.getSaldo());
        System.out.println("Saldo da Empresa: R$" + empresa.getSaldo());
    }
}
