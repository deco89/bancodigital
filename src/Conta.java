public abstract class Conta implements IConta { //abstract garante que ninguem possa instanciar a classe sem informar qual tipo de conta;

  private static final int AGENCIA_PADRAO = 1;

  private static int SEQUENCIAL = 1;


  protected int agencia;
  protected int numero;
  protected double chequeEspecial;
  protected double saldo;
  protected Cliente cliente;
  protected double saldoTotal;

  public Conta(Cliente cliente) {
    this.agencia = Conta.AGENCIA_PADRAO;
    this.numero = SEQUENCIAL++;;
    this.cliente = cliente;
  }

  @Override
  public void sacar(double valor) {
    if(valor > saldo) {
      double diferenca = valor - saldo;
      System.out.printf("Você está usando R$ %.2f do seu cheque especial.\n", diferenca);
    }
    saldo -= valor;
  }

  @Override
  public void depositar(double valor) {
    saldo += valor;
  }

  @Override
  public void transferir(double valor, Conta contaDestino) {
    if(valor > saldo) {
      System.out.println("Você não possui saldo o suficiente. Seu saldo é de: " + saldo);
    } else {
    this.sacar(valor);
    contaDestino.depositar(valor);
    }
  }

  public void utilizacaoChequeEspecial(double valor) {
    saldoTotal = saldo + chequeEspecial;
    if(valor <= saldoTotal) {
      saldoTotal -= valor;
    }
  }

  protected void imprimirInfoComuns() {
    System.out.println(String.format("Titular: %s", this.cliente.getName()));
    System.out.println(String.format("Numero: %d", this.numero));
    System.out.println(String.format("Saldo: R$%.2f", this.saldo));
  }

  public int getAgencia() {
    return agencia;
  }

  public int getNumero() {
    return numero;
  }

  public double getSaldo() {
    return saldo;
  }
}
