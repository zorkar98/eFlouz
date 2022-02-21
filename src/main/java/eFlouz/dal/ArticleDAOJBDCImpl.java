package eFlouz.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import eFlouz.bo.Article;
import eFlouz.bo.User;

public class ArticleDAOJBDCImpl {

	private static final String INSERT_ARTICLE = "INSERT into ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur) "
			+ "VALUES (?,?,?,?,?,?)";

	public void insertArticle(Article articleAjoute) throws Exception {
		// Connection + Requete INSERT avec IDENTITY KEY
		Connection cnx = ConnectionProvider.getConnection();
		PreparedStatement rqt = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
		//Passage de LocalDate (java) à Date (sql)
		java.sql.Date sqlDateDebutEnchre = java.sql.Date.valueOf(articleAjoute.getDateDebutEnchere());
		java.sql.Date sqlDateFinEnchre = java.sql.Date.valueOf(articleAjoute.getDateFinEnchere());

		// crï¿½ation article ï¿½ ajouter
		rqt.setString(1, articleAjoute.getNomArticle());
		rqt.setString(2, articleAjoute.getDescription());
		rqt.setDate(3, sqlDateDebutEnchre);
		rqt.setDate(4, sqlDateFinEnchre);
		rqt.setInt(5, articleAjoute.getPrixInitial());
		rqt.setInt(6, articleAjoute.getNoUtilisateur());

		// Verifie si des lignes ont ï¿½tï¿½ ajoutï¿½es, SI OUI -> genere KEY identity
		// et ajoute ï¿½ l'article insï¿½rï¿½
		int numberAffectedLine = rqt.executeUpdate();
		if (numberAffectedLine > 0) {
			ResultSet rs = rqt.getGeneratedKeys();
			if (rs.next()) {
				articleAjoute.setNoArticle(rs.getInt(1));
			}
		}
		cnx.close();
	}
}