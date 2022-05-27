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
        System.out.println("=======================================");
    }

    public void goToMethod(int input){
        switch (input){

            case 1:

                System.out.println("Digite o novo numero da sua conta: ");
                Scanner scanner = new Scanner(System.in);
                long novoNumero = scanner.nextLong();
                Features.cadastrarConta(novoNumero);
                break;

            case 2:


        }

    }


}
