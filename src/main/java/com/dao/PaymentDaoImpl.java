package com.Dao;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.model.Payment;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class PaymentDaoImpl implements PaymentDao {
	@Autowired
	
	SessionFactory sessionFactory;
	
	@Override
	public void addPayment(Payment payment) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(payment);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	@Override
	public boolean deletePayment(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		Payment payment=session.find(Payment.class,id);
		session.delete(payment);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}
	@Override
	public Payment findPayment(int id) {
		Session session=sessionFactory.openSession();
		Payment payment=session.find(Payment.class, id);
		// TODO Auto-generated method stub
		return payment;
	}
	@Override
	public List<Payment> findAllPayment() {
		Session session=sessionFactory.openSession();
		List<Payment> paymentlist=session.createQuery("select i from Payment i").list();
				
		// TODO Auto-generated method stub
		return paymentlist;
	}
}
