package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entity.Account;
import entity.Player;
import entity.fields.Fleet;
import entity.fields.Ownable;

public class testFleet {
	private Player lander;
	private Player owner;
	private Ownable fleet1;
	private Ownable fleet2;
	private Ownable fleet3;
	private Ownable fleet4;

	@Before
	public void setUp() throws Exception {
		this.lander = new Player("Spiller1", new Account(30000));
		this.fleet1 = new Fleet("fleet1", 1, 4000);
		this.fleet2 = new Fleet("fleet2", 2, 4000);
		this.fleet3 = new Fleet("fleet3", 3, 4000);
		this.fleet4 = new Fleet("fleet4", 4, 4000);

		this.owner = new Player("Spiller2", new Account(30000));

	}

	@After
	public void tearDown() throws Exception {
		this.lander = new Player("Spiller1", new Account(30000));
		this.owner = new Player("Spiller2", new Account(30000));
	}

	// exsist test
	@Test
	public void testEntities() {
		Assert.assertNotNull(this.lander);

		Assert.assertNotNull(this.fleet1);
		Assert.assertNotNull(this.fleet2);
		Assert.assertNotNull(this.fleet3);
		Assert.assertNotNull(this.fleet4);

		Assert.assertTrue(this.fleet1 instanceof Fleet);
		Assert.assertTrue(this.fleet2 instanceof Fleet);
		Assert.assertTrue(this.fleet3 instanceof Fleet);
		Assert.assertTrue(this.fleet4 instanceof Fleet);

	}

	// lander på felt hvor ejer har 1 fleet
	@Test
	public void testOneFleet() {
		this.fleet1.setOwner(this.owner);

		int actual = this.lander.getAccount().getBalance();
		int expected = 30000;
		Assert.assertEquals(expected, actual);

		this.fleet1.landOnField(this.lander);

		actual = this.lander.getAccount().getBalance();
		expected = 29500;
		Assert.assertEquals(expected, actual);

		int actualOwner = this.owner.getAccount().getBalance();
		int ownerExpect = 30500;
		Assert.assertEquals(ownerExpect, actualOwner);

	}

	// lander på felt hvor ejer har 2 fleet

	@Test
	public void testTwoFleet() {
		this.fleet1.setOwner(this.owner);

		this.owner.addProperty(this.fleet2);

		int actual = this.lander.getAccount().getBalance();
		int expected = 30000;
		Assert.assertEquals(expected, actual);

		this.fleet1.landOnField(this.lander);

		actual = this.lander.getAccount().getBalance();
		expected = 29000;
		Assert.assertEquals(expected, actual);

		int actualOwner = this.owner.getAccount().getBalance();
		int ownerExpect = 31000;
		Assert.assertEquals(ownerExpect, actualOwner);

	}

	// lander på felt hvor ejer har 3 fleet

	@Test
	public void testThreeFleet() {
		this.fleet1.setOwner(this.owner);

		this.owner.addProperty(this.fleet2);
		this.owner.addProperty(this.fleet3);

		int actual = this.lander.getAccount().getBalance();
		int expected = 30000;
		Assert.assertEquals(expected, actual);

		this.fleet1.landOnField(this.lander);

		actual = this.lander.getAccount().getBalance();
		expected = 28000;
		Assert.assertEquals(expected, actual);

		int actualOwner = this.owner.getAccount().getBalance();
		int ownerExpect = 32000;
		Assert.assertEquals(ownerExpect, actualOwner);

	}

	// lander på felt hvor ejer har 4 fleet

	@Test
	public void testFourFleet() {
		this.fleet1.setOwner(this.owner);

		this.owner.addProperty(this.fleet2);
		this.owner.addProperty(this.fleet3);
		this.owner.addProperty(this.fleet4);

		int actual = this.lander.getAccount().getBalance();
		int expected = 30000;
		Assert.assertEquals(expected, actual);

		this.fleet1.landOnField(this.lander);

		actual = this.lander.getAccount().getBalance();
		expected = 26000;
		Assert.assertEquals(expected, actual);

		int actualOwner = this.owner.getAccount().getBalance();
		int ownerExpect = 34000;
		Assert.assertEquals(ownerExpect, actualOwner);
	}

	@Test
	public void buyTest() {
		int actual = this.lander.getAccount().getBalance();
		int expected = 30000;
		Assert.assertEquals(expected, actual);

		this.lander.buy(this.fleet1);
		this.fleet1.setOwner(this.lander);

		actual = this.lander.getAccount().getBalance();
		expected = 26000;
		Assert.assertEquals(expected, actual);

	}
}
