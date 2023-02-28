package fileupload;

public class RfileDTO {
	
	private String r_idx; //일련번호
	private String user_id; //작성자이름
	private String r_title; //제목
	private String r_cate; //카테고리
	private String r_ofile; //원본 파일명
	private String r_sfile; //저장된 파일명
	private String r_postdate; //등록 날짜
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
	public String getR_cate() {
		return r_cate;
	}
	public void setR_cate(String r_cate) {
		this.r_cate = r_cate;
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
	public String getR_postdate() {
		return r_postdate;
	}
	public void setR_postdate(String r_postdate) {
		this.r_postdate = r_postdate;
	}
}
