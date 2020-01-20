package global.testingsystem.controller;


import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import global.testingsystem.entity.Chapter;
import global.testingsystem.entity.Job;
import global.testingsystem.entity.Welfare;
import global.testingsystem.repository.JobRepository;
import global.testingsystem.service.JobService;
import global.testingsystem.service.WelfareService;
import global.testingsystem.service.impl.JobServiceImpl;
import global.testingsystem.util.ConstantPage;

@CrossOrigin(origins = "*")
@RestController
public class JobController {
	@Autowired
	private JobService service;
	
	@Autowired
	private JobRepository repo;
	
	@Autowired
	private JobServiceImpl impl;
	
	@Autowired 
	private WelfareService welfareService;
	
	//get all
	@GetMapping(value= ConstantPage.REST_API_GET_JOB,produces = { MediaType.APPLICATION_PROBLEM_JSON_VALUE })
	public List<Job> getAllJob(){
		return null;
	}
	
	//create 
	@PostMapping(value= ConstantPage.REST_API_CREATE_JOB ,produces = { MediaType.APPLICATION_PROBLEM_JSON_VALUE })
	public ResponseEntity<Object> insert(@RequestParam("job") String job){
		JSONObject jsonObject = new JSONObject(job);
		int jobId = jsonObject.getInt("jobId");
		String jobTitle = jsonObject.getString("jobTitle");
		String salary = jsonObject.getString("salary");
		String desciption = jsonObject.getString("desciption");
		String requitment = jsonObject.getString("requitment");
		int welfareId = jsonObject.getInt("welfareId");
		Welfare welfare = welfareService.findWelfareById(welfareId);
		List<Job> jobs = service.FindJobByTitle(jobTitle);
		if (jobs != null) {
			for (int i = 0; i < jobs.size(); i++) {
				if (jobs.get(i).getDesciption().equals(desciption) && jobs.get(i).getJobId() != jobId) {
					return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
				}
			}
		}
		
		Job jobInsert = new Job();
		jobInsert.setJobTitle(jsonObject.getString("jobTitle"));
		jobInsert.setSalary(jsonObject.getString("salary"));
		jobInsert.setDesciption(jsonObject.getString("description"));
		jobInsert.setRequitment(jsonObject.getString("requitment"));
		jobInsert.setWelfare(welfare);
		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		jobInsert.setCreated(sqlDate);
		boolean isSuccsess = service.addJob(jobInsert);
	
		return new ResponseEntity<Object>(isSuccsess, HttpStatus.OK);
	}
		
	
	//update
	@PostMapping(value= ConstantPage.REST_API_UPDATE_JOB,produces = { MediaType.APPLICATION_PROBLEM_JSON_VALUE })
	public ResponseEntity<Object> update(@RequestParam("job") String job){
		   return null;
		
	}

}
