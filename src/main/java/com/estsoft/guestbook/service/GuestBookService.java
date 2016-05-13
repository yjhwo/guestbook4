package com.estsoft.guestbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estsoft.guestbook.domain.Guestbook;
import com.estsoft.guestbook.repository.GuestBookRepository;


@Service
@Transactional
public class GuestBookService {

	@Autowired
	private GuestBookRepository guestbookRepository;
	
	public void add(Guestbook guestbook){
		guestbookRepository.save(guestbook);	// guestbook은 영속 객체
	}
	
	public Boolean delete(int no, String password){						// return값이 0보다 크면 성공, 아니면 실패
		Guestbook guestbook = new Guestbook();
		guestbook.setNo((long) no);
		guestbook.setPassword(password);
		
		return guestbookRepository.remove(guestbook);
	}
	
	public List<Guestbook> getList(){
		return guestbookRepository.findAll();
	}
	
//	public Guestbook get(Long no){
//	return guestbookRepository.get(no);
//}
//
}
