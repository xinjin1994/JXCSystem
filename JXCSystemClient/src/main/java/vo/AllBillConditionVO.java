package vo;

public class AllBillConditionVO {
	
	
	String start_time;
	String end_time;
	int list_type;       //1代表SendGiftPO，                     2代表ImportPO，                3代表Import_Return，         4代表ExportPO，
	                     //5代表Export_ReturnPO，   6代表PatchPO，                    7代表ReceiptPO，                       8代表PaymentPO
						 //9代表WarnPO           10代表SystemlogPO	
	String customer;
	String clerk;
	int ware_house;
	
	public AllBillConditionVO(String start_time,String end_time, int list_type,
			String customer, String clerk, int ware_house){
		this.start_time=start_time;
		this.end_time=end_time;
		this.list_type=list_type;
		this.customer=customer;
		this.clerk=clerk;
		this.ware_house=ware_house;
	}
	
	public String getStartTime(){
		return start_time;
	}
	public String getEndTime(){
		return end_time;
	}
	
	public int getListType(){
		return list_type;
	}
	
	public String getCustomer(){
		return customer;
	}
	
	public String getClerk(){
		return clerk;
	}
	
	public int getWareHouse(){
		return ware_house;
	}
	

}
