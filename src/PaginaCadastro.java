import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PaginaCadastro extends JDialog {
    int LARGURA_JANELA = 350;
    int ALTURA_JANELA = 550;

    public PaginaCadastro(){
        setTitle("Pagina de Cadastro");
        setSize(LARGURA_JANELA, ALTURA_JANELA);
        setResizable(false);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setModal(true);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.DARK_GRAY);
        mainPanel.setBounds(0, 0, LARGURA_JANELA, ALTURA_JANELA);
        mainPanel.setBorder(new LineBorder(new Color(94, 23, 235), 1));

        ImageIcon icon = new ImageIcon("src/imagens/InfiniteLogo.png");
        JLabel label = new JLabel(icon);
        label.setBounds(0, 0, 150, 60);
        mainPanel.add(label);


        JLabel tituloCadastro = Util.createLabel("Cadastro", 24, 100, 40, 150, 50);
        tituloCadastro.setHorizontalAlignment(SwingConstants.CENTER);
        tituloCadastro.setForeground(Color.WHITE);
        mainPanel.add(tituloCadastro);

        JLabel textoNomeExibicao = Util.createLabel("Nome de exibição", 18, 40, 100, 260, 30);
        textoNomeExibicao.setForeground(Color.WHITE);
        mainPanel.add(textoNomeExibicao);

        JTextField campoNomeExibicao = Util.createTextField(40, 140, 260, 30);
        mainPanel.add(campoNomeExibicao);

        JLabel textoNomeUsuario = Util.createLabel("Nome de usuário", 18, 40, 180, 260, 30);
        textoNomeUsuario.setForeground(Color.WHITE);
        mainPanel.add(textoNomeUsuario);

        JTextField campoUsuario = Util.createTextField(40, 220, 260, 30);
        mainPanel.add(campoUsuario);

        JLabel textoSenhaAcesso = Util.createLabel("Senha de acesso", 18, 40, 260, 260, 30);
        textoSenhaAcesso.setForeground(Color.WHITE);
        mainPanel.add(textoSenhaAcesso);

        JTextField campoSenhaAcesso = Util.createTextField(40, 300, 260, 30);
        mainPanel.add(campoSenhaAcesso);

        JLabel textoSenhaConfirmacao = Util.createLabel("Confirme sua senha", 18, 40, 340, 260, 30);
        textoSenhaConfirmacao.setForeground(Color.WHITE);
        mainPanel.add(textoSenhaConfirmacao);

        JTextField campoSenhaConfirmacao = Util.createTextField(40, 380, 260, 30);
        mainPanel.add(campoSenhaConfirmacao);

        JButton botaoCadastrar = Util.createButton("Cadastrar", 100, 450, 150, 40);
        botaoCadastrar.addActionListener(e -> {
            if (campoNomeExibicao.getText().isEmpty()){
                Util.marcarCampoInvalido(textoNomeExibicao, Color.WHITE);
                Util.marcarCampoInvalido(campoNomeExibicao);
                Util.mensagemCampoInvalido("Nome de exibição não pode estar vazio", 0, 420, mainPanel);
            } else if (campoUsuario.getText().isEmpty()) {
                Util.marcarCampoInvalido(textoNomeUsuario, Color.WHITE);
                Util.marcarCampoInvalido(campoUsuario);
                Util.mensagemCampoInvalido("O campo Usuário não pode estar vazio", 0, 420, mainPanel);
            } else if (campoUsuario.getText().split(" ").length > 1) {
                Util.marcarCampoInvalido(textoNomeUsuario, Color.WHITE);
                Util.marcarCampoInvalido(campoUsuario);
                Util.mensagemCampoInvalido("O campo Usuário não pode conter espaços", 0, 420, mainPanel);
            } else if (!campoSenhaAcesso.getText().equals(campoSenhaConfirmacao.getText()) || campoSenhaAcesso.getText().isEmpty()){
                Util.marcarCampoInvalido(textoSenhaAcesso, Color.WHITE);
                Util.marcarCampoInvalido(campoSenhaAcesso);
                Util.marcarCampoInvalido(textoSenhaConfirmacao, Color.WHITE);
                Util.marcarCampoInvalido(campoSenhaConfirmacao);
                Util.mensagemCampoInvalido("Senha Inválida", 0, 420, mainPanel);
            } else if (campoSenhaAcesso.getText().equals(campoSenhaConfirmacao.getText())) {
                Usuario usuario = new Usuario(campoNomeExibicao.getText(), campoUsuario.getText(), campoSenhaConfirmacao.getText());
                Validacao.AdicionarUsuario(usuario);
                dispose();
            }
        });
        mainPanel.add(botaoCadastrar);
        ImageIcon icone = new ImageIcon("src/imagens/InfiniteLogoBar.png");
        setIconImage(icone.getImage());
        add(mainPanel);
    }
    public void iniciar(){
        setVisible(true);
    }
}
