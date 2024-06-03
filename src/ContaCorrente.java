public class ContaCorrente extends Conta {

  public static final int VALOR_CHEQUE_ESPECIAL = 100;

  public ContaCorrente(Cliente cliente) {
    super(cliente);
    this.chequeEspecial = ContaCorrente.VALOR_CHEQUE_ESPECIAL;
  }

  @Override
  public void imprimirExtrato() {
    System.out.println("=== Extrato Conta Corrente ===");
    super.imprimirInfoComuns();
  }
}
