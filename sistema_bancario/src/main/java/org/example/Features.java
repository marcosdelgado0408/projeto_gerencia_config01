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

    public static void debitarValor(long numeroConta){
        for(Conta conta: contas){
            if(conta.getNumeroConta() == numeroConta){
                System.out.println("----------------------------------");
                System.out.println("Digite o valor a ser debitado na conta:");

                Scanner scanner = new Scanner(System.in);
                double valorDebito = scanner.nextDouble();

                valorDebito = conta.getSaldo() - valorDebito;


                conta.setSaldo(valorDebito);

                System.out.println("Valor debitado sucesso");
                return;
            }
        }
        System.out.println("Erro -> Essa conta nao foi cadastrada");
    }


    public static void transferir(long numeroConta) {

        for(Conta conta: contas) {
            if (conta.getNumeroConta() == numeroConta) {

                System.out.println("----------------------------------");
                System.out.println("Digite o numero da conta que deseja transferir: ");

                Scanner scanner = new Scanner(System.in);
                long contaParaTransferir = scanner.nextInt();

                System.out.println("Digite o valor que deseja transferir: ");
                scanner = new Scanner(System.in);
                double valor = scanner.nextDouble();

                for(Conta conta1: contas){
                    if(conta1.getNumeroConta() == contaParaTransferir){
                        conta.setSaldo(conta.getSaldo() - valor);
                        conta1.setSaldo(conta1.getSaldo() + valor);

                        System.out.println("Dinheiro transferido com sucesso");
                        return;
                    }
                }
                System.out.println("Erro -> Essa conta nao foi cadastrada");



            }
        }

        System.out.println("Erro -> Essa conta nao foi cadastrada");


    }



}




