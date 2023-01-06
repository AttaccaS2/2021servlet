package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardVO;
import model.PagingDTO;
import service.BoardServiceImpl;

/**
 * Servlet implementation class List
 */
@WebServlet("/List")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cate = request.getParameter("cate");
		
		//페이징
		String param = request.getParameter("p");
		
		PagingDTO paging =  new PagingDTO();
		
		if(!(param == null || "".equals(param))){ /* null이나 빈값이 아닐때 */
			paging.setP(Integer.parseInt(param));
		}

		BoardServiceImpl service = new BoardServiceImpl();
		List<BoardVO> list=	service.readWithPaging(paging, cate); //글 목록
		int total = service.totalCnt(cate); //전체 글 수
		paging.setTotal(total); //페이징 끝
		
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		

		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/list.jsp");
		dispatcher.forward(request, response);
			
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
