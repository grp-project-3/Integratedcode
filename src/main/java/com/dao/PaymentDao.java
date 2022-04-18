package com.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.Location;
import com.model.Payment;

@Repository
public interface PaymentDao {
public void addPayment(Payment payment);
public boolean deletePayment(int id);
public Payment findPayment(int id);
public List<Payment> findAllPayment();
}
