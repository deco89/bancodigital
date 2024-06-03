public class Main {

  public static void main(String[] args) {
    Cliente andre = new Cliente();
    andre.setName("Andre");

    Cliente joao = new Cliente();
    joao.setName("Joao");

    Conta cc1 = new ContaCorrente(andre);
    Conta poupanca1 = new ContaPoupanca(andre);
    cc1.depositar(70);
    cc1.sacar(80);

    cc1.imprimirExtrato();
    poupanca1.imprimirExtrato();

  }

}
