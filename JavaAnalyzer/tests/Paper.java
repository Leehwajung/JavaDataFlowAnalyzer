class Y {
	
}

class X {
	Y f;
	
	void set (Y r) {
		this.f = r;
	}
	
	void main() {
		X p = new X();
		Y q = new Y();
		p.set(q);
	}
}


class Box<E> {
    E elem;
    E get() {return elem;}
    void set(E elem) { 
            this.get(); // this의 타입은?    this:Box<E>  ===>    this:Box<E>{Xi}

            Box<E> boxe = new Box<E>();   // o1
            Box<String> boxstr = new Box<String>();   // o2
         }

    <G> boolean isEmpty(Box<G> box) {return true;}
    
    class Box2<E> {
    	<E> boolean isEmpty(Box<E> box) {return true;}
    }
 }        