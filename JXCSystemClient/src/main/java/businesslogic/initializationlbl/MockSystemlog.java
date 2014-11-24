package businesslogic.initializationlbl;

public class MockSystemlog implements SystemlogInfo{
	String word;
	public String add(String word) {
		this.word= word;
		return "³É¹¦";
	}

}
