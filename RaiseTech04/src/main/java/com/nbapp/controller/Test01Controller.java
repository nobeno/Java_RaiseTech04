package com.nbapp.controller;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nbapp.domain.Test01;
import com.nbapp.mapper.Test01Mapper;

@Controller
@RequestMapping("/tests")
@MapperScan(basePackages = {"com.nbapp.mapper"})
public class Test01Controller {
	@Autowired
	Test01Mapper test01Mapper;

	@GetMapping
	public String index(Model model){
		List<Test01> list = test01Mapper.selectAll();
		model.addAttribute("tests",list);
		return "tests/index";
	}

	@GetMapping("new")
	public String newTest(Model model) {
		return "tests/new";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		Test01 test01 = test01Mapper.selectByPrimaryKey(id);
		model.addAttribute("test", test01);
		return "tests/edit";
	}

	@PostMapping
	public String create(@ModelAttribute Test01 test01) {
		test01Mapper.insertSelective(test01);
		return "redirect:/tests";
	}

	@PutMapping("{id}")
	public String update(@PathVariable int id, @ModelAttribute Test01 test01){
		test01.setId(id);
		test01Mapper.updateByPrimaryKeySelective(test01);
		return "redirect:/tests";
	}

	@DeleteMapping("{id}")
	public String delete(@PathVariable int id) {
		test01Mapper.deleteByPrimaryKey(id);
		return "redirect:/tests";
	}



}
