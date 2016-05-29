class Y {
}

class X {
	Y f;
	
	void set(Y r) {
		this.f = r;
	}
	
	void main() {
		X p = new X();	// o1
		Y q = new Y();	// o2
		p.set(q);
	}
}