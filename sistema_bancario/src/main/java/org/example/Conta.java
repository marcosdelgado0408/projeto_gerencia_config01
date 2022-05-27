package org.example;

public class Conta {
    private long numeroConta;
    private double saldo;

    public Conta(){
        this.numeroConta = 0;
        this.saldo = 0.0;
    }


    public Conta(long numeroConta, float saldo){
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }


    public long getNumeroConta() {return numeroConta;}
    public void setNumeroConta(long numeroConta) {this.numeroConta = numeroConta;}

    public double getSaldo() {return saldo;}
    public void setSaldo(double saldo) {this.saldo = saldo;}

}
