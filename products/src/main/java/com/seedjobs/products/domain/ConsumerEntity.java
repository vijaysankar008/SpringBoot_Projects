package com.seedjobs.products.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ConsumerEntity {
	@Id
	private String consumerCategory;
	private String productCategory;
	private String gender;
	private int count;
	private String remark;
	
	public ConsumerEntity() {
	
	}

	public ConsumerEntity(String consumerCategory, String productCategory, String gender, int count, String remark) {
		this.consumerCategory = consumerCategory;
		this.productCategory = productCategory;
		this.gender = gender;
		this.count = count;
		this.remark = remark;
	}

	public String getConsumerCategory() {
		return consumerCategory;
	}

	public void setConsumerCategory(String consumerCategory) {
		this.consumerCategory = consumerCategory;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "ConsumerEntity [consumerCategory=" + consumerCategory + ", productCategory=" + productCategory
				+ ", gender=" + gender + ", count=" + count + ", remark=" + remark + "]";
	}
	
	
}
