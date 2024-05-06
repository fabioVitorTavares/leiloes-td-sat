/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public boolean venderProduto (int id){
        
        
        int result = 0;
        String query = "UPDATE produtos set status = 'Vendido' WHERE id = " +  id;

        try {
        conn = new conectaDAO().connectDB();
            
        Statement statement = conn.createStatement();
        result = statement.executeUpdate(query);
        System.out.println(listagem.size());
        } catch (SQLException e){
            return false;
        }
        return result > 0;        
    }
    
    public boolean cadastrarProduto (ProdutosDTO produto){
        
        
        int result = 0;
        String query = "INSERT INTO produtos (nome, valor, status) VALUES ('" + produto.getNome() + "', " + produto.getValor() + ", 'A venda')";

        try {
        conn = new conectaDAO().connectDB();
            
        Statement statement = conn.createStatement();
        result = statement.executeUpdate(query);
        System.out.println(listagem.size());
        } catch (SQLException e){
            return false;
        }
        return result > 0;        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos() {
        try {
        conn = new conectaDAO().connectDB();
            
        String query = "SELECT * FROM produtos";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            ProdutosDTO  produto = new ProdutosDTO();
            produto.setId(resultSet.getInt("id"));
            produto.setNome(resultSet.getString("nome"));
            produto.setValor(resultSet.getInt("valor"));
            produto.setStatus(resultSet.getString("status"));

            listagem.add(produto);
        }
        System.out.println(listagem.size());
        } catch (SQLException e){
            System.out.println("Erro");
        }

        return listagem;
    }
    
    
    public ArrayList<ProdutosDTO> listarProdutosVendidos() {
        try {
        conn = new conectaDAO().connectDB();
            
        String query = "SELECT * FROM produtos WHERE status = 'Vendido'";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            ProdutosDTO  produto = new ProdutosDTO();
            produto.setId(resultSet.getInt("id"));
            produto.setNome(resultSet.getString("nome"));
            produto.setValor(resultSet.getInt("valor"));
            produto.setStatus(resultSet.getString("status"));

            listagem.add(produto);
        }
        System.out.println(listagem.size());
        } catch (SQLException e){
            System.out.println("Erro");
        }

        return listagem;
    }
    
    
        
}

