package global.testingsystem.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import global.testingsystem.entity.News;
import global.testingsystem.entity.Subject;
import global.testingsystem.entity.Welfare;
import global.testingsystem.service.WelfareService;
import global.testingsystem.service.impl.WelfareServiceImpl;
import global.testingsystem.util.ConstantPage;

@CrossOrigin(origins = "*")
@RestController
public class WelfareController {
	@Autowired
	private WelfareService service;
	@Autowired
	private WelfareServiceImpl impl;

//getall
	@GetMapping(value = ConstantPage.REST_API_GET_WELFARE, produces = { MediaType.APPLICATION_PROBLEM_JSON_VALUE })
	public List<Welfare> getListWelfare() {
		return service.getAllWelfare();
	}

//create
	@PostMapping(value = ConstantPage.REST_API_CREATE_WELFARE, produces = { MediaType.APPLICATION_PROBLEM_JSON_VALUE })
	public ResponseEntity<Object> insert(@RequestParam("welfare")  String welfare) {
		JSONObject jsonObject = new JSONObject(welfare);
//		int welfareId = jsonObject.getInt("welfareId");
		String desciption = jsonObject.getString("description");
		Welfare welfareInsert = new Welfare();
		welfareInsert.setDesciption(jsonObject.getString("description"));
		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		welfareInsert.setCreatedDate(sqlDate);
		welfareInsert.setStatus(jsonObject.getInt("status"));
		boolean isSuccsess = service.addWelfare(welfareInsert);
		return new ResponseEntity<Object>(isSuccsess, HttpStatus.OK);
	}
//edit
	@PutMapping(value = ConstantPage.REST_API_EDIT_WELFARE, produces = { MediaType.APPLICATION_PROBLEM_JSON_VALUE })
	public ResponseEntity<Object> update(@RequestParam("welfare") String welfare) {
		JSONObject jsonObject = new JSONObject(welfare);
		int welfareId = jsonObject.getInt("welfareId");
		String desciption = jsonObject.getString("description");
		Welfare welfareUpdate = service.findWelfareById(welfareId);
		welfareUpdate.setDesciption(desciption);
		welfareUpdate.setCreatedDate(welfareUpdate.getCreatedDate());
		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		welfareUpdate.setChangeDate(sqlDate);
		boolean isSuccess = service.editWelfare(welfareUpdate);
		return new ResponseEntity<Object>(isSuccess, HttpStatus.OK);
	}

//delete
	@GetMapping(value = ConstantPage.REST_API_DELETE_WELFARE,produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> updateStatus(@PathVariable("welfareId") Integer welfareId) {
		service.deleteWelfare(welfareId);
		return new ResponseEntity<String>("Chuyển đổi trạng thái thành công", HttpStatus.OK);
	}
//searchByKey
	@GetMapping(value= ConstantPage.REST_API_SEARCH_WELFARE,produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Object> searchWelfareByKey(@RequestParam("key") String key){
		List<Object> result = service.fiWelfareByDescription(key);
	return result;
	}

}
