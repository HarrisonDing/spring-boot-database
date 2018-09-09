package hd.boot.db.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hd.boot.db.mybatis.dao.UserMapper;
import hd.boot.db.mybatis.entity.User;

@Controller
// @Controller
@RequestMapping("/mybatis")
public class MyBatisUserController {

	@Autowired
	UserMapper userMapper;

	@RequestMapping("/querybyid")
	@ResponseBody
	User queryById(int id) {
		return userMapper.queryById(id);
	}

	@RequestMapping("/queryall")
	@ResponseBody
	List<User> queryAll() {
		return userMapper.queryAll();
	}

	@RequestMapping("/add")
	@ResponseBody
	String add(User user) {
		return userMapper.add(user) == 1 ? "success" : "failed";
	}

	@RequestMapping("/updatebyid")
	@ResponseBody
	String updateById(User user) {
		return userMapper.updateById(user) == 1 ? "success" : "failed";
	}

	@RequestMapping("/delbyid")
	@ResponseBody
	String delById(int id) {
		return userMapper.delById(id) == 1 ? "success" : "failed";
	}
}
