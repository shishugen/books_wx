/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.test.service.modules.books.service;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.test.service.modules.books.dao.BooksListDao;
import com.jeesite.modules.test.service.modules.books.entity.BooksList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 账单数据Service
 * @author admin
 * @version 2020-03-04
 */
@Service
@Transactional(readOnly=true)
public class BooksListService extends CrudService<BooksListDao, BooksList> {
	
	/**
	 * 获取单条数据
	 * @param booksList
	 * @return
	 */
	@Override
	public BooksList get(BooksList booksList) {
		return super.get(booksList);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param booksList
	 * @return
	 */
	@Override
	public Page<BooksList> findPage(Page<BooksList> page, BooksList booksList) {
		return super.findPage(page, booksList);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param booksList
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(BooksList booksList) {
		super.save(booksList);
	}
	
	/**
	 * 更新状态
	 * @param booksList
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(BooksList booksList) {
		super.updateStatus(booksList);
	}
	
	/**
	 * 删除数据
	 * @param booksList
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(BooksList booksList) {
		super.delete(booksList);
	}
	
}