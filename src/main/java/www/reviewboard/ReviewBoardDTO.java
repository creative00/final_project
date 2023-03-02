package www.reviewboard;

public class ReviewBoardDTO {
	private String r_idx; //게시글번호
	private String user_id; //회원제이므로 작성자의 아이디 
	private String r_title;
	private String r_content;
	private java.sql.Date r_postdate; //업로드일자
	private String r_ofile; //원본파일명:클라이언트가 업로드한 원본파일명
	private String r_sfile; //저장된파일명:파일명 변경 후 서버에 저장될 파일명
	private int r_downcount; //자료실이므로 파일 다운로드한 횟수를 카운트함
	//private String user_pass; //비회원제 게시판이라 회원인증 대신 비번 통한 인증 진행
	private int r_visitcount; 
	
	public String getR_idx() {
		return r_idx;
	}
	public void setR_idx(String r_idx) {
		this.r_idx = r_idx;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getR_title() {
		return r_title;
	}
	public void setR_title(String r_title) {
		this.r_title = r_title;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public java.sql.Date getR_postdate() {
		return r_postdate;
	}
	public void setR_postdate(java.sql.Date r_postdate) {
		this.r_postdate = r_postdate;
	}
	public String getR_ofile() {
		return r_ofile;
	}
	public void setR_ofile(String r_ofile) {
		this.r_ofile = r_ofile;
	}
	public String getR_sfile() {
		return r_sfile;
	}
	public void setR_sfile(String r_sfile) {
		this.r_sfile = r_sfile;
	}
	public int getR_downcount() {
		return r_downcount;
	}
	public void setR_downcount(int r_downcount) {
		this.r_downcount = r_downcount;
	}
	
	public int getR_visitcount() {
		return r_visitcount;
	}
	public void setR_visitcount(int r_visitcount) {
		this.r_visitcount = r_visitcount;
	}
}
