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

                case 1 -> {



                    System.out.println("Digite o novo numero da sua conta: ");
                    scanner = new Scanner(System.in);
                    Features.cadastrarConta(scanner.nextLong());


                }

                case 2 -> {
                    System.out.println("Digite o numero da conta: ");
                    scanner = new Scanner(System.in);
                    Features.consultarSaldo(scanner.nextLong());
                }
                case 3 -> {

                    System.out.println("Digite o numero da conta: ");
                    scanner = new Scanner(System.in);

                    Features.addCredito(scanner.nextLong());
                }
                case 4 -> {
                    System.out.println("Digite o numero da conta: ");
                    scanner = new Scanner(System.in);

                    Features.debitarValor(scanner.nextLong());
                }
                case 5 -> {
                    System.out.println("Digite o numero da sua conta: ");
                    scanner = new Scanner(System.in);

                    Features.transferir(scanner.nextLong());
                }
                case 6 -> {
                    System.out.println("Digite o numero da sua conta: ");
                    scanner = new Scanner(System.in);

                    Features.renderJuros(scanner.nextLong());
                }
                case 0 ->{
                    return;
                }

            }

        } while (true);









    }


}
    