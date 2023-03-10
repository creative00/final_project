package www.reviewboard;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
어노테이션을 통한 매핑은 요청명을 해당 컨트롤러 상단에 기술한다.
web.xml에 기술하는 것과 동일하게 입력이 잘못되는 경우 톰켓이
시작되지 않을 수 있으므로 주의해야한다. 
 */
@WebServlet("/WWW/051Reviewboard/www.reviewboard/view.do")

public class ViewController1 extends HttpServlet {
	
	/*
	service()는 서블릿의 수명주기 메서드 중 사용자의 요청을
	전송방식에 상관 없이 먼저 받아 deGet() 혹은 doPost()로 요청 전달해줌
	 */
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
		
		//DAO객체 생성을 통해 커넥션풀 객체를 얻어온다.
		ReviewBoardDAO dao = new ReviewBoardDAO();
		//일련번호를 받아온다.
		String r_idx = req.getParameter("r_idx");
		//조회수를 증가시킨다.
		dao.updateVisitCount(r_idx);
		//게시물을 인출한다.
		ReviewBoardDTO dto = dao.selectView(r_idx);
		//커넥션풀 자원반납//
		dao.close();
		
		//내용에 대해서는 줄바꿈 처리를 위해 <br>태그로 변경한다.
		dto.setR_content(dto.getR_content().replaceAll("\r\n", "<br/>"));
		
		//첨부파일이 이미지인 경우 화면에 출력하기 위한 로직을 추가한다.
		String ext=null, fileName= dto.getR_sfile();
		//서버에 저장된 파일이 있는 경우라면 확장자를 잘라낸다.
		if(fileName!=null) {
			ext = fileName.substring(fileName.lastIndexOf(".")+1);
		}
		//이미지의 대표적인 확장자를 String배열로 선언한다.
		String[] mineStr = {"png", "jpg", "gif"};
		//String 배열을 List 컬렉션으로 변환한다.
		boolean isImage = false;
		//변환된 List컬렉션에 우리가 첨부한 이미지의 확장자가 있는지 확인
		List<String> mimeList = Arrays.asList(mineStr);
		if(mimeList.contains(ext)) {
			//있다면 true로 변경
			isImage = true;
		}
		//request영역에 저장한다.
		req.setAttribute("isImage", isImage);
		
		
		
		
		
		//request영역에 DTO 객체를 저장 후 View로 포워드 한다.
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/WWW/051Reviewboard/ReviewView.jsp").forward(req, resp);
	}
}
