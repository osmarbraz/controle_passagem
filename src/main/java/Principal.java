import javax.swing.JOptionPane;

/**
 * Programa cliente do objeto calculadora.
 *
 * Classe que obtêm uma instância do objeto no servidor.
 *
 * @author osmar
 */
public class Principal {

    /**
     * Mostra a reposta do servidor.
     *
     * @param respostaServidor
     */
    public static void mostrarResultado(int respostaServidor) {
        switch (respostaServidor) {
            case 0:
                System.out.println("Voo e assento disponível");
                break;
            case 1:
                System.out.println("Assento indisponível");
                break;
            case 2:
                System.out.println("Assento inexistente");
                break;
            case 3:
                System.out.println("Voo inexistente");
                break;
            case 4:
                System.out.println("Assento marcado");
                break;
            default:
                System.out.println("Voo inexistente");
                break;
        }
    }

    public static void main(String args[]) {

        //Instancia o controlador de Voo           
        ControladorVoo controladorvoo = new ControladorVooImpl();

        int opcao = -1;

        while (opcao != 9) {

            opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha a opção: \n1 - Consulta voo \n2 - Marcação voo \n9 - Sair do sistema"));
            //Leitura dos dados da consulta do voo
            if (opcao == 1) {
                String voo = JOptionPane.showInputDialog("Consulta:\nDigite o codigo do voo");
                int assento = Integer.parseInt(JOptionPane.showInputDialog("Digite o assento:"));

                //Chama o método remoto
                int retorno = controladorvoo.verificarStatus(voo, assento);

                mostrarResultado(retorno);

            } else {
                //Leitura dos dados marcação do voo
                if (opcao == 2) {
                    String voo = JOptionPane.showInputDialog("Marcação:\nDigite o codigo do voo");
                    int assento = Integer.parseInt(JOptionPane.showInputDialog("Digite o assento:"));

                    //Chama o método remoto
                    int retorno = controladorvoo.marcarVoo(voo, assento);

                    mostrarResultado(retorno);
                }
            }
        }
    }
}
