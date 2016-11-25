package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import entity.Dice;

public class CDIO1_Test {
	// Tester om en terning slår noget den ikke skal kunne slå
	@Test
	public void testDiceLimit() {
		Dice d = new Dice();

		// Kast terningen en masse gange og test
		int numThrows = 60000;
		for (int i = 0; i < numThrows; i++) {
			d.roll();
			if (d.getValue() < 1 || 6 < d.getValue()) {
				fail("Terningen skal slå mellem 1 og 6, den slog " + d.getValue());
			}
		}
	}

	// Tester om en terning slår ca. lige mange af hvert tal mellem 1 og 6.
	@Test
	public void testDistributionSingle() {
		Dice d = new Dice();

		// Kast terningen en masse gange og gem værdierne
		int[] terningKast = new int[6];
		int numThrows = 60000;
		for (int i = 0; i < numThrows; i++) {
			terningKast[d.roll() - 1]++;
		}

		// Kig resultaterne over og se om der er for mange eller får få af noget
		int deviation = numThrows / 200; // afvigelse på 0.5procent
		for (int j = 0; j < terningKast.length; j++) {
			assertEquals(10000, terningKast[j], deviation);
		}
	}

	// Tester om to terninger slår ca. lige mange af hvert tal mellem 2 og 12.
	@Test
	public void testDistributionDouble() {
		Dice d1 = new Dice();
		Dice d2 = new Dice();

		// Kast terningen en masse gange og gem værdierne
		int[] terningKast = new int[12];
		int numThrows = 60000;
		for (int i = 0; i < numThrows; i++) {
			terningKast[d1.roll() + d2.roll() - 1]++;
		}

		// Kig resultaterne over og se om der er for mange eller får få af noget
		int deviation = numThrows / 200; // Vi vælger en afvigelse på 0.5procent
		assertEquals((1.0 / 36) * numThrows, terningKast[1], deviation); // 2
		assertEquals((2.0 / 36) * numThrows, terningKast[2], deviation); // 3
		assertEquals((3.0 / 36) * numThrows, terningKast[3], deviation); // 4
		assertEquals((4.0 / 36) * numThrows, terningKast[4], deviation); // 5
		assertEquals((5.0 / 36) * numThrows, terningKast[5], deviation); // 6
		assertEquals((6.0 / 36) * numThrows, terningKast[6], deviation); // 7
		assertEquals((5.0 / 36) * numThrows, terningKast[7], deviation); // 8
		assertEquals((4.0 / 36) * numThrows, terningKast[8], deviation); // 9
		assertEquals((3.0 / 36) * numThrows, terningKast[9], deviation); // 10
		assertEquals((2.0 / 36) * numThrows, terningKast[10], deviation);// 11
		assertEquals((1.0 / 36) * numThrows, terningKast[11], deviation);// 12
	}

	// Tester om antallet af par kastet passer med den teoretiske sandsynlighed
	@Test
	public void testPairFrequency() {
		Dice d1 = new Dice();
		Dice d2 = new Dice();

		// Kast terningen en masse gange og tæl par
		int pairs = 0;
		int numThrows = 60000;
		for (int i = 0; i < numThrows; i++) {
			if (d1.roll() == d2.roll()) {
				pairs++;
			}
		}
		// Kontrollerer mod sandsynlighed
		assertEquals(numThrows / 6, pairs, Math.sqrt(numThrows));
	}

}