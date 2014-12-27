package test;

import java.util.Vector;

import businesslogic.financialbl.Excel;

public class TestExcel {
	
	public static void main(String[] args){
		
		Excel exc=new Excel();
		
		String[] a={"0","1","2","3","4","5","6","7","8","9"};
		String[] title={"0t","1t","2t","3t","4t","5t","6t","7t","8t","9t"};
		
		Vector<String[]> vec=new Vector<String[]>(1,1);
		vec.add(title);
		vec.addElement(a);
		
		String pla="E://test";
		
		exc.output(vec, pla);
		
		
	}

}
