package org.example;

public class Conta {

    private long numeroConta;
    private double saldo;
    private String tipoDeConta;
    private int pontuacao;

    public Conta(){
        this.numeroConta = 0;
        this.saldo = 0.0;
        this.tipoDeConta = "null";
        pontuacao = 0;
    }

    public Conta(long numeroConta, double saldo, String tipoDeConta){
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.tipoDeConta = tipoDeConta;
    }

    public Conta(long numeroConta, double saldo, String tipoDeConta, int pontuacao){
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.tipoDeConta = tipoDeConta;
        this.pontuacao = pontuacao;
    }


    public String getTipoDeConta() {return tipoDeConta;}
    public void setTipoDeConta(String tipoDeConta) {this.tipoDeConta = tipoDeConta;}

    public int getPontuacao() {return pontuacao;}
    public void setPontuacao(int pontuacao) {this.pontuacao = pontuacao;}

    public long getNumeroConta() {return numeroConta;}
    public void setNumeroConta(long numeroConta) {this.numeroConta = numeroConta;}

    public double getSaldo() {return saldo;}
    public void setSaldo(double saldo) {this.saldo = saldo;}

    @Override
    public String toString() {
        return "{" +  numeroConta + " -> " + saldo + " | " + pontuacao + "}";
    }
}
