package businesslogic.commoditybl;


public class CommoditySingleton {

	private static Commodity commodity;
	
	public static Commodity getInstace(){
		return commodity;
	}
	
	public static void setInstace(Commodity commodity1){
		commodity=commodity1;
	}
	
}
