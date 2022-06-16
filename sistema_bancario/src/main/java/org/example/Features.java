package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Features {

    static ArrayList<Conta> contas = new ArrayList<>();

    public static void cadastrarConta(long numero) {

        System.out.println("Digite o tipo de conta que deseja criar:");
        System.out.println("\n1 - Conta normal");
        System.out.println("2 - Conta bonus");
        System.out.println("3 - Conta poupanca");

        Scanner scanner = new Scanner(System.in);
        int tipoConta = scanner.nextInt();

        switch (tipoConta){
            case 1 ->{
                contas.add(new Conta(numero, 0.0, "normal"));
                System.out.println("Nova conta criada");
                System.out.println("Numero da conta: " + contas.get(contas.size()-1).getNumeroConta());
                System.out.println("Saldo da conta: " + contas.get(contas.size()-1).getSaldo());
            }
            case 2 ->{
                contas.add(new Conta(numero, 0.0, "bonus", 10));
                System.out.println("Nova conta criada");
                System.out.println("Numero da conta: " + contas.get(contas.size()-1).getNumeroConta());
                System.out.println("Saldo da conta: " + contas.get(contas.size()-1).getSaldo());
                System.out.println("Pontucao: " + contas.get(contas.size()-1).getPontuacao());
            }
            case 3 -> {
                System.out.println("E necessario digitar um saldo inicial na conta");
                System.out.println("Informe saldo inicial:");
                scanner = new Scanner(System.in);
                double saldoInicial = scanner.nextDouble();

                contas.add(new Conta(numero, saldoInicial, "poupanca"));
                System.out.println("Nova conta criada");
                System.out.println("Numero da conta: " + contas.get(contas.size()-1).getNumeroConta());
                System.out.println("Saldo da conta: " + contas.get(contas.size()-1).getSaldo());
            }
            default -> {
                System.out.println("Erro -> Esse tipo de conta nao existe");
                return;
            }
        }

    }



    public static void consultarSaldo(long numero){
        for(Conta conta: contas){
            if(conta.getNumeroConta() == numero){

                System.out.println("Saldo da conta " + numero + " :" + conta.getSaldo());
                if(conta.getTipoDeConta().equals("bonus")){
                    System.out.println("Pontuacao: " + conta.getPontuacao());
                }

                return;
            }
        }
        System.out.println("Erro -> Essa conta nao foi cadastrada");
    }


    // Vou considerar o deposito como a adição de créditos à conta
    public static void addCredito(long numeroConta){

        for(Conta conta: contas){
            if(conta.getNumeroConta() == numeroConta){
                System.out.println("----------------------------------");
                System.out.println("Digite o valor a ser creditado:");

                Scanner scanner = new Scanner(System.in);
                double valorCredito = scanner.nextDouble();

                if(valorCredito < 0){
                    System.out.println("Erro -> valor inserido nao pode ser negativo");
                    return;
                }


                valorCredito += conta.getSaldo();
                conta.setSaldo(valorCredito);

                if(conta.getTipoDeConta().equals("bonus")){
                    int valorBonus = (int) (valorCredito/100);
                    conta.setPontuacao(conta.getPontuacao() + valorBonus);
                }

                System.out.println("Saldo creditado com sucesso");
                return;
            }
        }
        System.out.println("Erro -> Essa conta nao foi cadastrada");
    }

    public static void debitarValor(long numeroConta){
        for(Conta conta: contas){
            if(conta.getNumeroConta() == numeroConta){

                if(conta.getSaldo() <= 0){
                    System.out.println("ERRO -> A conta possui saldo insuficiente para debito");
                    return;
                }

                System.out.println("----------------------------------");
                System.out.println("Digite o valor a ser debitado na conta:");

                Scanner scanner = new Scanner(System.in);
                double valorDebito = scanner.nextDouble();

                if(valorDebito < 0){
                    System.out.println("Erro -> valor inserido nao pode ser negativo");
                    return;
                }

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

                if (conta.getSaldo() <= 0) {
                    System.out.println("Erro -> saldo insuficiente para transferir");
                    return;
                }

                System.out.println("----------------------------------");
                System.out.println("Digite o numero da conta que deseja transferir: ");

                Scanner scanner = new Scanner(System.in);
                long contaParaTransferir = scanner.nextInt();

                System.out.println("Digite o valor que deseja transferir: ");
                scanner = new Scanner(System.in);
                double valor = scanner.nextDouble();

                if(valor < 0){
                    System.out.println("Erro -> valor inserido nao pode ser negativo");
                    return;
                }

                for(Conta conta1: contas){
                    if(conta1.getNumeroConta() == contaParaTransferir){
                        conta.setSaldo(conta.getSaldo() - valor);
                        conta1.setSaldo(conta1.getSaldo() + valor);

                        if(conta1.getTipoDeConta().equals("bonus")){
                            int valorBonus = (int) (valor/200);
                            conta1.setPontuacao(conta1.getPontuacao() + valorBonus);
                        }


                        System.out.println("Dinheiro transferido com sucesso");
                        return;
                    }
                }
                System.out.println("Erro -> Essa conta nao foi cadastrada");



            }
        }

        System.out.println("Erro -> Essa conta nao foi cadastrada");
    }


    public static void renderJuros(long numeroConta) {

        for (Conta conta: contas){
            if(numeroConta == conta.getNumeroConta()){

                if(conta.getTipoDeConta().equals("poupanca")){
                    System.out.println("Digite a taxa de juros:");
                    Scanner scanner = new Scanner(System.in);

                    double rendimento = conta.getSaldo() * (scanner.nextDouble()/100);
                    double saldoFinal = conta.getSaldo() + rendimento;

                    conta.setSaldo(saldoFinal);
                    System.out.println("Saldo final apos juros aplicados: " + saldoFinal);
                    return;
                }
                else {
                    System.out.println("Erro -> essa conta nao e uma conta poupanca");
                    return;
                }
            }
        }

        System.out.println("Erro -> Conta informada nao existe");


    }

}




