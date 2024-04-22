import javax.swing.*;

public class EstudoJavaCalculoMedia {

    public static void main(String[] args) {

        String nota1 = JOptionPane.showInputDialog("Informa a primeira nota: ");
        String nota2 = JOptionPane.showInputDialog("Informa a segunda nota: ");
        String nota3 = JOptionPane.showInputDialog("Informa a terceira nota: ");
        String nota4 = JOptionPane.showInputDialog("Informa a quarta nota: ");

        double dNota1 = Double.parseDouble(nota1);
        double dNota2 = Double.parseDouble(nota2);
        double dNota3 = Double.parseDouble(nota3);
        double dNota4 = Double.parseDouble(nota4);

        double media = (dNota1 + dNota2 + dNota3 + dNota4) / 4;

        /* Média para a aprovação é 70*/
        if (media >= 50) {
            if (media >= 70) {
                JOptionPane.showMessageDialog(null, "Aluno está aprovado com média de: " + media);
            }else {
                JOptionPane.showMessageDialog(null, "Aluno em recuperação com média de: " + media);
            }
        }else {
            JOptionPane.showMessageDialog(null, "Aluno está reprovado com média de: " + media);
            }
        }
    }