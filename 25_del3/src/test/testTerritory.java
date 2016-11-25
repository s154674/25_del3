package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entity.Account;
import entity.Player;
import entity.fields.Ownable;
import entity.fields.Territory;

public class testTerritory {

	private Player lander;
	private Player owner;
	private Ownable territory1000;
	private Ownable territory1500;
	private Ownable territory4000;

	@Before
	public void setUp() throws Exception {
		this.lander = new Player("Spiller1", new Account(30000));
		this.owner = new Player("Spiller2", new Account(30000));

		this.territory1000 = new Territory("territory1", 1, 1000, 100);
		this.territory1500 = new Territory("territory2", 2, 1500, 300);
		this.territory4000 = new Territory("territory2", 3, 4000, 1000);
	}

	@Test
	public void testEntities() {
		Assert.assertNotNull(this.lander);

		Assert.assertNotNull(this.territory1000);
		Assert.assertNotNull(this.territory1500);
		Assert.assertNotNull(this.territory4000);

		Assert.assertTrue(this.territory1000 instanceof Territory);
		Assert.assertTrue(this.territory1500 instanceof Territory);
		Assert.assertTrue(this.territory4000 instanceof Territory);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBuyTerritory() {
		int actual = this.lander.getAccount().getBalance();
		int expected = 30000;
		Assert.assertEquals(expected, actual);

		this.lander.buy(this.territory1000);
		this.territory1000.setOwner(this.lander);

		actual = this.lander.getAccount().getBalance();
		expected = 29000;
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testLandOnTerritory() {
		this.territory4000.setOwner(this.owner);

		int actual = this.lander.getAccount().getBalance();
		int expected = 30000;
		Assert.assertEquals(expected, actual);

		this.territory4000.landOnField(this.lander);

		actual = this.lander.getAccount().getBalance();
		expected = 29000;
		Assert.assertEquals(expected, actual);

		int actualOwner = this.owner.getAccount().getBalance();
		int ownerExpect = 31000;
		Assert.assertEquals(ownerExpect, actualOwner);
	}

}
