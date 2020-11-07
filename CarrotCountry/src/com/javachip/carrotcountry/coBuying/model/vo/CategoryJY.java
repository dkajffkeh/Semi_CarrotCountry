package com.javachip.carrotcountry.coBuying.model.vo;

public class CategoryJY {
	
	private int categoryNo;
	private String categoryName;
	private String categotyNo;
	
	
	public CategoryJY() {}


	public CategoryJY(int categoryNo, String categoryName, String categotyNo) {
		super();
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
		this.categotyNo = categotyNo;
	}


	public int getCategoryNo() {
		return categoryNo;
	}


	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public String getCategotyNo() {
		return categotyNo;
	}


	public void setCategotyNo(String categotyNo) {
		this.categotyNo = categotyNo;
	}


	@Override
	public String toString() {
		return "CategoryJY [categoryNo=" + categoryNo + ", categoryName=" + categoryName + ", categotyNo=" + categotyNo
				+ "]";
	}
	
	
	
	
	
	
	
	
	

}
