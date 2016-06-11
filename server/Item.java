package server;

public class Item {
	int identifier;
	boolean emitsHeat;
	boolean emitsPress;
	boolean emitsLight;
	boolean isToxic;
	boolean disruptsElectro;

	public Item(int I, boolean eH, boolean eP, boolean eL, boolean iT, boolean dE) {
		this.identifier = I;
		this.emitsHeat = eH;
		this.emitsPress = eP;
		this.emitsLight = eL;
		this.isToxic = iT;
		this.disruptsElectro = dE;
	}
}
