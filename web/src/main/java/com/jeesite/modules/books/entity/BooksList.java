/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.books.entity;

import com.jeesite.modules.sys.entity.User;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 账单数据Entity
 * @author admin
 * @version 2020-03-04
 */
@Table(name="books_list", alias="a", columns={
		@Column(name="id", attrName="id", label="编号", isPK=true),
		@Column(name="user_id", attrName="userId.userCode", label="用户名"),
		@Column(name="money", attrName="money", label="金额"),
		@Column(name="goods", attrName="goods", label="商品", queryType=QueryType.LIKE),
		@Column(name="type", attrName="type", label="商品类型"),
		@Column(includeEntity=DataEntity.class),
	}, joinTable={
		@JoinTable(type=Type.LEFT_JOIN, entity=User.class, attrName="userId", alias="u2",
			on="u2.user_code = a.user_id", columns={
				@Column(name="user_code", label="用户编码", isPK=true),
				@Column(name="user_name", label="用户名称", isQuery=false),
		}),
	}, orderBy="a.update_date DESC"
)
public class BooksList extends DataEntity<BooksList> {
	
	private static final long serialVersionUID = 1L;
	private User userId;		// 用户名
	private Double money;		// 金额
	private String goods;		// 商品
	private String type;		// 商品类型
	
	public BooksList() {
		this(null);
	}

	public BooksList(String id){
		super(id);
	}
	
	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}
	
	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}
	
	@Length(min=0, max=200, message="商品长度不能超过 200 个字符")
	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}
	
	@Length(min=0, max=64, message="商品类型长度不能超过 64 个字符")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}