package com.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Location;
import com.model.Payment;

@Service
public class PaymentService {
	@Autowired
	PaymentDao PaymentDaoImpl;
	
	public void addPayment(Payment payment)
	{
		PaymentDaoImpl.addPayment(payment);
	}
	public boolean deletePayment(int id)
	{
		return PaymentDaoImpl.deletePayment(id);
	}
	public Payment find(int id)
	{
		return PaymentDaoImpl.findPayment(id);
	}
	public List<Payment> findAll()
	{
		return PaymentDaoImpl.findAllPayment();
	
	}}
