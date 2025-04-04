package com.freta.Entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "dados_empresariais")
public class DadosEmpresariaisEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,  length = 14, unique = true)
    private String cnpj;

    @Column(nullable = false, length = 100)
    private String razaoSocial;

    @Column(nullable = false, length = 100)
    private String nomeFantasia;

    @Column(nullable = false, length = 255)
    private String endereco;

    @Column(nullable = false, length = 20)
    private String inscricaoEstadual;

    @Column(nullable = false, length = 5)
    private String codigoDeArea;

    @Column(nullable = false, length = 20)
    private String telefone;

    @Column(nullable = false, length = 100)
    private String cidade;

    @Column(nullable = false, length = 2)
    private String estado;

    @Column(nullable = false, length = 9)
    private String cep;

    @OneToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClientEntity cliente;

    public DadosEmpresariaisEntity(){
    }

    public DadosEmpresariaisEntity(Long id, String cnpj, String razaoSocial, String nomeFantasia, String endereco,
            String inscricaoEstadual, String codigoDeArea, String telefone, String cidade, String estado, String cep,
            ClientEntity cliente) {
        this.id = id;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.endereco = endereco;
        this.inscricaoEstadual = inscricaoEstadual;
        this.codigoDeArea = codigoDeArea;
        this.telefone = telefone;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getCodigoDeArea() {
        return codigoDeArea;
    }

    public void setCodigoDeArea(String codigoDeArea) {
        this.codigoDeArea = codigoDeArea;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public ClientEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClientEntity cliente) {
        this.cliente = cliente;
    }
    
}
