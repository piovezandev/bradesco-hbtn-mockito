import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculadoraTest {

	private ServicoMatematico servicoMatematico;
	private Calculadora calculadora;

	@BeforeEach
	public void setUp() {
		servicoMatematico = Mockito.mock(ServicoMatematico.class);
		calculadora = new Calculadora(servicoMatematico);
	}

	@Test
	public void shouldSomar() {
		when(servicoMatematico.somar(eq(2), eq(3))).thenReturn(5);

		int resultado = calculadora.calcularSoma(2, 3);

		assertEquals(5, resultado);
	}
}
