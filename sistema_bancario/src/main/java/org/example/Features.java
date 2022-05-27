package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Features {

    static ArrayList<Conta> contas = new ArrayList<>();



    public static void cadastrarConta(long numero) {
        contas.add(new Conta(numero, 0.0));

        System.out.println("Nova conta criada");
        System.out.println("Numero da conta: " + contas.get(0).getNumeroConta());
        System.out.println("Saldo da conta: " + contas.get(0).getSaldo());
    }

    public static void consultarSaldo(long numero){
        for(Conta conta: contas){
            if(conta.getNumeroConta() == numero){
                System.out.println("Saldo da conta " + numero + " :" + conta.getSaldo());
                return;
            }
        }
        System.out.println("Erro -> Essa conta nao foi cadastrada");
    }

    public static void addCredito(long numeroConta){

        for(Conta conta: contas){
            if(conta.getNumeroConta() == numeroConta){
                System.out.println("----------------------------------");
                System.out.println("Digite o valor a ser creditado:");

                Scanner scanner = new Scanner(System.in);
                double valorCredito = scanner.nextDouble();

                valorCredito += conta.getSaldo();
                conta.setSaldo(valorCredito);

                System.out.println("Saldo creditado com sucesso");
                return;
            }
        }
        System.out.println("Erro -> Essa conta nao foi cadastrada");


    }




}
