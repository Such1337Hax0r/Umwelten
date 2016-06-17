package server;

public class Thing {
	int identifier;
	boolean blocksPath;
	boolean emitsLight;
	boolean reflectsLight;
	boolean emitsPressure;
	int purpleness;
	boolean emitsHeat;
	boolean isBreathable;
	boolean gasPhysics;
	boolean isToxic;
	boolean isLiquid;
	boolean isEdible;
	int x;
	int y;
	int Pain;

	public Thing(int I, boolean B, boolean eL, boolean rL, boolean eP, int P, boolean eH, boolean iB, boolean gP,
			boolean iT, boolean iL, boolean iE, int X, int Y) {
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
		this.isEdible = iE;
		this.x = X;
		this.y = Y;
	}
}
