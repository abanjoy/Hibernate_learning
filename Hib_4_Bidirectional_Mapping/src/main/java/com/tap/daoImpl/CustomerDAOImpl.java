package com.tap.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.hib.entity.Customer;
import com.hib.entity.Customer_Info;
import com.tap.dao.CustomerDAO;
import com.tap.utils.SessionManager;

public class CustomerDAOImpl implements CustomerDAO {

	public Session session;
	{
		session = new SessionManager().getSession();
		session.beginTransaction();
	}
	@Override
	public void insertCustomer(Customer c) {
		// TODO Auto-generated method stub
		
		session.persist(c);
		session.getTransaction().commit();

	}
	@Override
	public void insertCustomer(Customer_Info ci) {
		// TODO Auto-generated method stub
		
		session.persist(ci);
		session.getTransaction().commit();

	}

	@Override
	public List<Customer> fetchAllCustomer() {
		// TODO Auto-generated method stub
		Query q = session.createQuery("from Customer");
		
		return q.list();
	}

	@Override
	public Customer fetchSpecific_Email(String email) {
		
		String hql = "select c from Customer c join c.customerInfo d where d.email=:email";
		Query q = session.createQuery(hql).setParameter("email", email);
				
		
		// TODO Auto-generated method stub
//		String hql = "select * from customer c join customer_info d on c.customerInfo=d.ciid where d.email = :email";
//		Query q = session.createNativeQuery(hql,Customer.class).setParameter("email", email);
		return (Customer) q.list().get(0);
	}

	@Override
	public Customer fetchSpecific(int cid) {
		// TODO Auto-generated method stub
		return session.get(Customer.class, cid);

	}

	@Override
	public void updateCustomer(long mobile,String email) {
		// TODO Auto-generated method stub
		String hql = "from Customer c where mobile=:mobile";
		Query q = session.createQuery(hql).setParameter("mobile", mobile);
		Customer c = (Customer) q.list().get(0);
		c.getCustomerInfo().setEmail(email);
		session.persist(c);
		session.getTransaction().commit();;
		
		System.out.println("Successfull");
		
	}

	@Override
	public void deleteCustomer(int cid) {
		// TODO Auto-generated method stub
		
		Customer c = session.get(Customer.class, cid);
		try {
			session.delete(c);
			session.getTransaction().commit();
			System.out.println("Deletion is successful");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
}
