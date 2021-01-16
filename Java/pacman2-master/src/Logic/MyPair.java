package Logic;


/**
 * Data structure used to store points and names for high scores
 * @author viksv451
 *
 */
public class MyPair implements java.io.Serializable {
	
	private int key;
	private String value;
	
	public MyPair(int int1, String string1) {
		this.key = int1;
		this.value = string1;
	
}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}