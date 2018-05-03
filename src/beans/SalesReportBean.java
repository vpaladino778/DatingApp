package beans;

public class SalesReportBean {
	String custRep;
	int bookFee;
	public SalesReportBean(String custRep, int bookFee) {
		super();
		this.custRep = custRep;
		this.bookFee = bookFee;
	}
	public String getCustRep() {
		return custRep;
	}
	public void setCustRep(String custRep) {
		this.custRep = custRep;
	}
	public int getBookFee() {
		return bookFee;
	}
	public void setBookFee(int bookFee) {
		this.bookFee = bookFee;
	}
}
