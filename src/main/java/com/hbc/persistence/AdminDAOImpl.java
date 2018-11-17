package com.hbc.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hbc.domain.AdminVO;
import com.hbc.domain.AppSearchCriteria;
import com.hbc.dto.CompanyDTO;
import com.hbc.dto.LoginDTO;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Inject
	private SqlSession session;
	
	// 매퍼의 Namespace
	private static String namespace = "com.hbc.mappers.AdminMapper";
	
	@Override
	public AdminVO login(LoginDTO dto) throws Exception {
		return session.selectOne(namespace + ".login", dto);
	}
	
		/**
		 * 어드민 객체를 파라미터로 넘기면
		 * 객체의 어드민 Id로 검색해서 매칭되는
		 * 어드민 정보 한개 가져오는 메소드
		 * @param admin
		 * @return AdminVO 데이터
		 * @throws Exception
		 */
		@Override
		public AdminVO read(AdminVO admin) throws Exception
		{
			return session.selectOne(namespace + ".read", admin);
		}
		
		/**
		 * 데이터가 완전한 어드민 객체를 파라미터로 넘겨서
		 * 데이터베이스에 INSERT 작업을 함
		 * @param admin
		 * @return 삽입된 행의 개수
		 * @throws Exception
		 */
		@Override
		public int insert(AdminVO admin) throws Exception
		{
			return session.insert(namespace + ".insert", admin);
		}
		
		/**
		 * 데이터가 완전한 어드민 객체를 파라미터로 넘겨서
		 * 객체의 ID와 매칭되는 데이터베이스 행을 객체의 데이터대로
		 * 수정작업을 하는 메소드 
		 * @param admin
		 * @return 업데이트된 행의 개수
		 * @throws Exception
		 */
		public int update(AdminVO admin) throws Exception
		{
			return session.update(namespace + ".update", admin);
		}
		
		/**
		 * 어드민 객체를 파라미터로 넘겨서
		 * 객체의 ID와 매칭되는 데이터베이스 행을
		 * 삭제하는 메소드
		 * @param admin
		 * @return 삭제된 행의 개수
		 * @throws Exception
		 */
		public int delete(AdminVO admin) throws Exception
		{
			return session.delete(namespace + ".delete", admin);
		}
		
		/**
		 * 어드맨 전부의 리스트객체를 가져오는 메소드
		 * @return 어드민 리스트
		 * @throws Exception
		 */
		public List<AdminVO> listAll() throws Exception
		{
			return session.selectList(namespace + ".listAll");
		}
		
		/**
		 * SearchCriteria 객체를 파라미터로
		 * 검색조건에 맞는 어드민 리스트를 페이징해서
		 * 가져오는 메소드
		 * @param cri
		 * @return 검색조건에 맞는 어드민 리스트
		 */
		public List<AdminVO> listSearch(AppSearchCriteria cri)
		{
			return session.selectList(namespace + ".listSearch", cri);
		}
		
		/**
		 * 검색조건에 맞는 리스트의
		 * 행 갯수를 카운트해서
		 * SearchCriteria 객체에
		 * 넣어줌
		 * @param cri
		 * @return SearchCriteria 객체
		 */
		public int ListSearchCount(AppSearchCriteria cri)
		{
			return session.selectOne(namespace + ".listSearchCount", cri);
		}
		
		/**
		 * 어드민 전화번호의 유효성을
		 * 검사하는 메소드
		 * 파라미터로 넘겨진 객체의
		 * 전화번호와 매칭되는 테이블의
		 * 행을 검색해서 받아옴
		 * @param admin
		 * @return 어드민 객체
		 */
		public AdminVO validatePhone(AdminVO admin)
		{
			return session.selectOne(namespace + ".validatePhone", admin);
		}
		
		/**
		 * 어드민 이메일주소의 유효성을
		 * 검사하는 메소드
		 * 파라미터로 넘겨진 객체의
		 * 메일주소와 매칭되는 테이블의
		 * 행을 검색해서 받아옴
		 * @param admin
		 * @return 어드민 객체
		 */
		public AdminVO validateEmail(AdminVO admin)
		{
			return session.selectOne(namespace + ".validateEmail", admin);
		}
		
		public List<CompanyDTO> readComps()
		{
			return session.selectList(namespace + ".readComps");
		}

}
