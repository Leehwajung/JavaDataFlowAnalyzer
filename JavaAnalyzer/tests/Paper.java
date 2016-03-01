class Y {
	
}

class X {
	Y f;
	
	void set (Y r) {
		this.f = r;
	}
	
	void main() {
		X p = new X();	// o1
		Y q = new Y();	// o2
		p.set(q);
	}
}


class Box<E> {
	E elem;

	E get() {
		return elem;
	}

	void set(E elem) {
		this.get(); // this의 타입은? this:Box<E> ===> this:Box<E>{Xi}

		Box<E> boxe = new Box<E>(); // o3
		Box<String> boxstr = new Box<String>(); // o4
		if (true) {

		}

		Box2<Integer> box2 = new Box2<>();

		Box<Long> boxl = new Box<>();
		isEmpty(boxl);

		isEmpty(boxstr);
		
		
		
	}

	<G> boolean isEmpty(Box<G> box) {
		return true;
	}

	class Box2<F> {
		int aaaaa (){
			Box<X> aaa = new Box<>();
			mtd(aaa);
			X x = new X();
			md(x, 1);
			return 1;
		}
		
		/**
		 * 
		 * @param box
		 * @return
		 */
		<H extends X> boolean mtd(Box<H> box) {
			return true;
		}
		
		<J extends X> int md(J jx, int qer) {
			return 1;
		}
	}
}