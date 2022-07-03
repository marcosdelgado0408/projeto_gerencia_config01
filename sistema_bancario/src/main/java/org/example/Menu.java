package org.example;

import java.util.Scanner;

public class Menu {


    public void showMenu(){
        System.out.println("=======================================");
        System.out.println("       Sistema bancario primitivo");
        System.out.println("Digite a acao que deseja realizar:");
        System.out.println("1 - Cadastrar conta");
        System.out.println("2 - Consultar saldo");
        System.out.println("3 - Solicitar credito");
        System.out.println("4 - Debitar");
        System.out.println("5 - Transferencia");
        System.out.println("6 - Render juros");
        System.out.println("0 - Sair");
        System.out.println("=======================================");
    }

    public void inicializar(){
        Scanner scanner;

        do {
            showMenu();


            scanner = new Scanner(System.in);
            int input  = scanner.nextInt();


            switch (input) {

                case 1:

                    System.out.println("Digite o novo numero da sua conta: ");
                    scanner = new Scanner(System.in);
                    Features.cadastrarConta(scanner.nextLong());
                break;

                case 2:
                    System.out.println("Digite o numero da conta: ");
                    scanner = new Scanner(System.in);
                    Features.consultarSaldo(scanner.nextLong());
                break;
                case 3:

                    System.out.println("Digite o numero da conta: ");
                    scanner = new Scanner(System.in);
                    long conta = scanner.nextLong();

                    System.out.println("----------------------------------");
                    System.out.println("Digite o valor a ser creditado:");

                    scanner = new Scanner(System.in);
                    double valorCredito = scanner.nextDouble();

                    Features.addCredito(conta, valorCredito);
                break;
                case 4:
                    System.out.println("Digite o numero da conta: ");
                    scanner = new Scanner(System.in);
                    long conta2 = scanner.nextLong();

                    System.out.println("----------------------------------");
                    System.out.println("Digite o valor a ser debitado na conta:");

                    scanner = new Scanner(System.in);
                    double valorDebito = scanner.nextDouble();

                    Features.debitarValor(conta2, valorDebito);
                break;
                case 5:
                    System.out.println("Digite o numero da sua conta: ");
                    scanner = new Scanner(System.in);
                    long suaConta = scanner.nextLong();

                    System.out.println("----------------------------------");
                    System.out.println("Digite o numero da conta que deseja transferir: ");

                    scanner = new Scanner(System.in);
                    long contaParaTransferir = scanner.nextInt();

                    System.out.println("Digite o valor que deseja transferir: ");
                    scanner = new Scanner(System.in);
                    double valor = scanner.nextDouble();

                    Features.transferir(suaConta, contaParaTransferir, valor);
                break;
                case 6:
                    System.out.println("Digite o numero da sua conta: ");
                    scanner = new Scanner(System.in);
                    long numeroConta = scanner.nextLong();

                    System.out.println("Digite a taxa de juros:");
                    scanner = new Scanner(System.in);
                    double taxaJuros = scanner.nextDouble();

                    Features.renderJuros(numeroConta, taxaJuros);
                break;
                case 0:
                    return;

            }

        } while (true);



    }


}
    