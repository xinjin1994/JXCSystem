package businesslogic.commoditybl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CommodityPO;
import po.ExportPO;
import po.Export_ReturnPO;
import po.ImportPO;
import po.Import_ReturnPO;
import po.PatchPO;
import po.SendGiftPO;
import po.SortPO;
import po.WarnPO;
import vo.ExamineVO;
import vo.StockVO;
import businesslogic.userbl.User;
import data.commoditydata.CommodityDataService_Stub;
import dataservice.commoditydataservice.CommodityDataService;


//-1 未知错误
//1  商品已存在
//2  商品不存在
//3  分类已存在
//4  分类不存在
//5  分类中存在商品，不能删除
//6  商品数量不足，不能添加为赠品
//7  赠品数量不足，不能删除
//8  商品数量不能为负
//9  分类中存在分类，无法添加商品
//10 分类中存在商品，无法添加分类
//11 分类中存在分类，无法删除分类

public class Commodity implements businesslogic.financialbl.CommodityInfo,
				businesslogic.invoicebl.CommodityInfo, businesslogic.salesbl.CommodityInfo{
	
	public InvoiceInfo invoice;
	public SystemlogInfo systemlog;
	public SalesInfo sales;
	public CommodityDataService sto=new CommodityDataService_Stub();
	
	
	public void setInfo(InvoiceInfo invoice,SystemlogInfo systemlog,SalesInfo sales){
		this.invoice=invoice;
		this.systemlog=systemlog;
		this.sales=sales;
	}

	public int addCommodity(CommodityPO po1,SortPO po2) {
		// TODO Auto-generated method stub
		int i=0;
		
		try {
			
			ArrayList<CommodityPO> po=sto.getAll();
			
			for(i=0;i<po.size();i++){
				if(po.get(i).getName().equals(po1.getName())&&po.get(i).getType().equals(po1.getType())){
					return 1;
				}
			}
			
			SortPO sort=findSort(po2.name);
			
			if(sort==null){
				return 4;
			}
			
			if(sort.hasSort()){
				return 9;
			}
			
			po1.father=po2.getName();
			
			if (sto.addGood(po1,po2)) {
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}

	public int delCommodity(String name, String type) {
		int i=0;
		
		try {
			
			ArrayList<CommodityPO> po=sto.getAll();
			
			for(i=0;i<po.size();i++){
				if(po.get(i).getName().equals(name)&&po.get(i).getType().equals(type)){
					
					if(po.get(i).getNumber()!=0){
						return 7;
					}
					
					
					if(sto.delGood(po.get(i))){
						return 0;
					}else{
						return -1;
					}
					
				}
			}
	
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 2;
	}

//	public int updateCommodity(String name, String type, double in_price, double out_price) {
//		CommodityPO com=null;
//		int i=0;
//		
//		try {
//			
//			ArrayList<CommodityPO> po=sto.getAll();
//			
//			for(i=0;i<po.size();i++){
//				if(po.get(i).getName().equals(name)&&po.get(i).getType().equals(type)){
//					com=new CommodityPO(false,name,type,in_price,out_price,po.get(i).getNote(),po.get(i).recent_in_price,po.get(i).recent_out_price,po.get(i).number);
//					if(sto.updateGood(com, com)){
//						return 0;
//					}
//					return -1;
//				}
//			}
//			
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return 2;
//	}
	
	public int updateCommodity(CommodityPO po1,CommodityPO po2){
		try {
			CommodityPO com1=sto.findGood(po1.getName(), po1.getType());
			if(com1==null){
				return 2;
			}
			sto.updateGood(com1, po2);
			return 0;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public int updateCommodity(CommodityPO po1,SortPO po2){
		try {
			CommodityPO com1=sto.findGood(po1.getName(), po1.getType());
			if(com1==null){
				return 2;
			}
			SortPO sort2=findSort(po2.getName());
			if(sort2==null){
				return 4;
			}
			
			sto.updateGood(com1, sort2);
			return 0;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public ArrayList<CommodityPO> searchCommodity(String word) {
		ArrayList<CommodityPO> array=new ArrayList<CommodityPO>();
		int i=0;
		
		try {
			
			ArrayList<CommodityPO> res=sto.getAll();
			
			for(i=0;i<res.size();i++){
				if(res.get(i).getName().equals(word)||res.get(i).getType().equals(word)||res.get(i).getNote().equals(word)){
					array.add(res.get(i));
				}
			}
			
			return array;
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String getCommodityNote(SortPO po){
		try {
			return sto.getGoodNote(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "COM";
	}

	public int addSort(SortPO sort1,SortPO sort2) {
		SortPO po1=null;
		SortPO po2=null;
		int i=0;
		
		try {
			
			ArrayList<SortPO> sort=sto.getAllSort();
			
			for(i=0;i<sort.size();i++){
				if(sort.get(i).getName().equals(sort1.getName())){
					po1=sort.get(i);
				}else if(sort.get(i).getName().equals(sort2.getName())){
					po2=sort.get(i);
				}
			}
			
			if(po1!=null){
				return 3;
			}
			if(po2==null){
				return 4;
			}
			
			if(po2.hasCommodity()){
				return 10;
			}
			
			sort1.father=sort2.getName();
			
			if (sto.addSort(sort1,sort2)) {
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}

	public int delSort(String name) {
		SortPO com=null;
		int i=0;
		
		try {
			
			ArrayList<SortPO> sort=sto.getAllSort();
			
			for(i=0;i<sort.size();i++){
				if(sort.get(i).getName().equals(name)){
					com=sort.get(i);
				}
			}
			
			if(com==null){
				return 4;
			}
			
			if(com.hasCommodity()){
				return 5;
			}
			
			if(com.hasSort()){
				return 11;
			}
			
			if (sto.delSort(com)) {
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}

	public int updateSort(String name1, String name2) {
		SortPO com1 =null;
		SortPO com2 =null;
		int i=0;
		
		try {
			
			ArrayList<SortPO> sort=sto.getAllSort();
			
			for(i=0;i<sort.size();i++){
				if(sort.get(i).getName().equals(name1)){
					com1=sort.get(i);
				}else if(sort.get(i).getName().equals(name2)){
					com2=sort.get(i);
				}
			}
			
			if(com1==null){
				return 4;
			}
			
			if(com2!=null){
				return 3;
			}
			
			if (sto.updateSort(com1,com2)) {
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public int updateSort_Mov(SortPO po1,SortPO po2){
		try {	
			SortPO sort1=findSort(po1.getName());
			SortPO sort2=findSort(po2.getName());
		
			if(sort1==null||sort2==null){
				return 4;
			}
			sto.updateSort_Mov(sort1, sort2);
			return 0;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public ArrayList<SortPO> getAllSort(){
		try {
			return sto.getAllSort();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<SortPO>();
	}
	
	public String getSortNote(SortPO po){
		try {
			return sto.getSortNote(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "SORT";
	}

	public ArrayList<ExamineVO> Examine(String time1, String time2) {
		
		ArrayList<ExamineVO> array=new ArrayList<ExamineVO>();
		
		try {
		ArrayList<ImportPO> imp=sales.getAllImport();
		ArrayList<Import_ReturnPO> imp_ret=sales.getAllImport_Return();
		ArrayList<ExportPO> exp=sales.getAllExport();
		ArrayList<Export_ReturnPO> exp_ret=sales.getAllExport_Return();
		ArrayList<PatchPO> patch=sto.getAllPatch();
		ArrayList<SendGiftPO> gift=sto.getAllSendGift();
		
		ExamineVO vo;
		
		int i=0;
		
		for(i=0;i<imp.size();i++){
			if(imp.get(i).getTime().compareTo(time1)>=0&&imp.get(i).getTime().compareTo(time2)<=0&&(imp.get(i).getCondition()==2)){
				vo=new ExamineVO(imp.get(i).getImportGoodList().get(0).getCommodity().getName(),imp.get(i).getImportGoodList().get(0).getCommodity().getType(),imp.get(i).getImportGoodList().get(0).getNumber(),0,0,0,
						0,0,imp.get(i).getTotalMoney(),imp.get(i).getTime());
				array.add(vo);
			}
		}
		
		for(i=0;i<imp_ret.size();i++){
			if(imp_ret.get(i).getTime().compareTo(time1)>=0&&imp_ret.get(i).getTime().compareTo(time2)<=0&&(imp_ret.get(i).getCondition()==2)){
				vo=new ExamineVO(imp_ret.get(i).getImportGoodList().get(0).getCommodity().getName(),imp_ret.get(i).getImportGoodList().get(0).getCommodity().getType(),0,imp_ret.get(i).getImportGoodList().get(0).getNumber(),0,0,
						0,0,imp_ret.get(i).getTotalMoney(),imp_ret.get(i).getTime());
				array.add(vo);
			}
		}
		
		for(i=0;i<exp.size();i++){
			if(exp.get(i).getTime().compareTo(time1)>=0&&exp.get(i).getTime().compareTo(time2)<=0&&(exp.get(i).getCondition()==2)){
				vo=new ExamineVO(exp.get(i).getImportGoodList().get(0).getCommodity().getName(),exp.get(i).getImportGoodList().get(0).getCommodity().getType(),0,0,exp.get(i).getImportGoodList().get(0).getNumber(),0,
						0,0,exp.get(i).getTotalMoneyBefore(),exp.get(i).getTime());
				array.add(vo);
			}
		}
		
		for(i=0;i<exp_ret.size();i++){
			if(exp_ret.get(i).getTime().compareTo(time1)>=0&&exp_ret.get(i).getTime().compareTo(time2)<=0&&(exp_ret.get(i).getCondition()==2)){
				vo=new ExamineVO(exp_ret.get(i).getImportGoodList().get(0).getCommodity().getName(),exp_ret.get(i).getImportGoodList().get(0).getCommodity().getType(),0,0,0,exp_ret.get(i).getImportGoodList().get(0).getNumber(),
						0,0,exp_ret.get(i).getTotalMoneyBefore(),exp_ret.get(i).getTime());
				array.add(vo);
			}
		}
		
		for(i=0;i<patch.size();i++){
			if(patch.get(i).getTime().compareTo(time1)>=0&&patch.get(i).getTime().compareTo(time2)<=0&&(patch.get(i).getCondition()==2)){
				vo=new ExamineVO(patch.get(i).getCommodity().getName(),patch.get(i).getCommodity().getType(),0,0,0,0,
						patch.get(i).getNumber(),0,patch.get(i).getNumber()*patch.get(i).getCommodity().getMean(),patch.get(i).getTime());
				array.add(vo);
			}
		}
		
		for(i=0;i<gift.size();i++){
			if(gift.get(i).getTime().compareTo(time1)>=0&&gift.get(i).getTime().compareTo(time2)<=0&&(gift.get(i).getCondition()==2)){
				vo=new ExamineVO(gift.get(i).getCommodity().getName(),gift.get(i).getCommodity().getType(),0,0,0,0,
						0,patch.get(i).getNumber(),gift.get(i).getNumber()*gift.get(i).getCommodity().getMean(),gift.get(i).getTime());
				array.add(vo);
			}
		}
		
		
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return array;
	}

	public ArrayList<StockVO> Iventory() {
		
		try {
			if(sto.getAll()!=null){
				
				return null;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public int addGift(String name, String type,int number) {
		CommodityPO com =null;
		
		try {
			
			com=sto.findGood(name, type);
			
			if(com==null){
				return 2;
			}
			
			if(com.number<number){
				return 6;
			}
			
			if (sto.addGift(com,number)) {
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}

	public int delGift(String name, String type) {
		CommodityPO com ;
//		sto = new CommodityDataService_Stub();
		
		try {
			
			com=sto.findGift(name, type);
			
			if(com==null){
				return 2;
			}
			
			if (sto.delGift(com)) {
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}

	public ArrayList<CommodityPO> getAllGift(){
		try {
			return sto.getAllGift();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<CommodityPO>();
	}
	
	public int patch(String name, String type, int number,String note) {
		CommodityPO com =null;
		
		try {
			com=sto.findGood(name,type);
			
			if(com==null){
				return 2;
			}
			
			if((com.number+number)<0){
				return 8;
			}
			
			String word="patch:"+com.getName()+","+com.getType()+","+number;
			systemlog.add_up(word);
			PatchPO po=new PatchPO(com, number,User.operator);
			po.setCondition(1);
			invoice.add(po);
			sto.addPatch(po);
			return 0;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public PatchPO searchPatch(String note){
		try {
			PatchPO po=sto.getPatch(note);
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int warn(String name, String type, int number) {
		CommodityPO com1 = null;
		CommodityPO com2 = null;
//		sto = new CommodityDataService_Stub();
		
		try {
			
			com1=sto.findGood(name, type);
			
			if(com1==null){
				return 2;
			}
			
			WarnPO po=new WarnPO(com1,number);
			
			com2=com1.copy();
			com2.warn=number;
			
			if (sto.updateGood(com1, com2)) {
				return 0;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public ArrayList<CommodityPO> getAllCommodity(){
		
		try {
			return sto.getAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public String passPatch(PatchPO po1) {
		// TODO Auto-generated method stub
		CommodityPO com1 =null;
		
		try {
			PatchPO po=sto.getPatch(po1.getNote());
			com1=sto.findGood(po.getCommodity().getName(),po.getCommodity().getType());
			
			if(com1==null){
				com1=new CommodityPO(po.getCommodity().getName(),po.getCommodity().getType());
				addCommodity(com1,sto.getTempSort());		
			}
			
			if (sto.passPatch(po1)) {
				return "成功";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "成功";
	}

	public String refusePatch(String note) {
		// TODO Auto-generated method stub
		
		try {
			sto.refusePatch(note);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "成功";
	}

	public CommodityPO findCommodity(String name, String type) {
		// TODO Auto-generated method stub
		
		try {
			return sto.findGood(name, type);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public SortPO findSort(String name){
		ArrayList<SortPO> sort;
		try {
			sort = sto.getAllSort();
		
			int i=0;
			for(i=0;i<sort.size();i++){
				if(sort.get(i).getName().equals(name)){
					return sort.get(i);
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String passSendGift(SendGiftPO po) {
		// TODO Auto-generated method stub
		try {
			
			SendGiftPO send=sto.findSendGift(po.getNote());
			
			if(po.getNumber()>send.getNumber()){
				CommodityPO com=sto.findGift(po.getCommodity());	
				if(com==null){
					return "失败";
				}else if(po.getNumber()>(com.getNumber()+send.getNumber())){
					return "失败";
				}
			}
			
			if(sto.passSendGift(po)){
				return "成功";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String refuseSendGift(String note) {
		// TODO Auto-generated method stub
		try {
			if(sto.findSendGift(note)==null){
				return "失败";
			}
			sto.refuseSendGift(note);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "成功";
	}
	
	public String getPatchNote(){
		try {
			return sto.getPatchNote();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Patch";
	}
	
	public String getSendGiftNote(){
		try {
			return sto.getSendGiftNote();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "SENDGIFT";
	}
	
	public int patchDraft(PatchPO po){
		try {	
			
			po.setCondition(0);
			sto.addDraftPatch(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public PatchPO searchDraftPatch(String note){
		ArrayList<PatchPO> po;
		try {
			
			po = sto.getAllDraftPatch();
			for(int i=0;i<po.size();i++){
				if(po.get(i).getNote().equals(note)){
					return po.get(i);
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<PatchPO> getAllDraftPatch(){
		try {
			return sto.getAllDraftPatch();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<PatchPO>();
	}
	
	public ArrayList<SortPO> getComSort(){
		ArrayList<SortPO> array=new ArrayList<SortPO>();
		ArrayList<SortPO> po=getAllSort();
		ArrayList<SortPO> lin=new ArrayList<SortPO>();
		
		for(int i=0;i<po.size();i++){
			lin=getComSon(po.get(i));
			for(int j=0;j<lin.size();j++){
				SortPO so=new SortPO(lin.get(j).getName());
				so.note=lin.get(j).getNote();
				so.father=lin.get(j).father;
				array.add(so);
			}
		}
		return array;
	}
	
	public ArrayList<SortPO> getSortSort(){
		ArrayList<SortPO> array=new ArrayList<SortPO>();
		ArrayList<SortPO> po=getAllSort();
		ArrayList<SortPO> lin=new ArrayList<SortPO>();
		po.remove(po.size()-1);
		
		for(int i=0;i<po.size();i++){
			lin=getSortSon(po.get(i));
			for(int j=0;j<lin.size();j++){
				SortPO so=new SortPO(lin.get(j).getName());
				so.note=lin.get(j).getNote();
				so.father=lin.get(j).father;
				array.add(so);
			}
		}
		return array;
	}
	
	public ArrayList<SortPO> getSortSon(SortPO po){
		ArrayList<SortPO> sort=new ArrayList<SortPO>();
		ArrayList<SortPO> lin=new ArrayList<SortPO>();
		SortPO so;
		
		if(!po.hasCommodity()){
			so=new SortPO(po.getName());
			so.note=po.getNote();
			so.father=po.father;
			sort.add(so);
			for(int i=0;i<po.sortList.size();i++){
				lin=getSortSon(po);
				for(int j=0;j<lin.size();j++){
					so=new SortPO(lin.get(j).getName());
					so.note=lin.get(j).getNote();
					so.father=lin.get(j).father;
					sort.add(so);
				}
			}
		}
		return sort;
	}
	
	public ArrayList<SortPO> getComSon(SortPO po){
		ArrayList<SortPO> sort=new ArrayList<SortPO>();
		ArrayList<SortPO> lin=new ArrayList<SortPO>();
		SortPO so;
		
		if(!po.hasSort()){
			so=new SortPO(po.getName());
			so.note=po.getNote();
			so.father=po.father;
			sort.add(so);
		}
		
		if(po.hasSort()){
			for(int i=0;i<po.sortList.size();i++){
				lin=getComSon(po.sortList.get(i));
				for(int j=0;j<lin.size();j++){
					so=new SortPO(lin.get(j).getName());
					so.note=lin.get(j).getNote();
					so.father=lin.get(j).father;
					sort.add(so);
				}
			}
		}
		return sort;
		
	}

	public String passImport(ImportPO po) {
		// TODO Auto-generated method stub
		try {
			if(sto.passImport(po)){
				return "成功";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "失败";
	}

	public String passImport_Return(Import_ReturnPO po) {
		// TODO Auto-generated method stub
		try {
			if(sto.passImport_Return(po)){
				return "成功";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "失败";
	}

	public String passExport(ExportPO po) {
		// TODO Auto-generated method stub
		try {
			if(sto.passExport(po)){
				return "成功";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "失败";
	}

	public String passExport_Return(Export_ReturnPO po) {
		// TODO Auto-generated method stub
		try {
			if(sto.passExport_Return(po)){
				return "成功";
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "失败";
	}
	
	//////////////////////////////////////////////////////////////





}
