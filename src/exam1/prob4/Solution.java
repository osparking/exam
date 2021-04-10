package exam1.prob4;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;


class Student {
	public void m1() {
		System.out.println("");
	}
	void m3() {}
	void m2() {}
}

public class Solution {

	public static void main(String[] args) {
        Class student = Student.class;
        Method[] methods = student.getDeclaredMethods();

        ArrayList<String> methodList = new ArrayList<>();
        for(Method method : methods){
            methodList.add(method.getName());
        }
        Collections.sort(methodList);
        for(String name: methodList){
            System.out.println(name);
        }
	}

}
