import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Util {
    public static JButton createButton(String texto, int posX, int posY, int width, int height) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Segoe UI", Font.BOLD, 18));
        botao.setBorder(new LineBorder(Color.black, 1));
        botao.setBounds(posX, posY, width, height);
        botao.setBackground(new Color(94, 23, 235));
        botao.setForeground(Color.WHITE);
        botao.setBorderPainted(true);
        botao.setFocusPainted(false);
        return botao;
    }

    public static JLabel createLabel(String texto, int sizeFont, int posX, int posY, int width, int height) {
        JLabel label = new JLabel(texto);
        label.setBounds(posX, posY, width, height);
        label.setForeground(Color.BLACK);
        label.setHorizontalAlignment(SwingConstants.LEFT); // Centraliza o texto no label
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, sizeFont));
        return label;
    }

    public static JLabel createLabel(String texto, int posX, int posY, int width, int height) {
        JLabel label = new JLabel(texto);
        label.setBounds(posX, posY, width, height);
        label.setForeground(Color.BLACK);
        label.setHorizontalAlignment(SwingConstants.LEFT); // Centraliza o texto no label
        label.setVerticalAlignment(SwingConstants.CENTER);
        return label;
    }

    public static JTextField createTextField(int posX, int posY, int width, int height) {
        JTextField campo = new JTextField();
        campo.setBounds(posX, posY, width, height);
        campo.setBorder(new LineBorder(Color.black, 1));
        return campo;
    }

    public static JPasswordField createPasswordField(int posX, int posY, int width, int height) {
        JPasswordField campo = new JPasswordField();
        campo.setBounds(posX, posY, width, height);
        campo.setBorder(new LineBorder(Color.black, 1));
        return campo;
    }

    public static JLabel ResizingImage(int altura, int largura, String caminhoImagem) {
        ImageIcon imagemOriginal = new ImageIcon(caminhoImagem);
        Image imagemRedimensionada  = imagemOriginal.getImage().getScaledInstance(largura, altura, Image.SCALE_SMOOTH);
        ImageIcon novaImagem = new ImageIcon(imagemRedimensionada );
        JLabel imagem = new JLabel(novaImagem);
        return imagem;
    }
    public static JLabel LoadImage(String caminhoImagem) {
        ImageIcon imagemOriginal = new ImageIcon(caminhoImagem);
        JLabel imagem = new JLabel(imagemOriginal);
        return imagem;
    }


}
