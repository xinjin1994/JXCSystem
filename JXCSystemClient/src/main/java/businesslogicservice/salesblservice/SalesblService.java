package businesslogicservice.salesblservice;

import java.util.ArrayList;

import vo.CustomerVO;
import vo.ExportMenuVO;
import vo.ImportMenuVO;

public interface SalesblService {
	
	//添加客户
	public int addCustomer(CustomerVO customerVO);
	
	//删除客户
	public int delCustomer(CustomerVO customerVO);
	
	//修改客户
	public int updateCustomer(CustomerVO customerVO);
	
	//查找客户
	public ArrayList<CustomerVO> searchCustomer(CustomerVO customerVO);
	
	//添加进货单
	public int addImport(ImportMenuVO importMenuVO);
	
	//添加进货退货单
	public int addImport_Return(ImportMenuVO importMenuVO);
	
	//添加销售单
	public int addExport(ExportMenuVO exportMenuVO);
	
	//添加销售退货单
	public int addExport_Return(ExportMenuVO exportMenuVO);
	
}
