class Y {
	static char stf;
	static char right;
	static void stm() {
		X.stt();
	}

}

class Z extends Y {
	
}
class X {
	Y f;
	static Y s;
	
	Y set (Y r) {
		this.f = r;
		X.s = r;
		Z z = new Z();
		Y y, y2;
		y = this.f;
		y2 = X.s;
		return z;
	}
	
	void main() {
		Y.stm();
		char a = Y.stf;
		a = Y.stf = Y.right;
		
		X p = new X();	// o1
		Y q = new Y();	// o2
		X r = new X();
		p.set(q);
		
	}
	
	static int stt() {
		return 0;
	}
	
}
