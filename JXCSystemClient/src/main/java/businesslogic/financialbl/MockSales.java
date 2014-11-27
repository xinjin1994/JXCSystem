package businesslogic.financialbl;

import java.util.ArrayList;

import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;

public class MockSales implements SalesInfo{
	
	ArrayList<ImportPO> arrayImp=new ArrayList<ImportPO>();
	ArrayList<ExportPO> arrayExp=new ArrayList<ExportPO>();
	ArrayList<Import_ReturnPO> arrayImp_ret=new ArrayList<Import_ReturnPO>();
	ArrayList<Export_ReturnPO> arrayExp_ret=new ArrayList<Export_ReturnPO>();

	public ArrayList<ImportPO> getAllImport() {
		// TODO Auto-generated method stub
		ImportPO po = new ImportPO("2222/2/2","name","good_name","good_type",
				"ps", "serialnum", "clerk", "operator",1,50,50, 1, 500);
		
		ArrayList<ImportPO> imp=new ArrayList<ImportPO>();
		imp.add(po);
		return imp;
	}

	public ArrayList<Import_ReturnPO> getAllImport_Return() {
		// TODO Auto-generated method stub
		Import_ReturnPO po = new Import_ReturnPO("2222/2/2","name","good_name","good_type",
				"ps", "serialnum", "clerk", "operator",1,50,50, 1, 500);
		
		ArrayList<Import_ReturnPO> imp_ret=new ArrayList<Import_ReturnPO>();
		imp_ret.add(po);
		return imp_ret;
	}

	public ArrayList<ExportPO> getAllExport() {
		// TODO Auto-generated method stub
		ExportPO po = new ExportPO("2222/2/2",300,400,300,100,"name","good_name","good_type","ps","serialnum",
				"clerk","operator",1,50,50,1,500);
		
		ArrayList<ExportPO> exp=new ArrayList<ExportPO>();
		exp.add(po);
		return exp;
	}

	public ArrayList<Export_ReturnPO> getAllExport_Return() {
		// TODO Auto-generated method stub
		Export_ReturnPO po = new Export_ReturnPO("2222/2/2",300,400,300,100,"name","good_name","good_type",
				"ps","serialnum","clerk","operator",1,50,50,1,500);
		
		ArrayList<Export_ReturnPO> exp_ret=new ArrayList<Export_ReturnPO>();
		exp_ret.add(po);
		return exp_ret;
	}

}
