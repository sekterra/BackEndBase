package com.she.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.she.sample.model.tbTempModel;

@Mapper
@Repository("com.she.sample.mapper.SampleMapper")
public interface SampleMapper {

	public List<tbTempModel> sampleList() throws Exception;

	public int sampleInsert(tbTempModel sampleModel) throws Exception;

	public int sampleUpdate(tbTempModel sampleModel) throws Exception;

	public int sampleDelete(int col1) throws Exception;

}
