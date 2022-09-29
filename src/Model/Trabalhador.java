/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Antonio Joao Zimila
 */
public class Trabalhador implements Serializable {
     private static final long serialVersionUID = -1671072368634974111L;
    private int id;
    private String nome,empresa,funcao,contrato,dataInicio,dataFim;
    
    public Trabalhador(int id, String nome, String empresa, String funcao, String contrato, String dataInicio, String dataFim) {
        this.id = id;
        this.nome = nome;
        this.empresa = empresa;
        this.funcao = funcao;
        this.contrato = contrato;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Trabalhador(String nome, String empresa, String funcao, String contrato, String dataInicio, String dataFim) {
         this.nome = nome;
        this.empresa = empresa;
        this.funcao = funcao;
        this.contrato = contrato;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Trabalhador() {
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }   
}
