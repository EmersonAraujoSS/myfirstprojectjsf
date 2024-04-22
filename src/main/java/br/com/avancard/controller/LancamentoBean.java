package br.com.avancard.controller;

import br.com.avancard.dao.DaoGeneric;
import br.com.avancard.entidades.Lancamento;
import br.com.avancard.entidades.Pessoa;
import br.com.avancard.repository.IDaoLancamento;
import br.com.avancard.repository.IDaoLancamentoImpl;
import jakarta.inject.Named;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
@ManagedBean(name = "lancamentoBean")
public class LancamentoBean {

    private Lancamento lancamento = new Lancamento();
    private DaoGeneric<Lancamento> daoGeneric = new DaoGeneric<Lancamento>();
    private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
    private IDaoLancamento daoLancamento = new IDaoLancamentoImpl();

    public String salvar(){

        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();

        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        HttpSession session = request.getSession();
        Pessoa pessoaUser = (Pessoa) session.getAttribute("usuariologado");
        lancamento.setUsuario(pessoaUser);
        lancamento = daoGeneric.merge(lancamento);

        carregarLancamentos();

        return "";
    }
    
    private void carregarLancamentos(){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();

        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        HttpSession session = request.getSession();
        Pessoa pessoaUser = (Pessoa) session.getAttribute("usuariologado");

        lancamentos = daoLancamento.consultar(pessoaUser.getId());
    }
    public String novo(){
        lancamento = new Lancamento();
        return "";
    }

    public String remover(){
        daoGeneric.deleteporId(lancamento);
        lancamento = new Lancamento();
        carregarLancamentos();
        return "";
    }

    public Lancamento getLancamento() {
        return lancamento;
    }

    public void setLancamento(Lancamento lancamento) {
        this.lancamento = lancamento;
    }

    public DaoGeneric<Lancamento> getDaoGeneric() {
        return daoGeneric;
    }

    public void setDaoGeneric(DaoGeneric<Lancamento> daoGeneric) {
        this.daoGeneric = daoGeneric;
    }

    public List<Lancamento> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(List<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }
}



