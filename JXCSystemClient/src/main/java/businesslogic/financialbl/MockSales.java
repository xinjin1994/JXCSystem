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

	public ImportPO[] getAllImport() {
		// TODO Auto-generated method stub
		ImportPO po = new ImportPO("2222/2/2","name","good_name","good_type",
				"ps", "serialnum", "clerk", "operator",1,50,50, 1, 500);
		
		ImportPO[] imp=new ImportPO[1];
		imp[0]=po;
		return imp;
	}

	public Import_ReturnPO[] getAllImport_Return() {
		// TODO Auto-generated method stub
		Import_ReturnPO po = new Import_ReturnPO("2222/2/2","name","good_name","good_type",
				"ps", "serialnum", "clerk", "operator",1,50,50, 1, 500);
		
		Import_ReturnPO[] imp_ret=new Import_ReturnPO[1];
		imp_ret[0]=po;
		return imp_ret;
	}

	public ExportPO[] getAllExport() {
		// TODO Auto-generated method stub
		ExportPO po = new ExportPO("2222/2/2",300,400,300,100,"name","good_name","good_type","ps","serialnum",
				"clerk","operator",1,50,50,1,500);
		
		ExportPO[] exp=new ExportPO[1];
		exp[0]=po;
		return exp;
	}

	public Export_ReturnPO[] getAllExport_Return() {
		// TODO Auto-generated method stub
		Export_ReturnPO po = new Export_ReturnPO("2222/2/2",300,400,300,100,"name","good_name","good_type",
				"ps","serialnum","clerk","operator",1,50,50,1,500);
		
		Export_ReturnPO[] exp_ret=new Export_ReturnPO[1];
		exp_ret[0]=po;
		return exp_ret;
	}

}
