package dao;

import Enum.Status;

import modal.Customer;


public interface CustomerDao extends BaseDao{
	public Status updateName(Customer customer,String name);
	public Status updateAddress(Customer customer,String address);
	public Status updateEmail(Customer customer,String email);
	public Status updatePhone(Customer customer,String phone);
}
