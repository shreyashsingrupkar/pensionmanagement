package com.pensioner.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Table
@Entity
public class Pensioner {
@Id
private long aadharno;
private String name; 
private double salaryearned;//4. SalaryEarned//<Last earned salary by the pensioner>
private double allowances;//5. Allowances//<Sum of all the allowances>
private String banktype;
public long getAadharno() {
	return aadharno;
}
public void setAadharno(long aadharno) {
	this.aadharno = aadharno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getSalaryearned() {
	return salaryearned;
}
public void setSalaryearned(double salaryearned) {
	this.salaryearned = salaryearned;
}
public double getAllowances() {
	return allowances;
}
public void setAllowances(double allowances) {
	this.allowances = allowances;
}
public String getBanktype() {
	return banktype;
}
public void setBanktype(String banktype) {
	this.banktype = banktype;
}


}
