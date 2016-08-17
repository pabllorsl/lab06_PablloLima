package lp2.lab06;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

	private Usuario pabllo;
	private Jogo overwatch;

	@Before
	public void setUp() throws Exception {
		pabllo = new Usuario("Pabllo", "pabllo.lima");
		overwatch = new Jogo("Overwatch", 159.99);
	}

	@Test
	public void testConstrutor() {
		try {
			assertEquals("Pabllo", pabllo.getNome());
			assertEquals("pabllo.lima", pabllo.getLogin());
			assertTrue(pabllo.getJogosComprados().isEmpty());
			assertEquals(0.0, pabllo.getSaldo(), 0.05);
			assertEquals(0.0, pabllo.getDesconto(), 0.05);
		} catch (Exception e) {
			fail("Nao deveria ter lancado Exception");
		}
	}

	@Test
	public void testConstrutorWithException() {
		try {
			new Usuario(null, "pabllo.lima");
			fail("Deveria ter lancado uma Exception de nome nulo");
		} catch (Exception e) {
			assertEquals("Nome nao pode ser nulo.", e.getMessage());
		}

		try {
			new Usuario("", "pabllo.lima");
			fail("Deveria ter lancado uma Exception de nome vazio");
		} catch (Exception e) {
			assertEquals("Nome nao pode ser vazio.", e.getMessage());
		}

		try {
			new Usuario("Pabllo", null);
			fail("Deveria ter lancado uma Exception de login nulo");
		} catch (Exception e) {
			assertEquals("Login nao pode ser nulo.", e.getMessage());
		}

		try {
			new Usuario("Pabllo", "");
			fail("Deveria ter lancado uma Exception de login vazio");
		} catch (Exception e) {
			assertEquals("Login nao pode ser vazio.", e.getMessage());
		}
	}

	@Test
	public void testCompraJogoSemSaldo() {
		try {
			pabllo.compraJogo(overwatch);
			fail("Deveria ter lancado uma Exception de saldo insuficiente");
		} catch (Exception e) {
			assertEquals("Saldo insuficiente para comprar o jogo.", e.getMessage());
		}
	}

	@Test
	public void testAdicionaDinheiroInvalido() {
		try {
			pabllo.adicionaDinheiro(0);
			fail("Deveria ter lancado uma Exception de valor igual a zero.");
		} catch (Exception e) {
			assertEquals("Valor nao pode ser igual a zero.", e.getMessage());
		}

		try {
			pabllo.adicionaDinheiro(-100);
			fail("Deveria ter lancado uma Exception de valor negativo");
		} catch (Exception e) {
			assertEquals("Valor nao pode ser negativo.", e.getMessage());
		}
	}

	@Test
	public void testCompraJogoComSaldo() {
		try {
			assertEquals(true, pabllo.adicionaDinheiro(200));
			assertEquals(200, pabllo.getSaldo(), 0.05);
			assertEquals(true, pabllo.compraJogo(overwatch));
			assertEquals(40.01, pabllo.getSaldo(), 0.05);
			assertTrue(pabllo.getJogosComprados().contains(overwatch));
		} catch (Exception e) {
			fail("Nao deveria ter lancado Exception");
		}
	}

	@Test
	public void testEquals() {
		try {
			assertEquals(pabllo, pabllo);

			Usuario pablloXara = new Usuario("Pabllo", "pabllo.alves");
			assertNotEquals(pabllo, pablloXara);

			Usuario fabiana = new Usuario("Fabiana", "fabiana.alves");
			assertNotEquals(pabllo, fabiana);
		} catch (Exception e) {
			fail("Nao deveria ter lancado Exception");
		}
	}

	@Test
	public void testToString() {
		assertEquals("Usuario [nome=Pabllo, login=pabllo.lima, jogosComprados=[], saldo=0.0]", pabllo.toString());
	}

}
