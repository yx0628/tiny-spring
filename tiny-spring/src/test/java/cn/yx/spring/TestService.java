package cn.yx.spring;

public class TestService {
	
	private String text;
	
	private TestDao testDao;
	
	public void print(){
		testDao.print(text);
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setTestDao(TestDao testDao) {
		this.testDao = testDao;
	}

}
