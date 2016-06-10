package server;

public class Thing {
	private int identifier;
	private boolean blocksPath;
	private boolean emitsLight;
	private boolean reflectsLight;
	private boolean emitsPressure;
	private int purpleness;
	private boolean emitsHeat;
	private boolean isBreathable;
	private boolean gasPhysics;
	private boolean isToxic;
	private boolean isLiquid;
	int x;
	int y;

	public Thing(int I, boolean B, boolean eL, boolean rL, boolean eP, int P, boolean eH, boolean iB, boolean gP,
			boolean iT, boolean iL, int X, int Y) {
		this.identifier = I;
		this.blocksPath = B;
		this.emitsLight = eL;
		this.reflectsLight = rL;
		this.emitsPressure = eP;
		this.purpleness = P;
		this.emitsHeat = eH;
		this.isBreathable = iB;
		this.gasPhysics = gP;
		this.isToxic = iT;
		this.isLiquid = iL;
		this.x = X;
		this.y = Y;
	}
}
