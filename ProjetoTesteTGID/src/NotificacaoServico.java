import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class NotificacaoServico {

    public void enviarCallback(Empresa empresa, Transacao transacao) {
        try {
            URL url = new URL("https://webhook.site/b76b19e5-94cb-49e3-b519-c7cdf1e34699");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String json = "{"
                    + "\"empresa\": \"" + empresa.getNome() + "\","
                    + "\"tipoTransacao\": \"" + transacao.getForma() + "\","
                    + "\"valor\": " + transacao.getValor()
                    + "}";

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Callback enviado com sucesso para empresa " + empresa.getNome());
            } else {
                System.out.println("Erro ao enviar callback para empresa " + empresa.getNome());
            }

        } catch (Exception e) {
            System.out.println("Erro ao enviar callback: " + e.getMessage());
        }
    }

    public void enviarNotificacao(Cliente cliente, Transacao transacao) {
        System.out.println("Notificando cliente " + cliente.getNome() + " sobre "
                + transacao.getForma() + " de R$" + transacao.getValor());
     }
}
