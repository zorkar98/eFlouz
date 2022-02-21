package eFlouz.bll;

import java.time.LocalDate;

import eFlouz.bo.Article;
import eFlouz.dal.ArticleDAOJBDCImpl;

public class ArticleManager {

	ArticleDAOJBDCImpl articleDao = new ArticleDAOJBDCImpl();

	// Fonction de création d'une nouvelle vente
	public void ajouterArticle(String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int prixInitial, int noUtilisateur) throws Exception {

		Article articleAAjouter = new Article(nomArticle, description, dateDebutEncheres, dateFinEncheres,
				prixInitial, noUtilisateur);

		ArticleDAOJBDCImpl articleDAOJBDCImpl = new ArticleDAOJBDCImpl();
		articleDAOJBDCImpl.insertArticle(articleAAjouter);

	}

}