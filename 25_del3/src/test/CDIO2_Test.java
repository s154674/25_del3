package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import entity.Account;

public class CDIO2_Test {
	Account account;

	@Before
	public void before() throws Exception {
		account = new Account(1000);
	}

	@Test
	public void testGetBalance() {
		assertEquals(1000, account.getBalance());
	}

	@Test
	public void testAddGold() {
		account.deposit(300);
		assertEquals(1300, account.getBalance());
	}

	@Test
	public void testWithdrawGold() {
		account.deposit(-500);
		assertEquals(500, account.getBalance());
	}

	@Test
	public void testNotNegative() {
		account.deposit(-5000);
		assertEquals(0, account.getBalance());
	}

	@Test
	public void testOverflow() {
		account.deposit(100000000);
		assertEquals(100001000, account.getBalance());
	}

	@Test
	public void testBalanceAfterBroke() {
		account.deposit(-1100);
		assertEquals(0, account.getBalance());
		account.deposit(100);
		assertEquals(100, account.getBalance());
	}

}
