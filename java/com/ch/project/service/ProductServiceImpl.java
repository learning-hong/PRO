package com.ch.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ch.project.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired 
	private ProductDao pd;
}
 