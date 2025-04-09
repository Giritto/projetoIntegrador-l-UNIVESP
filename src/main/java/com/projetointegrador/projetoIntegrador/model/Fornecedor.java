package com.projetointegrador.projetoIntegrador.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.NumberFormat;

// Definindo o schema e a table que será usada
@Entity(name = "fornecedores")
@Table(name = "fornecedores")
public class Fornecedor {

    // Definindo os dados
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "O nome da empresa deve ser inserido")
    @Column(name = "nome")
    private String nome;

    @Email(message = "Por favor insira um endereço de email válido")
    @Column(name = "email")
    private String email;

    @Size(min = 10, max = 20, message = "Telefone deve ter entre 10 e 20 caracteres")
    @Column(name = "telefone")
    private String telefone;

    @NotEmpty(message = "O tipo de Material oferecido deve ser inserido")
    @Column(name = "material")
    private String material;

    @NotEmpty(message = "O valor deve ser inserido")
    @Column(name = "valor")
    private String valor;

    @Column(name = "comentario")
    private String comentario;

    // Getters and setters
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}