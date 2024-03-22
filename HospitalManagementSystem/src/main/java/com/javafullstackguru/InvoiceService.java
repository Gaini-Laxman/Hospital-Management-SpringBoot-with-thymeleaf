package com.javafullstackguru;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class InvoiceService {

	@Autowired
	private InvoiceRepository repository;

	public void save(Invoice entity) {
		repository.save(entity);
	}

	public List<Invoice> view() {
		return repository.findAll();
	}
}
