import java.io.*;
import java.nio.charset.StandardCharsets;

public class Validacao {
    private static String caminhoArquivo = "./BancoDeDados/DadosUsuario.csv";
    private static String caminhoArquivoUserLog = "./BancoDeDados/Usuariologado.txt";

    //Metodo para adicionar um novo usuario
    public static void AdicionarUsuario(Usuario user){
         try{
             // Verificar se o banco de dados existe
             boolean arquivoExiste = new File(caminhoArquivo).exists();

             // Abre o escritor para adicionar arquivo
             FileWriter escritor = new FileWriter(caminhoArquivo,StandardCharsets.ISO_8859_1, arquivoExiste);

             // Escrever o titulo caso o arquivo não exista
             if (!arquivoExiste){
                 escritor.write("Nome;Usuário;Senha\n");
             }
             if (!user.getNome().isEmpty() || !user.getUsuario().isEmpty() || !user.getSenha().isEmpty()){
                 // Adicionar dados do Usuario
                 String nomeUsuario = user.getNome().replace(" ", "-");
                 escritor.write(nomeUsuario.strip() + ";" + user.getUsuario().strip() + ";" + user.getSenha().strip() + "\n");

                 // Escreve todos os dados do buffer no arquivo imediatamente
                 escritor.flush();
             }
             // Fecha o recurso de escrita
             escritor.close();

         } catch (IOException e) {
             e.printStackTrace();
         }
    }

    // Metodo para validar usuario
    private static String usuario_BD;
    private static String senha_BD;
    public static boolean ValidarUsuario(String dadoUsuario, String dadoSenha){
        boolean validacao = false;
        if (dadoUsuario.isEmpty() || dadoSenha.isEmpty()){
            return false;
        }else{
            try{
                // Abrir um leitor para ler o arquivo
                BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo));
                String linha;
                boolean primeiraLinha = true;

                while ( (linha = leitor.readLine()) != null){
                    // Ignora a primeira linha
                    if (primeiraLinha){
                        primeiraLinha = false;
                        continue;
                    }

                    String[] dadosColuna = linha.split(";");
                    usuario_BD = dadosColuna[1];
                    senha_BD = dadosColuna[2];

                    // Se usuario existe
                    if (dadoUsuario.equals(usuario_BD)){
                        // Se Senha e igual
                        if (dadoSenha.equals(senha_BD)){
                            // Usuario e Senha encontrado: Usuario existente
                            validacao = true;
                            try {
                                // Cria um arquivo Temporario que vai guardar o nome do Usuario
                                FileWriter escritor = new FileWriter(caminhoArquivoUserLog, StandardCharsets.ISO_8859_1);
                                escritor.write(dadosColuna[0]);
                                escritor.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return validacao;
    }
    public static String MostrarNome(){
        String nomeUsuario = "";
        try {
            // Inicia o leitor
            BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivoUserLog));
            String linha = leitor.readLine();

            // Formata o nome de usuario
            String[] dadosColuna = linha.split(";");
            nomeUsuario = dadosColuna[0].strip().replace("-", " ");

            // Fecha o leitor
            leitor.close();

            File arquivo = new File(caminhoArquivoUserLog);

            // Tenta deletar o arquivo
            arquivo.delete();


        } catch (IOException e) {
            e.printStackTrace();
        }
        return nomeUsuario;


    }

}
