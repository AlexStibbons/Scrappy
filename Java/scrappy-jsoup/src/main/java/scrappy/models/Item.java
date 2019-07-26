package scrappy.models;

public class Item {
	
	private String text;
	
	private String url;

	public Item(String text, String url) {
		super();
		this.text = text;
		this.url = url;
	}

	public Item() {
		super();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
