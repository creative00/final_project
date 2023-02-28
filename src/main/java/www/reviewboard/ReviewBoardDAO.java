package www.reviewboard;

import java.util.List;
import java.util.Map;
import java.util.Vector;
import common.DBConnPool1;

public class ReviewBoardDAO extends DBConnPool1 {
	public ReviewBoardDAO() {
		super();
	}

	// 게시물의 갯수를 카운트
	public int selectCount(Map<String, Object> map) {

		int totalCount = 0;
		// 만약 검색어가 있다면 조건에 맞는 게시물 카운트해야하므로
		// 조건부(where)로 쿼리문을 추가한다.
		String query = "SELECT COUNT(*) FROM reviewboard";
		if (map.get("searchWord") != null) {
			query += " WHERE " + map.get("searchField") + " " + " LIKE '%" + map.get("searchWord") + "%'";
		}
		query += "	ORDER BY idx DESC ";
		try {

			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			totalCount = rs.getInt(1);
			System.out.println("카운트=" + totalCount);
		} catch (Exception e) {
			System.out.println("게시물 카운트 중 예외 발생");
			e.printStackTrace();
		}
		return totalCount;
	}

	// 조건에 맞는 게시물을 목록에 출력하기 위한 쿼리문을 실행한다.
	public List<ReviewBoardDTO> selectListPage(Map<String, Object> map) {
		List<ReviewBoardDTO> board = new Vector<ReviewBoardDTO>();

		String query = "SELECT * FROM reviewboard ";
		if (map.get("searchWord") != null) {
			query += " WHERE " + map.get("searchField") + " LIKE '%" + map.get("searchWord") + "%' ";
		}

		query += "	ORDER BY r_idx DESC ";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, map.get("start").toString());
			psmt.setString(2, map.get("end").toString());
			rs = psmt.executeQuery();

			while (rs.next()) {
				// 하나의 레코드를 저장할 수 있는 DTO객체를 생성
				ReviewBoardDTO dto = new ReviewBoardDTO();

				// setter()를 이용해 각 컬럼의 값을 저장
				dto.setR_idx(rs.getString(1));
				dto.setUser_id(rs.getString(2));
				dto.setR_title(rs.getString(3));
				dto.setR_content(rs.getString(4));
				dto.setR_postdate(rs.getDate(5));
				dto.setR_ofile(rs.getString(6));
				dto.setR_sfile(rs.getString(7));
				dto.setR_downcount(rs.getInt(8));
				dto.setUser_pass(rs.getString(9));
				dto.setR_visitcount(rs.getInt(10));

				System.out.println("r_idx=" + rs.getString(1));

				board.add(dto);
			}
		} catch (Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		return board;
	}

	// 글쓰기 처리 시 첨부 파일까지 함께 입력한다.
	public int insertWrite(ReviewBoardDTO dto) {
		int result = 0;
		try {
			/*
			 * r_ofile : 원본파일명 r_sfile : 서버에 저장된 파일명 pass : 
			 * 회원제 게시판이므로 게시판 입력 시 아이디 비번 쓰지 않아도 되게
			 * 수정 시에 본인 로그인하면 가능하
			 */
			String query = "INSERT INTO reviewboard ( " 
						+ " r_title, r_content, r_ofile, r_sfile) " 
						+ " VALUES ( "
						+ " ?,?,?,?,?,?)"; 
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getUser_id());
			psmt.setString(2, dto.getR_title());
			psmt.setString(3, dto.getR_content());
			psmt.setString(4, dto.getR_ofile());
			psmt.setString(5, dto.getR_sfile());
			psmt.setString(6, dto.getUser_pass());
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시물 입력 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}

	// 예제 14-16] /model2/reviewboard/reviewboardDAO.java 메서드 추가
	// 내용보기 위해 일련번호를 인수로 받아 게시물을 인출
	public ReviewBoardDTO selectView(String r_idx) {

		// 레코드 저장을 위해 DTO객체를 생성한다.
		ReviewBoardDTO dto = new ReviewBoardDTO();
		// 쿼리문 작성 후 인파라미터를 설정하고 실행한다.
		String query = "SELECT * FROM reviewboard WHERE r_idx=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, r_idx);
			rs = psmt.executeQuery();
			// 하나의 게시물이므로 if문을 통해 next()함수를 실행한다.
			if (rs.next()) {
				// 인출한 게시물이 있다면 DTO객체에 저장한다.
				dto.setR_idx(rs.getString(1));
				dto.setUser_id(rs.getString(2));
				dto.setR_title(rs.getString(3));
				dto.setR_content(rs.getString(4));
				dto.setR_postdate(rs.getDate(5));
				dto.setR_ofile(rs.getString(6));
				dto.setR_sfile(rs.getString(7));
				dto.setR_downcount(rs.getInt(8));
				dto.setUser_pass(rs.getString(9));
				dto.setR_visitcount(rs.getInt(10));
			}
		} catch (Exception e) {
			System.out.println("게시물 상세보기 중 예외 발생");
			e.printStackTrace();
		}
		return dto;
	}

	// 게시물의 조회수를 1증가시킨다.
	public void updateVisitCount(String r_idx) {
		String query = "UPDATE reviewboard SET " + " r_visitcount=r_visitcount+1 " + " WHERE r_idx=? ";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, r_idx);
			psmt.executeQuery();
		} catch (Exception e) {
			System.out.println("게시물 조회수 증가 중 예외 발생");
			e.printStackTrace();
		}
	}

	public void downCountPlus(String r_idx) {
		String sql = "UPDATE reviewboard SET " + " r_downcount=r_downcount+1 " + " WHERE r_idx=? ";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, r_idx);
			psmt.executeQuery();
		} catch (Exception e) {
		}
	}

	// 패스워드 검증을 위한 메서드로 조건에 맞는 게시물을 카운트한다.
	public boolean confirmPassword(String user_pass, String r_idx) {
		boolean isCorr = true;
		try {
			// 일련번호와 패스워드가 일치하는 게시물이 있는지 확인
			String sql = "SELECT COUNT(*) FROM reviewboard WHERE user_pass=? AND r_idx=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, user_pass);
			psmt.setString(2, r_idx);
			rs = psmt.executeQuery();
			// count()함수의 경우 조건에 맞는 레코드가 없으면 0을 반환하므로
			// 어떤 경우에도 결과값이 있다. 따라서 next()를 단독으로 실행한다.
			rs.next();
			if (rs.getInt(1) == 0) {
				isCorr = false;
			}
		} catch (Exception e) {
			isCorr = false;
			e.printStackTrace();
		}
		return isCorr;
	}

	public int deletePost(String r_idx) {
		int result = 0;
		try {
			String query = "DELETE FROM reviewboard WHERE r_idx=?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, r_idx);
			result = psmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("게시물 삭제 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	//게시글 데이터를 받아 DB에 저장되어있던 내용을 갱신한다.
	//파일 업로드 지
	public int updatePost(ReviewBoardDTO dto) { 
		int result = 0; 
		try { 
			//쿼리문 템플릿 준비
			//일련번호와 패스워드까지 where절에 추가해 둘 다 일치 시 수정가능
			String query = "UPDATE reviewboard" 
						+ " SET r_title=?, user_id=?, r_content=?, r_ofile=?, r_sfile=? " 
						+ " WHERE r_idx=? and user_pass=?";
			
			//쿼리문 준비
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getR_title());
			psmt.setString(2, dto.getUser_id());
			psmt.setString(3, dto.getR_content());
			psmt.setString(4, dto.getR_ofile());
			psmt.setString(5, dto.getR_sfile());
			psmt.setString(6, dto.getR_idx());
			psmt.setString(7, dto.getUser_pass());
			
			result = psmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("게시물 수정 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
 }
 