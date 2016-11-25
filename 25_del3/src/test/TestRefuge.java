package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entity.Account;
import entity.Player;
import entity.fields.Field;
import entity.fields.Refuge;

public class TestRefuge {

	private Player player;
	private Field refuge500;
	private Field refuge5000;

	// Oprætter en spiller og de relevante fields
	@Before
	public void setUp() throws Exception {
		this.player = new Player("Spiller1", new Account(500));
		this.refuge500 = new Refuge("Refuge500", 1, 500);
		this.refuge5000 = new Refuge("Refuge500", 2, 5000);
	}

	// The fields are unaltered
	@After
	public void tearDown() throws Exception {
		this.player = new Player("Spiller1", new Account(500));
	}

	// Test at de opreættede entities eksitere
	@Test
	public void testEntities() {
		Assert.assertNotNull(this.player);

		Assert.assertNotNull(this.refuge500);
		Assert.assertNotNull(this.refuge5000);

		Assert.assertTrue(this.refuge500 instanceof Refuge);
		Assert.assertTrue(this.refuge5000 instanceof Refuge);
	}

	// Test af det refuge some giver 500.
	@Test
	public void testLandOnFieldRefuge500() {
		int actual = this.player.getAccount().getBalance();
		int expected = 500;
		Assert.assertEquals(expected, actual);

		this.refuge500.landOnField(this.player);

		expected = 500 + 500;
		actual = this.player.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}

	// Test af det refuge some giver 5000.
	@Test
	public void testLandOnFieldRefuge5000() {
		int actual = this.player.getAccount().getBalance();
		int expected = 500;
		Assert.assertEquals(expected, actual);

		this.refuge5000.landOnField(this.player);

		expected = 5000 + 500;
		actual = this.player.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}

	// Test af det refuge some giver 5000 to gange i træk.
	@Test
	public void testLandOnFieldRefuge5000Twice() {
		int actual = this.player.getAccount().getBalance();
		int expected = 500;
		Assert.assertEquals(expected, actual);

		this.refuge5000.landOnField(this.player);
		this.refuge5000.landOnField(this.player);

		expected = 5000 + 5000 + 500;
		actual = this.player.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}

	// Test af det refuge some giver 500 to gange i træk.
	@Test
	public void testLandOnFieldRefuge500Twice() {
		int actual = this.player.getAccount().getBalance();
		int expected = 500;
		Assert.assertEquals(expected, actual);

		this.refuge500.landOnField(this.player);
		this.refuge500.landOnField(this.player);

		expected = 500 + 500 + 500;
		actual = this.player.getAccount().getBalance();
		Assert.assertEquals(expected, actual);
	}

}
