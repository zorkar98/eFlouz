package eFlouz.ihm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eFlouz.bo.Article;
import eFlouz.dal.ArticleDAOJBDCImpl;

/**
 * Servlet implementation class AccueillirServlet
 */
@WebServlet("/home")
public class AccueillirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccueillirServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArticleDAOJBDCImpl articleDao = new ArticleDAOJBDCImpl();
		List<Article> listeArticles = new ArrayList<Article>();
		
		try {
			
			listeArticles = articleDao.selectArticleVendus();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("listeArticles", listeArticles);
		for (Article article : listeArticles) {
			System.out.println(article.getNomArticle());
		}
		
		System.out.println(listeArticles);
		
		request.getParameter("titre");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
		if (rd != null) {
		rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
