/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.backendxpto2020;

/**
 *
 * @author Suporte
 */
import br.com.ConexaoBanco.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BackEndXPTO2020 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //   ConexaoMySQL con = new ConexaoMySQL();

        int id;
        String sql = "SELECT * FROM clientes;";
        try {
            System.out.println("Tentando conectar...");
            Connection con = new ConexaoMySQL().conecta();
            System.out.println("conexao realizada com sucesso");

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                //Recupera valor referente ao nome da coluna
                int codigo = rs.getInt(1);
                //Recupera o índice do campo referente ao campo nome
                String nome = rs.getString(2);
                String cpf = rs.getString(3);
                String data = rs.getString(4);
                System.out.printf("Código %d: Nome: %s cpf: %s data: %s\n", codigo,nome, cpf, data);
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e);
        }

    }

}
