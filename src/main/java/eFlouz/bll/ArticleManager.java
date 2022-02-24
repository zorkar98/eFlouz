package eFlouz.bll;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import eFlouz.bo.Article;
import eFlouz.dal.ArticleDAOJBDCImpl;

public class ArticleManager {

	ArticleDAOJBDCImpl articleDao = new ArticleDAOJBDCImpl();

	// Fonction de création d'une nouvelle vente
	public void ajouterArticle(String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int prixInitial, int noUtilisateur, int noCategorie) throws Exception {

		Article articleAAjouter = new Article(nomArticle, description, dateDebutEncheres, dateFinEncheres,
				prixInitial, noUtilisateur, noCategorie);

		articleDao.insertArticle(articleAAjouter);

	}
	// Appel de la methode de ArticleManagerDAOJDBC pour récupérer les articles en ventes ce jour
	public List<Article> selectionnerArticleEnVente (LocalDate date)
	{
		List<Article> listeArticleEnVente = new ArrayList<>(); 
		
		try {
			listeArticleEnVente = articleDao.selectionnerArticleEnVente(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return listeArticleEnVente;
	}
}
