package com.estsoft.guestbook.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.estsoft.guestbook.domain.Guestbook;

@Repository
public class GuestBookRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void save(Guestbook guestbook){
		
		guestbook.setRegDate(new Date());
		em.persist(guestbook);
	}
	
	public Boolean remove(Guestbook guestbook){
		
		TypedQuery<Guestbook> query = em.createQuery("select gb from Guestbook gb where gb.no = :no and gb.password = :password", Guestbook.class);
		query.setParameter("no", guestbook.getNo());
		query.setParameter("password", guestbook.getPassword());
		
//		TypedQuery<Guestbook> query = em.createQuery("select gb from Guestbook gb where gb.no = ?1 and gb.password = ?2", Guestbook.class);
//		query.setParameter(1, guestbook.getNo());
//		query.setParameter(2, guestbook.getPassword());
		
		List<Guestbook> list = query.getResultList();
		if(list.size() != 1){
			return false;
		}
		
		em.remove(list.get(0));
		
		return true;
	}
	
	public List<Guestbook> findAll(){
		
		TypedQuery<Guestbook> query = em.createQuery("select gb from Guestbook gb order by gb.regDate", Guestbook.class);
		List<Guestbook> list = query.getResultList();
		return list;
	}
	
}
