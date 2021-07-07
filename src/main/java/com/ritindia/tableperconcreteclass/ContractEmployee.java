package com.ritindia.tableperconcreteclass;

public class ContractEmployee extends Employee{
	
	private String contractPeriod;

	public String getContractPeriod() {
		return contractPeriod;
	}

	public void setContractPeriod(String contractPeriod) {
		this.contractPeriod = contractPeriod;
	}

	@Override
	public String toString() {
		return "ContractEmployee [contractPeriod=" + contractPeriod + "]";
	}
	
	

}
