package com.hbc.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hbc.domain.Criteria;
import com.hbc.domain.EmployeeVO;
import com.hbc.domain.AppSearchCriteria;
import com.hbc.dto.CompanyDTO;
import com.hbc.dto.EmpFileDTO;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.hbc.mappers.EmployeeMapper";

	@Override
	public void register(EmployeeVO vo) {
		session.insert(namespace + ".insert", vo);
	}

	@Override
	public void modify(EmployeeVO vo) {
		session.update(namespace + ".modify", vo);

	}

	@Override
	public void delete(int empnum) {
		session.delete(namespace + ".delete", empnum);
		session.delete(namespace + ".deleteImageByEmp", empnum);
	}
	
	@Override
	public EmployeeVO read(int empnum) {
		return session.selectOne(namespace + ".read", empnum);
	}

	@Override
	public int addAttach(String fileName) {
		
		EmpFileDTO dto = new EmpFileDTO(fileName);
		
		session.insert(namespace + ".addAttach", dto);
		
		return dto.getFilenum();
	}
	
	@Override
	public String getAttach(int empnum) {
		return session.selectOne(namespace + ".getAttach" , empnum);
	}
	
	@Override
	public void deleteAttach(int filenum) {
		session.insert(namespace + ".deleteImage", filenum);
	}
	
	@Override
	public void deleteAttach(String filename) {
		session.insert(namespace + ".deleteImageByName", filename);
	}

	@Override
	public int getCurrFileSeq() throws Exception {

		return session.selectOne(namespace + ".getCurrFileSeq");

	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return session.selectOne(namespace + ".countPaging", cri);

	}

	@Override
	public List<EmployeeVO> listSearch(AppSearchCriteria cri) throws Exception {
		return session.selectList(namespace + ".listSearch", cri);

	}

	@Override
	public int listSearchCount(AppSearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSearchCount", cri);

	}

	@Override
	public List<CompanyDTO> readComps() {
		return session.selectList(namespace + ".readComps");
	}


}
