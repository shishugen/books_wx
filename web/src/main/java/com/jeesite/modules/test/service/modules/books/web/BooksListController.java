/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.test.service.modules.books.web;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.test.service.modules.books.entity.BooksList;
import com.jeesite.modules.test.service.modules.books.service.BooksListService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 账单数据Controller
 * @author admin
 * @version 2020-03-04
 */
@Controller
@RequestMapping(value = "${adminPath}/books/booksList")
public class BooksListController extends BaseController {

	@Autowired
	private BooksListService booksListService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public BooksList get(String id, boolean isNewRecord) {
		return booksListService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("books:booksList:view")
	@RequestMapping(value = {"list", ""})
	public String list(BooksList booksList, Model model) {
		model.addAttribute("booksList", booksList);
		return "modules/books/booksListList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("books:booksList:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<BooksList> listData(BooksList booksList, HttpServletRequest request, HttpServletResponse response) {
		Page<BooksList> page = booksListService.findPage(new Page<BooksList>(request, response), booksList);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("books:booksList:view")
	@RequestMapping(value = "form")
	public String form(BooksList booksList, Model model) {
		model.addAttribute("booksList", booksList);
		return "modules/books/booksListForm";
	}

	/**
	 * 保存账单数据
	 */
	@RequiresPermissions("books:booksList:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated BooksList booksList) {
		booksListService.save(booksList);
		return renderResult(Global.TRUE, text("保存账单数据成功！"));
	}
	
	/**
	 * 删除账单数据
	 */
	@RequiresPermissions("books:booksList:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(BooksList booksList) {
		booksListService.delete(booksList);
		return renderResult(Global.TRUE, text("删除账单数据成功！"));
	}
	
}