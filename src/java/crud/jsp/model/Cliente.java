/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.jsp.model;

// Importações
// JavaBeans costumam implementar Serializable
// Date utilizado para lidar com data de nascimento
import java.io.Serializable;
//import java.util.Date;

// Definição da classe
public class Cliente implements Serializable {
 
  // Um atributo para cada campo da tabela Cliente
  private int id;
  private String nomeCliente;
  private Integer manequim;
  private String endereco;
  private Integer telefone;
  private String email;
  //private Date nascimento;
 
  // Dois métodos construtores
  // Primeiro método construtor, sem argumentos, típico de JavaBeans
  public Cliente() {
  }
 
  // Segundo método construtor, com todos os argumentos
  public Cliente(int id, String nomeCliente, Integer manequim){
    this.id = id;
    this.nomeCliente = nomeCliente;
    this.manequim = manequim;
   // this.nascimento = nascimento;
  }
 
  // Seguem-se todos os métodos de acesso (Getters e Setters)
  public long getId(){
    return id;
  }
 
  public void setId(int id){
    this.id = id;
  }
 
  public Integer getManequim(){
    return manequim;
  }
 
  public void setManequim(Integer manequim){
    this.manequim = manequim;
  }
 
 /* public Date getNascimento(){
    return nascimento;
  }*/
 
 /* public void setNascimento(Date nascimento){
    this.nascimento = nascimento;
  }*/
 
  public String getNomeCliente(){
    return nomeCliente;
  }
 
  public void setNomeCliente(String nomeCliente){
    this.nomeCliente = nomeCliente;
  }

    public String getEndereco() {
        return endereco;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
  
  
}