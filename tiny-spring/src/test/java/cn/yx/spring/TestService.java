package cn.yx.spring;

public class TestService {
	
	private String text;
	
	public void print(){
		System.out.println(text);
	}

	public void setText(String text) {
		this.text = text;
	}

}
