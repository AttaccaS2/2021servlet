package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CommentVO;
import model.ViewinfoVO;
import service.BoardServiceImpl;
import service.CommentServiceImpl;

/**
 * Servlet implementation class ViewController
 */
@WebServlet("/View")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bo_num = Integer.parseInt(request.getParameter("bo_num"));
		
		//BoardServiceImpl service= new BoardServiceImpl();
		//BoardVO vo = service.read(bo_num);	
		BoardServiceImpl service= new BoardServiceImpl();
		ViewinfoVO info = service.view(bo_num);
		
		request.setAttribute("view", info.getBoard()); //boardvo 리턴해줌
		
		//CommentServiceImpl service2 = new CommentServiceImpl();
		//List<CommentVO> list = service2.read(bo_num);
		request.setAttribute("list", info.getList()); //List<CommentVO>리턴함
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/view.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String com_refnum = request.getParameter("com_refnum");
		
		CommentVO vo = new CommentVO();
		vo.setCom_refnum(Integer.parseInt(com_refnum));
		vo.setCom_content(request.getParameter("com_content"));
		
		HttpSession session = request.getSession();
	
		vo.setCom_mb_id((String)session.getAttribute("sess_id"));
		vo.setCom_mb_name((String)session.getAttribute("sess_name"));

		CommentServiceImpl service = new CommentServiceImpl();
		service.create(vo);
		
		response.sendRedirect("?bo_num="+com_refnum); //url이 바뀌는 겟방식으로 보냄
	}

}
