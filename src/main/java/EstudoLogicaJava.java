import javax.swing.*;

public class EstudoLogicaJava {

    public static void main (String[] args){

        int nota1 = 10;
        int nota2 = 60;
        int nota3 = 10;
        int nota4 = 10;
        int media = 0;

        media = (nota1 + nota2 + nota3 + nota4) / 4;

        /*Condições Logicas com IF e ELSE*/

        if (media >= 70){
            System.out.println("Aluno aprovado: " + media);
        }
        if (media >= 40 && media <= 69){
            System.out.println("Aluno em recuperação: " + media);
        }
        else{
            System.out.println("Aluno reprovado: " + media);
        }


        /*Operadores ternários são para micro validações*/
        String saidaResultado;

        saidaResultado = media >= 70 ? "Aluno aprovado" : (media >= 40 && media <= 69) ? "Aluno em recuperação" : "Reprovado";
        System.out.println(saidaResultado);


        /*Switch case: serve para operações exatas*/
        int dia = 1;
        switch (dia){
            case 1:
                System.out.println("Domingo");
                break;
            case 2:
                System.out.println("Segunda-feira");
                break;
            default:
                System.out.println("Outro dia qualquer");
        }

        if (nota1 == nota2){
            System.out.println("As notas são iguais");
        }else{
            System.out.println("As notas são diferentes");
        }

        /*Estrutura de repetição while*/
        int numero = 0;
        while (numero <= 10){     /*O WHILE verifica e executa o código*/
            System.out.println("O número atual é: " + numero);
            numero ++;
        }


        /*------------------------------------*/
        int numero2 = 0;
        do {
            /*Primeiro executa depois verifica*/
            System.out.println("O número atual é: " + numero2);
            numero2 ++;
        }while (numero2 <= 60);


        /*Extrutura de repetição FOR*/
        for (int numero7 = 0; numero7 <= 10; numero7++){
            System.out.println("Numero atual é: "+ numero7);
        }

        /*Extrutura de repetição FOR com Break (Parada)*/
        for (int numero77 = 0; numero77 <= 10; numero77++){
            if (numero77 == 7);
            System.out.println("Encontrei o numero 7");
            System.out.println("Estou parando de executar!");
            break;
        }

        /*Extrutura de repetição FOR e Continue*/
        for (int numero77 = 0; numero77 <= 10; numero77++){
            if (numero77 == 3 || numero77 == 6 || numero77 == 9);
            System.out.println("Encontrei o numero " +numero77);
            continue;
        }

        /*  Módulo: Resto da divisão %  */
        double carro = 9;
        double pessoa = 2;

        double resto = carro % pessoa;  /*MOD*/

        System.out.println("Sobraram exatamente: " + resto + " carros.");





        String carros = JOptionPane.showInputDialog("Informa a quantidade de carros: ");
        String pessoas = JOptionPane.showInputDialog("Informa a quantidade de pessoas: ");
        double carroNumero = Double.parseDouble(carros);
        double pessoaNumero = Double.parseDouble(pessoas);
        int divisao = (int) (carroNumero / pessoaNumero);
        resto = carroNumero % pessoaNumero;
        int resposta = JOptionPane.showConfirmDialog(null,"Deseja ver o resultado da divisão? ");
        if (resposta == 0){
            JOptionPane.showMessageDialog(null, "Divisão para pessoas deu " + divisao);
        }else {
            System.out.println("Não quis ver o resultado.");
        }
        resposta = JOptionPane.showConfirmDialog(null, "Deseja ver o resto da divisão:");
        if (resposta == 0){
            JOptionPane.showMessageDialog(null, "O resto da divisão é " + resto);
        }else {
            System.out.println("Não quis ver o resultado");
        }



    }
}
