import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BancoServiceTest {

	@Test
	public void testConsultarSaldo() {
		// Criando mock do repositório
		ContaRepository contaRepository = Mockito.mock(ContaRepository.class);

		// Criando conta simulada
		Conta conta = new Conta("12345", 450.0);

		// Definindo comportamento do mock
		when(contaRepository.buscarConta(eq("12345"))).thenReturn(conta);

		// Criando serviço com o mock
		BancoService bancoService = new BancoService(contaRepository);

		// Testando consulta de saldo
		double valorSaldo = bancoService.consultarSaldo("12345");

		// Verificando se o saldo está correto
		assertEquals(450.0, valorSaldo);

		// Verificando se o método buscarConta foi chamado
		verify(contaRepository).buscarConta("12345");
	}

	@Test
	public void testDepositar() {
		// Criando mock do repositório
		ContaRepository contaRepository = Mockito.mock(ContaRepository.class);

		// Criando conta simulada
		Conta conta = new Conta("12345", 450.0);

		// Definindo comportamento do mock
		when(contaRepository.buscarConta("12345")).thenReturn(conta);

		// Criando serviço com o mock
		BancoService bancoService = new BancoService(contaRepository);

		// Executando depósito
		bancoService.depositar("12345", 1000.0);

		// Verificando se o saldo foi atualizado
		assertEquals(1450.0, conta.getSaldo());

		// Verificando se os métodos foram chamados corretamente
		verify(contaRepository).buscarConta("12345");
		verify(contaRepository).salvar(conta);
	}
}