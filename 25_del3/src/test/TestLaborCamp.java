package test;

import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entity.Account;
import entity.Player;
import entity.fields.LaborCamp;
import entity.fields.Ownable;

public class TestLaborCamp {
	private Player lander;
	private Player owner;
	private Ownable labourCamp1;
	private Ownable labourCamp2;

	@Before
	public void setUp() throws Exception {
		this.lander = new Player("Spiller1", new Account(30000));
		this.labourCamp1 = new LaborCamp("labourcamp1", 1, 2500, 100);
		this.labourCamp2 = new LaborCamp("labourcamp2", 2, 2500, 100);

		this.owner = new Player("Spiller2", new Account(35000));

	}

	@Test
	public void testEntities() {
		Assert.assertNotNull(this.lander);

		Assert.assertNotNull(this.labourCamp1);
		Assert.assertNotNull(this.labourCamp2);

		Assert.assertTrue(this.labourCamp1 instanceof LaborCamp);
		Assert.assertTrue(this.labourCamp2 instanceof LaborCamp);
	}

	@After
	public void tearDown() throws Exception {
		this.lander = new Player("Spiller1", new Account(30000));
		this.owner = new Player("Spiller", new Account(35000));

	}

	@Test
	public void testLandOnLaborCampOneOwned() {
		this.labourCamp1.setOwner(this.owner);
		this.owner.addProperty(this.labourCamp1);

		int actual = this.lander.getAccount().getBalance();
		int expected = 30000;
		Assert.assertEquals(expected, actual);

		this.labourCamp1.landOnField(this.lander);

		int expectedArray[] = { 29800, 29700, 29600, 29500, 29400, 29300, 29200, 29100, 29000, 28900, 28800 };
		actual = this.lander.getAccount().getBalance();

		Assert.assertTrue(Arrays.asList(expectedArray).contains(actual));

	}

	@Test
	public void testLandOnLaborCampTwoOwned() {
		this.labourCamp1.setOwner(this.owner);
		this.labourCamp2.setOwner(this.owner);

		this.owner.addProperty(this.labourCamp1);
		this.owner.addProperty(this.labourCamp2);

		int actual = this.lander.getAccount().getBalance();
		int expected = 30000;
		Assert.assertEquals(expected, actual);

		this.labourCamp1.landOnField(this.lander);

		actual = this.lander.getAccount().getBalance();
		expected = 30000;
		Assert.assertSame(expected, actual);
	}

	@Test
	public void buyTest() {
		int actual = this.lander.getAccount().getBalance();
		int expected = 30000;
		Assert.assertEquals(expected, actual);

		this.lander.buy(this.labourCamp1);
		this.labourCamp1.setOwner(this.lander);

		actual = this.lander.getAccount().getBalance();
		expected = 27500;
		Assert.assertEquals(expected, actual);

	}
}
