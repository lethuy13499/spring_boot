package global.testingsystem.controller;

import java.util.Date;
import java.util.List;

import javax.mail.Multipart;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import global.testingsystem.entity.CV;
import global.testingsystem.entity.Job;
import global.testingsystem.repository.CVRepository;
import global.testingsystem.service.CvService;
import global.testingsystem.service.JobService;
import global.testingsystem.util.ConstantPage;

@CrossOrigin(origins = "*")
@RestController
public class CVController {
@Autowired
private CvService service;
@Autowired 
private CVRepository repo;
@Autowired
private JobService jobService;
//list cv
@GetMapping(value = ConstantPage.REST_API_GET_CV, produces = { MediaType.APPLICATION_PROBLEM_JSON_VALUE })
public List<CV> getListCV() {
	return service.getAllCv();
	
}
//insert cv
@PostMapping(value= ConstantPage.REST_API_CREATE_CV ,produces = { MediaType.APPLICATION_PROBLEM_JSON_VALUE })
public ResponseEntity<Object> insert(@RequestParam("files") MultipartFile files,@RequestParam("cv") String cv){
	JSONObject jsonObject = new JSONObject(cv);
	String applicantName = jsonObject.getString("applicantName");
	String email = jsonObject.getString("email");
	String phone = jsonObject.getString("phone");
	String description = jsonObject.getString("description");
	String fileName = StringUtils.cleanPath(files.getOriginalFilename());
	CV CVInsert = new CV();
	CVInsert.setApplicantName(jsonObject.getString("applicantName"));
	CVInsert.setEmail(jsonObject.getString("email"));
	CVInsert.setPhone(jsonObject.getString("phone"));
	Date date = new Date();
	java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	CVInsert.setCreatedDate(sqlDate);
	CVInsert.setFiles(fileName);
	CVInsert.setDescription(jsonObject.getString("desciption"));
	boolean isSuccsess = service.addCV(CVInsert);
	
	return new ResponseEntity<Object>(isSuccsess, HttpStatus.OK);
	
}
//update
@PostMapping(value= ConstantPage.REST_API_EDIT_CV,produces = { MediaType.APPLICATION_PROBLEM_JSON_VALUE })
public ResponseEntity<Object> update(@RequestParam("cv") String cv){
	
	
	   return null;
	
}
//delete
@DeleteMapping(value = ConstantPage.REST_API_DELETE_CV, produces = {
		MediaType.APPLICATION_PROBLEM_JSON_VALUE })
public boolean delete(@PathVariable int cvId) {
	CV cv = service.findCVById(cvId);

	return service.deleteCv(cvId);
}





}
