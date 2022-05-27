package org.example;

import java.util.ArrayList;

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




}
