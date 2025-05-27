import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PaginaInicial extends JFrame {
    public int ALTURA_JANELA = 600;
    public int LARGURA_JANELA = 800;

    public PaginaInicial() {
        setSize(LARGURA_JANELA, ALTURA_JANELA);
        setTitle("Pagina de Inicial");
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, LARGURA_JANELA, ALTURA_JANELA);
        mainPanel.setBackground(Color.BLACK);
        mainPanel.setLayout(null);

        JPanel panelFinal = new JPanel();
        panelFinal.setBounds(40, 38, 702, 480 + 4);
        panelFinal.setBorder(new LineBorder(new Color(94, 23, 235), 1));
        panelFinal.setLayout(null);
        panelFinal.setBackground(Color.DARK_GRAY);

        JLabel mensagemBemVindo = Util.createLabel("Bem-Vindo", 26, 30, 50, 140, 50);
        mensagemBemVindo.setForeground(Color.WHITE);
        panelFinal.add(mensagemBemVindo);

        JLabel nomeUser = Util.createLabel("Laryson Mendonça Martins", 26, 175, 50, 340, 50);
        nomeUser.setForeground(new Color(94, 23, 235));
        panelFinal.add(nomeUser);

        String texto = "<html><div text-align: center>Você chegou ao fim do projeto, esse software foi desevolvido com objetivos para estudos de Java Swing;</div></html>";
        JLabel mensagemFinal = Util.createLabel(texto, 25, 40, 400, 250);
        mensagemFinal.setFont(new Font("Segoe UI", Font.BOLD, 26));
        mensagemFinal.setForeground(Color.WHITE);
        panelFinal.add(mensagemFinal);

        JLabel imagemFinal = Util.RedimencionamentoImagem(325, 325, "src/imagens/ImagemFinal.png");
        imagemFinal.setBounds(390, 0, 400, 400);
        panelFinal.add(imagemFinal);

        JLabel imagemQRCode = Util.RedimencionamentoImagem(200, 170, "src/imagens/QRCode.png");
        imagemQRCode.setBounds(10, 280, 170, 200);
        panelFinal.add(imagemQRCode);

        JLabel textoContato = Util.createLabel("Contato", 190, 275, 200, 50);
        textoContato.setForeground(new Color(94, 23, 235));
        textoContato.setFont(new Font("Segoe UI", Font.BOLD, 26));
        panelFinal.add(textoContato);

        JLabel iconTelefone = Util.RedimencionamentoImagem(20, 20, "src/imagens/IconeTelefone.png");
        iconTelefone.setBounds(190, 330, 20, 20);
        panelFinal.add(iconTelefone);

        JLabel textTelefone = Util.createLabel("(62) 9 9553-5293", 14, 215, 318, 150, 40);
        textTelefone.setForeground(Color.WHITE);
        panelFinal.add(textTelefone);

        // Emal
        JLabel iconEmail = Util.RedimencionamentoImagem(20, 20, "src/imagens/IconeEmail.png");
        iconEmail.setBounds(190, 365, 20, 20);
        panelFinal.add(iconEmail);

        JLabel textEmail = Util.createLabel("larysonmendonca008@gmail.com", 14, 215, 353, 250, 40);
        textEmail.setForeground(Color.WHITE);
        panelFinal.add(textEmail);

        // Likedin
        JLabel iconLinkedin = Util.RedimencionamentoImagem(20, 20, "src/imagens/IconeLinkedin.png");
        iconLinkedin.setBounds(190, 395, 20, 20);
        panelFinal.add(iconLinkedin);

        JLabel textLinkedin = Util.createLabel("www.linkedin.com/in/LarysonMendonça", 14, 215, 383, 300, 40);
        textLinkedin.setForeground(Color.WHITE);
        panelFinal.add(textLinkedin);

        mainPanel.add(panelFinal);
        add(mainPanel);
    }

    public void iniciar(){
        setVisible(true);
    }


}
