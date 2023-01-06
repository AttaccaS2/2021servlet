package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PagingDTO;
import model.TimeDiaryVO;
import service.TimeDiaryServiceImpl;

/**
 * Servlet implementation class TimeDiaryController
 */
@WebServlet("/TimeDiary")
public class TimeDiaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimeDiaryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이징
		String param = request.getParameter("p");
	
		PagingDTO paging =  new PagingDTO();
		
		if(!(param == null || "".equals(param))){ 
			paging.setP(Integer.parseInt(param));
		}

		TimeDiaryServiceImpl service = new TimeDiaryServiceImpl();
		List<TimeDiaryVO> list=	service.readWithPaging(paging); //글 목록
		
		int total = service.totalCnt(); //전체 글 수
		paging.setTotal(total); //페이징 끝
		
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/timediary.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");  //글자 안깨지게

		HttpSession session = request.getSession();	
		
		TimeDiaryVO vo = new TimeDiaryVO();
			
		vo.setTbo_content(request.getParameter("tbo_content"));
		vo.setTbo_mb_id((String)session.getAttribute("sess_id"));
		vo.setTbo_mb_name((String)session.getAttribute("sess_name"));

		TimeDiaryServiceImpl service = new TimeDiaryServiceImpl();
		service.create(vo);
		
		System.out.println(vo);
		
		response.sendRedirect("/TimeDiary");

	}

}
