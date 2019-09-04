package com.metacube.pojo;

/**
 * Pojo class of vehicle details.
 */
public class VehicleDetailsPojo {

	public int empId;
	public String vehicleName;
	public String vehicleType;
	public String vechicleNumber;
	public String identification;

	public VehicleDetailsPojo(int empId, String vehicleName, String vehicleType, String vechicleNumber, String identification) {
		super();
		this.empId = empId;
		this.vehicleName = vehicleName;
		this.vehicleType = vehicleType;
		this.vechicleNumber = vechicleNumber;
		this.identification = identification;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVechicleNumber() {
		return vechicleNumber;
	}

	public void setVechicleNumber(String vechicleNumber) {
		this.vechicleNumber = vechicleNumber;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

}
