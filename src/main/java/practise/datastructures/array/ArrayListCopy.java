package practise.datastructures.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListCopy {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		/*List<String> list1 = new ArrayList<String>();
		list1.add("A");
		list1.add("B");
		
		List<String> list2 = new ArrayList<String>(list1);
		
		list1.add("C");
		list2.add("D");
		
		System.out.println(list1);
		System.out.println(list2);*/
		
		A a = new A();
		a.x=1;
		B b = new B();
		b.y=2;
		b.z=3;
		a.b=b;
		List<A> list1 = new ArrayList<A>();
		list1.add(a);
		System.out.println(list1);
		
		List<A> list2 = new ArrayList<A>(list1);
		System.out.println(list2);
		
		List<A> list3 = new ArrayList<A>();
		for(A obj:list1) {
			list3.add((A)obj.clone());
		}
		
		
		a.x =4;
		a.b.y = 5;
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);
		
	}
	

}

class A implements Cloneable{
	int x;
	B b;
	
	@Override
	public String toString() {
		return "A [x=" + x + ", b=" + b + "]";
	}
	
	@Override
    public Object clone() throws CloneNotSupportedException{
        A clonedObj = (A) super.clone();
        B cb = (B)b.clone();
        clonedObj.b=cb;
        return clonedObj;
    }
	
}

class B implements Cloneable{
	int y;
	int z;
	
	@Override
	public String toString() {
		return "B [y=" + y + ", z=" + z + "]";
	}
	
	@Override
    public Object clone() throws CloneNotSupportedException{
        B clonedObj = (B) super.clone();
        //clonedObj.z = 0;
        return clonedObj;
    }
}
