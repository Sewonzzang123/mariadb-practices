package book_mall_application.vo;

public class CartVo {
	private Long no;
	private int stock;
	private int price;
	private String bookNo;
	private String MemberNo;
	

	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	public String getMemberNo() {
		return MemberNo;
	}
	public void setMemberNo(String memberNo) {
		MemberNo = memberNo;
	}
	
	@Override
	public String toString() {
		return "CartVo [no=" + no + ", stock=" + stock + ", price=" + price + ", bookNo=" + bookNo + ", MemberNo="
				+ MemberNo + "]";
	}
	
}
