public class BancoService {
	private ContaRepository contaRepository;

	public BancoService(ContaRepository contaRepository) {
		this.contaRepository = contaRepository;
	}

	public double consultarSaldo(String numeroConta) {
		Conta conta = contaRepository.buscarConta(numeroConta);
		return conta.getSaldo();
	}

	public void depositar(String numeroConta, double valor) {
		Conta conta = contaRepository.buscarConta(numeroConta);
		if (conta != null) {
			conta.setSaldo(conta.getSaldo() + valor);
			contaRepository.salvar(conta);
		}
	}
}
