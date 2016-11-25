package entity;

public class Cup {
	private Dice d1;
	private Dice d2;

	public Cup(Dice tern1, Dice tern2) {
		d1 = tern1;
		d2 = tern2;
	}

	// Henter facevalues fra terning.
	public int[] values() {
		int[] values = { d1.getValue(), d2.getValue() };
		return values;
	}

	// Ruller terningerne.
	public int[] rollAll() {
		int[] values = { d1.roll(), d2.roll() };
		return values;
	}

	// Henter summen af terningernes facevalues.
	public int getSum() {
		return d1.getValue() + d2.getValue();
	}
/* Bruges i et matador spil 
	public boolean isPair() {
		return d1.getValue() == d2.getValue();
	}

	public boolean isPair(int n) {
		return d1.getValue() == d2.getValue() && d1.getValue() == n;
	}
*/
}
