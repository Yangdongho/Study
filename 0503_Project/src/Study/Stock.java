package Study;

import java.io.Serializable;

public class Stock implements Serializable{
	//매장 이름 ->매장 이름으로 해당매장 제품 분류
	String productName; //제품 이룸
	int number;// 제품 수량
	int price;
	
	public Stock(String productName,int number,int price) {
		// TODO Auto-generated constructor stub
		this.productName = productName;
		this.number = number;
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return productName + "  " + number + "  " + price;
	}
	
	

}	

