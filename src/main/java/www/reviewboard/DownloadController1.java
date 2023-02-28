package www.reviewboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fileupload.FileUtil;

@WebServlet("/WWW/051Reviewboard/www.reviewboard/download.do")
public class DownloadController1 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//원본파일명, 저장된파일명, 일련번호를 파라미터로 받아온다.
		String r_ofile = req.getParameter("r_ofile");
		String r_sfile = req.getParameter("r_sfile");
		String r_idx = req.getParameter("r_idx");
		
		//다운로드 메서드를 호출한다.
		FileUtil.download(req, resp, "/Uploads", r_sfile, r_ofile);
		
		//다운로드 횟수를 증가시킨다.
		ReviewBoardDAO dao = new ReviewBoardDAO();
		dao.downCountPlus(r_idx);
		dao.close();
	}
}
