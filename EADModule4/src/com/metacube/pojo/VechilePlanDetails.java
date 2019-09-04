package com.metacube.pojo;

/**
 * Pojo class of vehicle plan details.
 */
public class VechilePlanDetails {

	public int empId;
	public String vechileNumber;
	public String empVechilePlan;
	public int planPrice;

	public VechilePlanDetails(int empId, String vechileNumber, String empVechilePlan, int planPrice) {
		super();
		this.empId = empId;
		this.vechileNumber = vechileNumber;
		this.empVechilePlan = empVechilePlan;
		this.planPrice = planPrice;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getVechileNumber() {
		return vechileNumber;
	}

	public void setVechileNumber(String vechileNumber) {
		this.vechileNumber = vechileNumber;
	}

	public String getEmpVechilePlan() {
		return empVechilePlan;
	}

	public void setEmpVechilePlan(String empVechilePlan) {
		this.empVechilePlan = empVechilePlan;
	}

	public int getPlanPrice() {
		return planPrice;
	}

	public void setPlanPrice(int planPrice) {
		this.planPrice = planPrice;
	}

}
