class Y {
}

class X {
	Y f;
	
	void set(Y r) {
		this.f = r;
	}
	
	void main() {
		X p = new X();
		Y q = new Y();
		p.set(q);
	}
}

//class C extends X{
//	char m(int i) {
//		super.main();
//		return 'a';
//	}
//	
//}