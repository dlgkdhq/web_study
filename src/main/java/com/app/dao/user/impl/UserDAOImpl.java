package com.app.dao.user.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.user.UserDAO;
import com.app.dto.user.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	//실질적인 DB 연동 처리 관련 객체
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int saveUser(User user) {
		int result = sqlSessionTemplate.insert("user_mapper.saveUser", user);
		
		return result;
	}

	@Override
	public List<User> findUserList() {
		
		List<User> userList = sqlSessionTemplate.selectList("user_mapper.findUserList");
		
		return userList;
	}

}
