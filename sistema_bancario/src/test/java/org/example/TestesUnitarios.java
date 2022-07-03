package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestesUnitarios {

    ArrayList<Conta> contas = new ArrayList<>();

    @Test
    public void testeAddCreditoNormal(){
        contas.add(new Conta(2105, 2000, "normal")); // conta normal inicial com saldo de 2000
        Features.setContas(contas);

        Features.addCredito(2105,100);

        for(Conta conta: Features.getContas()){
            if(conta.getNumeroConta() == 2105){
                Assertions.assertEquals(2100, conta.getSaldo());
            }
        }
    }

    @Test
    public void testAddCreditoBonus(){
        contas.add(new Conta(2106, 0.0, "bonus", 10));
        Features.setContas(contas);

        Features.addCredito(2106, 100);

        for(Conta conta: Features.getContas()){
            if(conta.getNumeroConta() == 2106){
                Assertions.assertEquals(100, conta.getSaldo());
                Assertions.assertEquals(11, conta.getPontuacao());
            }
        }
    }

    @Test
    public void testAddCreditoPoupanca(){
        contas.add(new Conta(2105, 2000, "poupanca"));
        Features.setContas(contas);

        Features.addCredito(2105, 100);

        for(Conta conta: Features.getContas()){
            if(conta.getNumeroConta() == 2105){
                Assertions.assertEquals(2100, conta.getSaldo());
            }
        }
    }

    @Test
    public void testDebitarNormal(){
        contas.add(new Conta(2107, 2000, "normal")); // conta normal inicial com saldo de 2000
        Features.setContas(contas);

        Features.debitarValor(2107, 100);

        for(Conta conta: Features.getContas()){
            if(conta.getNumeroConta() == 2107){
                Assertions.assertEquals(1900, conta.getSaldo());
            }
        }
    }

    @Test
    public void testDebitarPoupanca(){
        contas.add(new Conta(2108, 2000, "poupanca")); // conta normal inicial com saldo de 2000
        Features.setContas(contas);

        Features.debitarValor(2108, 100);

        for(Conta conta: Features.getContas()){
            if(conta.getNumeroConta() == 2108){
                Assertions.assertEquals(1900, conta.getSaldo());
            }
        }

    }

    @Test
    public void testDebitarBonus(){
        contas.add(new Conta(2106, 200, "bonus", 10));
        Features.setContas(contas);

        Features.debitarValor(2106, 100);
        for(Conta conta: Features.getContas()){
            if(conta.getNumeroConta() == 2106){
                Assertions.assertEquals(100, conta.getSaldo());
                Assertions.assertEquals(10, conta.getPontuacao());
            }
        }

    }



    @Test
    public void testTransferirNormalParaNormal(){

        contas.clear();
        contas.add(new Conta(2105, 2000, "normal"));
        contas.add(new Conta(2106, 2000, "normal"));
        Features.setContas(contas);

        Features.transferir(2105, 2106, 200);


        for(Conta conta: Features.getContas()){
            if (conta.getNumeroConta() == 2105) {
                Assertions.assertEquals(1800, conta.getSaldo());
            }
            if (conta.getNumeroConta() == 2106) {
                Assertions.assertEquals(2200, conta.getSaldo());
            }
        }
    }

    @Test
    public void testTransferirNormalParaBonus(){
        /*
         * 2105 -> 1900
         * 2106 -> 100 | 1
         * -------------
         * resultado
         * 2105 -> 1700
         * 2106 -> 300 | 2
         */

        contas.clear();
        contas.add(new Conta(2105, 2000, "normal"));
        contas.add(new Conta(2106, 0.0, "bonus", 10));
        Features.setContas(contas);

        Features.transferir(2105, 2106, 200);

        for(Conta conta: Features.getContas()){
            if (conta.getNumeroConta() == 2105) {
                Assertions.assertEquals(1800, conta.getSaldo());
            }
            if (conta.getNumeroConta() == 2106) {
                Assertions.assertEquals(200, conta.getSaldo());
                Assertions.assertEquals(11, conta.getPontuacao());
            }
        }
    }

    @Test
    public void testTransferirPoupancaParaNormal(){
        /*
        * 2108 -> 1900
        * 2105 -> 1700
        * -------------
        *
        * 2108 -> 1800
        * 2105 -> 1800
        *
        */
        contas.clear();
        contas.add(new Conta(2105, 2000, "poupanca"));
        contas.add(new Conta(2106, 2000, "normal"));
        Features.setContas(contas);


        Features.transferir(2105, 2106, 200);

        for(Conta conta: Features.getContas()){
            if (conta.getNumeroConta() == 2105) {
                Assertions.assertEquals(1800, conta.getSaldo());
            }
            if (conta.getNumeroConta() == 2106) {
                Assertions.assertEquals(2200, conta.getSaldo());
            }
        }

    }





    @Test
    public void testTransferirPoupancaParaBonus(){
        /*
         * 2108 -> 1800
         * 2106 -> 300 | 2
         * -------------
         *
         * 2108 -> 1600
         * 2106 -> 500 | 3
         *
         */

        contas.clear();
        contas.add(new Conta(2105, 2000, "poupanca"));
        contas.add(new Conta(2106, 0.0, "bonus", 10));
        Features.setContas(contas);

        Features.transferir(2105, 2106, 200);

        for(Conta conta: Features.getContas()){
            if (conta.getNumeroConta() == 2105) {
                Assertions.assertEquals(1800, conta.getSaldo());
            }
            if (conta.getNumeroConta() == 2106) {
                Assertions.assertEquals(200, conta.getSaldo());
                Assertions.assertEquals(11, conta.getPontuacao());
            }
        }

    }

    @Test
    public void testTransferirBonusParaNormal(){
        contas.clear();
        contas.add(new Conta(2105, 1000, "bonus", 10));
        contas.add(new Conta(2106, 1000, "normal"));
        Features.setContas(contas);

        Features.transferir(2105, 2106, 200);

        for(Conta conta: Features.getContas()){
            if (conta.getNumeroConta() == 2105) {
                Assertions.assertEquals(800, conta.getSaldo());
                Assertions.assertEquals(10, conta.getPontuacao());
            }
            if (conta.getNumeroConta() == 2106) {
                Assertions.assertEquals(1200, conta.getSaldo());
            }
        }

    }

    @Test
    public void testTransferirBonusParaPoupanca(){
        contas.clear();
        contas.add(new Conta(2105, 1000, "bonus", 10));
        contas.add(new Conta(2106, 1000, "poupanca"));
        Features.setContas(contas);

        Features.transferir(2105, 2106, 200);

        for(Conta conta: Features.getContas()){
            if (conta.getNumeroConta() == 2105) {
                Assertions.assertEquals(800, conta.getSaldo());
                Assertions.assertEquals(10, conta.getPontuacao());
            }
            if (conta.getNumeroConta() == 2106) {
                Assertions.assertEquals(1200, conta.getSaldo());
            }
        }
    }


    @Test
    public void testRenderJuros(){
        contas.clear();
        contas.add(new Conta(2105, 1000, "poupanca"));
        Features.setContas(contas);

        Features.renderJuros(2105, 50); // quero que renda 50%

        for(Conta conta: contas){
            if(conta.getNumeroConta() == 2105){
                Assertions.assertEquals(1500, conta.getSaldo());
            }
        }

    }


}
