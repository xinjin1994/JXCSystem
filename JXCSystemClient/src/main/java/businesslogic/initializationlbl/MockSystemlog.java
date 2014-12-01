package businesslogic.initializationlbl;

public class MockSystemlog implements SystemlogInfo{
	String word;
	public int add(String word) {
		this.word= word;
		return 0;
	}

}
