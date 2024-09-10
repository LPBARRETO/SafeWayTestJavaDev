public class TransacaoServico {
    private NotificacaoServico notificacaoServico;

    public TransacaoServico(NotificacaoServico notificacaoServico) {
        this.notificacaoServico = notificacaoServico;
    }

    public void realizarDeposito(Cliente cliente, Empresa empresa, double valor) {
        double valorComTaxa = valor - (valor * empresa.getTaxaSistema());
        empresa.setSaldo(empresa.getSaldo() + valorComTaxa);
        cliente.setSaldo(cliente.getSaldo() + valor);

        Transacao transacao = new Transacao(cliente, empresa, valor, "Deposito");

        notificacaoServico.enviarCallback(empresa, transacao);
        notificacaoServico.enviarNotificacao(cliente, transacao);
    }

    public void realizarSaque(Cliente cliente, Empresa empresa, double valor) {
        if (empresa.getSaldo() >= valor) {
            empresa.setSaldo(empresa.getSaldo() - valor);
            cliente.setSaldo(cliente.getSaldo() - valor);

            Transacao transacao = new Transacao(cliente, empresa, valor, "Saque");

            notificacaoServico.enviarCallback(empresa, transacao);
            notificacaoServico.enviarNotificacao(cliente, transacao);
        } else {
            System.out.println("Saldo insuficiente na empresa.");
        }
    }
}
