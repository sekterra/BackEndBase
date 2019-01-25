package com.she.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.she.sample.model.tbTempModel;
import com.she.sample.mapper.SampleMapper;

@Service
public class SampleService {

	@Autowired
	SampleMapper sampleMapper;

	public List<tbTempModel> sampleListService() throws Exception {
		return sampleMapper.sampleList();
	}

	public int sampleInsertService(tbTempModel sampleModel) throws Exception {
		return sampleMapper.sampleInsert(sampleModel);
	}

	public int sampleUpdateService(tbTempModel sampleModel) throws Exception {
		return sampleMapper.sampleUpdate(sampleModel);
	}

	public int sampleDeleteService(int col1) throws Exception {
		return sampleMapper.sampleDelete(col1);
	}

}
