import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PaginaLogin extends JFrame {
    public int ALTURA_JANELA = 600;
    public int LARGURA_JANELA = 800;

    public PaginaLogin(){
        setTitle("Pagina de Login");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(LARGURA_JANELA, ALTURA_JANELA);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, LARGURA_JANELA - 10, ALTURA_JANELA - 30);
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.BLACK);

        int larguraLogoPanel = (int)(LARGURA_JANELA * 0.55); // 440 de 800
        int alturaPainel = (int)(ALTURA_JANELA * 0.80);      // 480 de 600
        int larguraLoginPanel = (int)(LARGURA_JANELA * 0.375); // 300 de 800

        JPanel logoPanel = new JPanel();
        logoPanel.setBounds(40, 38, 702, alturaPainel + 4);
        logoPanel.setBorder(new LineBorder(new Color(94, 23, 235), 2));
        logoPanel.setLayout(null);
        logoPanel.setBackground(Color.DARK_GRAY);

        String Texto = "<html><div text-align: center>INFINITE <br>SOFTWARE</div></html>";
        JLabel nomeEmpresa = Util.createLabel(Texto, 30, 125, 40, 150, 100);
        nomeEmpresa.setFont(new Font("Segoe UI", Font.BOLD, 28));
        nomeEmpresa.setForeground(Color.WHITE);
        logoPanel.add(nomeEmpresa);

        ImageIcon imagem = new ImageIcon("src/Imagens/LogoMarca.png");
        JLabel logoMarca = new JLabel(imagem);
        logoMarca.setBounds(75, 150, 250, 250);
        logoPanel.add(logoMarca);

        String miniTexto = "<html><div text-align: center>Inovação sem limites, <br>soluções infinitas.</div></html>";
        JLabel sloganEmpresa = Util.createLabel(miniTexto, 16, 125, 400, 150, 50);
        sloganEmpresa.setFont(new Font("Segoe UI", Font.BOLD, 14));
        sloganEmpresa.setForeground(Color.WHITE);
        logoPanel.add(sloganEmpresa);

        JPanel painelLogin = new JPanel();
        painelLogin.setBounds(larguraLogoPanel, 40, larguraLoginPanel, alturaPainel);
        painelLogin.setLayout(null);
        painelLogin.setBackground(Color.WHITE);

        int margemX = (LARGURA_JANELA / 100 * 2);
        int margemY = (ALTURA_JANELA / 100 * 24);

        int larguraCampo = 250;
        int alturaCampo = 30;
        int alturaLabel = 30;

        int larguraBotao = 150;
        int alturaBotao = 35;

        int centroPainelLogin = ((LARGURA_JANELA / 100 * 40) - larguraBotao) / 2;

        JLabel textoLogin = Util.createLabel("Pagina Login", 24, centroPainelLogin, 50, larguraBotao, 50);
        painelLogin.add(textoLogin);

        JLabel textUser = Util.createLabel("Usuário",  18, margemX, margemY, 100, alturaLabel);
        textUser.setFont(new Font("Segoe UI", Font.BOLD, 18));
        painelLogin.add(textUser);

        JTextField campoUser = Util.createTextField(margemX, margemY + 40, larguraCampo, alturaCampo);
        painelLogin.add(campoUser);

        JLabel textPassword = Util.createLabel("Senha", 18, margemX, margemY + 80, 100, alturaLabel);
        textPassword.setFont(new Font("Segoe UI", Font.BOLD, 18));
        painelLogin.add(textPassword);

        JPasswordField campoPassword = Util.createPasswordField(margemX, margemY + 120, larguraCampo, alturaCampo);
        painelLogin.add(campoPassword);

        // Botões
        JButton botaoEntrar = Util.createButton("Entrar", centroPainelLogin, 360, larguraBotao, alturaBotao);
        botaoEntrar.addActionListener(e -> {
            System.out.println("User: " + campoUser.getText());
            System.out.println("Password: " + campoPassword.getText());
            PaginaInicial paginaInicial = new PaginaInicial();
            paginaInicial.iniciar();
        });
        painelLogin.add(botaoEntrar);

        JButton botaoCadastrar = Util.createButton("Cadastrar", centroPainelLogin, 405, larguraBotao, alturaBotao);
        botaoCadastrar.addActionListener( e-> {
            PaginaCadastro paginaCadastro = new PaginaCadastro();
            paginaCadastro.iniciar();
        });
        painelLogin.add(botaoCadastrar);

        mainPanel.add(painelLogin);
        mainPanel.add(logoPanel);
        add(mainPanel);
    }

    public void iniciar(){
        setVisible(true);
    }
}
