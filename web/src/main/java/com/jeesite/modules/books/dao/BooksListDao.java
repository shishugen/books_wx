/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.books.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.books.entity.BooksList;

/**
 * 账单数据DAO接口
 * @author admin
 * @version 2020-03-04
 */
@MyBatisDao
public interface BooksListDao extends CrudDao<BooksList> {
	
}