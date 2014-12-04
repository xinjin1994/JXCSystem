package vo;

public class SaleListConditionVO {
	
	String start_time;
	String end_time;
	String good_name;
	String good_type;
	String customer;
	String clerk;
	int ware_house;
	
	public SaleListConditionVO(String start_time,String end_time,String good_name,String good_type,
			String customer, String clerk, int ware_house){
		this.start_time=start_time;
		this.end_time=end_time;
		this.good_name=good_name;
		this.good_type=good_type;
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
	
	public String getGoodName(){
		return good_name;
	}
	public String getGoodType(){
		return good_type;
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
