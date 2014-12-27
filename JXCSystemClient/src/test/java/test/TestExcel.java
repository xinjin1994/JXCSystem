package test;

import businesslogic.financialbl.Excel;

public class TestExcel {
	
	public static void main(String[] args){
		
		Excel exc=new Excel();
		
		String[][] a=new String[2][10];
		
		a[0][0]="0t";
		a[0][1]="1t";
		a[0][2]="2t";
		a[0][3]="3t";
		a[0][4]="4t";
		a[0][5]="5t";
		a[0][6]="6t";
		a[0][7]="7t";
		a[0][8]="8t";
		a[0][9]="9t";
		
		a[1][0]="0";
		a[1][1]="1";
		a[1][2]="2";
		a[1][3]="3";
		a[1][4]="4";
		a[1][5]="5";
		a[1][6]="6";
		a[1][7]="7";
		a[1][8]="8";
		a[1][9]="9";
		
		String pla="E://text.xls";
		
		exc.output(a, pla);
		
		
	}

}
