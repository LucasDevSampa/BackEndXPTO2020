/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ConexaoBanco;

/**
 *
 * @author Suporte
 */
//Classes necessárias para uso de Banco de dados //
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoMySQL {

    String url = "jdbc:mysql://localhost:3306/xpto?useTimezone=true&serverTimezone=UTC";
    String usuario = "admin";
    String senha = "admin@123";

    //Método Construtor da Classe//
    public ConexaoMySQL() {
    }

    public Connection conecta() {
        try {
            try { 
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConexaoMySQL.class.getName()).log(Level.SEVERE, null, ex);
            }
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
