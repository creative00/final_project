package fileupload;

import java.util.List;
import java.util.Vector;

import common.DBConnPool1;


/*
DBCP(DataBase Connection Pool)을 이용해 오라클에 연결한다.
커넥션풀은 DB연결객체를 풀(Pool)에 미리 만들어놓고
필요할 때마다 가져다 사용 후 반납하는 형태로, 
필요 이상으로 객체 생성 및 소멸시키지 않아도 되므로
효율적인 자원 관리를 할 수 있다.
DB연결에 필요한 정보는 Java나 JSP가 가지고있지 않고
Tomcat(웹서버)에 설정하게 된다. 
  
 */

public class RfileDAO extends DBConnPool1 {
	//새로운 게시물 등록 시 첨부파일도 함께 저장한다.
	public int insertFile(RfileDTO dto) {
		int applyResult = 0;
		try {
			/*
			게시물 입력 위한 insert문 생성.
			입력폼에서 등록한 제목, 이름과 원본파일명, 저장된 파일명을 등록
			일련번호의 경우 회원제 게시판에서 생성했던 시퀀스 그대로 사용
			시퀀스의 목적은 중복되지 않은 일련번호를 생성하는 것이므로 
			하나의 시퀀스를 여러개의 테이블에 사용해도 됨 
			*/
			String query = "INSERT INTO r_myfile ( "
					+ " r_idx, user_id, r_title, r_cate, r_ofile, r_sfile) "
					+ " VALUES ( "
					+ " seq_board_num.nextval, ?, ?, ?, ?, ?)";
			//인파라미터 설정
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getUser_id());
			psmt.setString(2, dto.getR_title());
			psmt.setString(3, dto.getR_cate());
			psmt.setString(4, dto.getR_ofile());
			psmt.setString(5, dto.getR_sfile());
			//쿼리문 실행
			applyResult = psmt.executeUpdate();
		
		}
		catch (Exception e){
			System.out.println("INSERT 중 예외 발생");
			e.printStackTrace();
		}
		return applyResult;
	}
	//파일 목록 구현 위해 select쿼리문 실행
	public List<RfileDTO> rFileList() {
		List<RfileDTO> fileList = new Vector<RfileDTO>();
		
		//일련번호를 내림차순으로 정렬한 뒤 게시물을 select한다.
		String query = "SELECT * FROM r_myfile ORDER BY r_idx DESC";
		try {
			//쿼리문 실행
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			//인출한 행의 갯수만큼 반복한다.
			while (rs.next()) {
				//레코드를 DTO객체에 저장 후 
				RfileDTO dto = new RfileDTO();
				dto.setR_idx(rs.getString(1));
				dto.setUser_id(rs.getString(2));
				dto.setR_title(rs.getString(3));
				dto.setR_cate(rs.getString(4));
				dto.setR_ofile(rs.getString(5));
				dto.setR_sfile(rs.getString(6));
				dto.setR_postdate(rs.getString(7));
				//List컬렉션에 추가한다.
				fileList.add(dto);
			}	
		}
		catch (Exception e) {
			System.out.println("Select 시 예외 발생 ");
			e.printStackTrace();
		}
		return fileList;
	}
}
