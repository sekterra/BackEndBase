package com.she.sample.apiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.she.sample.model.tbTempModel;
import com.she.sample.service.SampleService;

@RestController
@RequestMapping("sample/api")
public class SampleApiController {

	@Autowired
	SampleService sampleService;

	@GetMapping("/list")
	public ResponseEntity<List<tbTempModel>> list() throws Exception {
		List<tbTempModel> samples = sampleService.sampleListService();
		return ResponseEntity.ok().body(samples);
	}

	@PostMapping("/insert")
	public ResponseEntity<tbTempModel> insert(@RequestBody tbTempModel sampleModel) throws Exception {
		sampleService.sampleInsertService(sampleModel); // 게시글 insert
		return ResponseEntity.ok().body(sampleModel);
	}

	@DeleteMapping("/delete/{col1}")
	public ResponseEntity<?> delete(@PathVariable("col1") int col1) throws Exception {
		sampleService.sampleDeleteService(col1);
		return ResponseEntity.ok().body("board has been deleted successfully.");
	}
	
	@PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody tbTempModel sampleModel) throws Exception {
    	sampleService.sampleUpdateService(sampleModel);
        return ResponseEntity.ok().body(sampleModel);
    }    

}
