package br.com.avancard.controller;

import br.com.avancard.dao.DaoGeneric;
import br.com.avancard.entidades.Pessoa;
import br.com.avancard.repository.IDaoPessoa;
import br.com.avancard.repository.IDaoPessoaImpl;
import com.google.gson.Gson;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

@ViewScoped
@ManagedBean
@Named(value = "pessoaBean")

public class PessoaBean {

    private Pessoa pessoa = new Pessoa();
    private List<Pessoa> pessoas = new ArrayList<Pessoa>();
    private DaoGeneric<Pessoa> daoGeneric = new DaoGeneric<Pessoa>();
    private IDaoPessoa iDaoPessoa = new IDaoPessoaImpl();

    public String salvar() {
       pessoa = daoGeneric.merge(pessoa);
        carregarPessoas();
        mostrarMsg("Cadastrado com sucesso!");
        return "";
    }
    private void mostrarMsg(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(msg);
        context.addMessage(null, message);

    }
    public String novo() {
        /*Executa algum processo antes de novo*/
        pessoa = new Pessoa();
        return "";
    }
    public String remove() {
        daoGeneric.deleteporId(pessoa);
        carregarPessoas();
        pessoa = new Pessoa();
        mostrarMsg("Removido com sucesso!");
        return "";
    }

    public String limpar() {
        /*Executa algum processo antes de limpar*/
        pessoa = new Pessoa();
        return "";
    }
    @PostConstruct // usado para carregar a lista de usuários quando carrega a tela
    public void carregarPessoas() {
        pessoas = daoGeneric.getListEntity(Pessoa.class);
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    public DaoGeneric<Pessoa> getDaoGeneric() {
        return daoGeneric;
    }
    public void setDaoGeneric(DaoGeneric<Pessoa> daoGeneric) {
        this.daoGeneric = daoGeneric;
    }
    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    public List<Pessoa> getPessoas() {
        return pessoas;
    }
    public IDaoPessoa getiDaoPessoa() {
        return iDaoPessoa;
    }
    public void setiDaoPessoa(IDaoPessoa iDaoPessoa) {
        this.iDaoPessoa = iDaoPessoa;
    }

    public String logar() {

        Pessoa pessoaUser = iDaoPessoa.consultarUsuario(pessoa.getLogin(),pessoa.getSenha());

        if (pessoaUser !=null){  //achou o usuário

            //adicionar o usuário na sessão usuariologado
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext externalContext = context.getExternalContext();
            externalContext.getSessionMap().put("usuariologado", pessoaUser.getLogin());

            return "firstpage.jsf";
        }

        return "index.jsf";
    }

    public String deslogar(){

        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        externalContext.getSessionMap().remove("usuarioLogado");

        HttpServletRequest httpServletRequest = (HttpServletRequest)
        FacesContext.getCurrentInstance().getExternalContext().getRequest();

        httpServletRequest.getSession().invalidate();

        return "index.jsf";
    }

    public boolean permiteAcesso(String acesso){

        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();

        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        HttpSession session = request.getSession();
        Pessoa pessoaUser = (Pessoa) session.getAttribute("usuariologado");

       return pessoaUser.getPerfilUser().equals(acesso);
    }

    public void pesquisaCep(AjaxBehaviorEvent event){
        try {
            URL url = new URL("https://viacep.com.br/ws/"+pessoa.getCep()+"/json/");
            URLConnection connection = url.openConnection();
            InputStream is = connection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

            String cep = "";
            StringBuilder jsonCep = new StringBuilder();

            while ((cep = br.readLine()) != null){
                jsonCep.append(cep);
            }
            Pessoa gsonAux = new Gson().fromJson(jsonCep.toString(), Pessoa.class);

            pessoa.setCep(gsonAux.getCep());
            pessoa.setLogradouro(gsonAux.getLogradouro());
            pessoa.setComplemento(gsonAux.getComplemento());
            pessoa.setBairro(gsonAux.getBairro());
            pessoa.setLocalidade(gsonAux.getLocalidade());
            pessoa.setUf(gsonAux.getUf());
            pessoa.setUnidade(gsonAux.getUnidade());
            pessoa.setIbge(gsonAux.getIbge());
            pessoa.setGia(gsonAux.getGia());


        }catch (Exception ex){
            ex.printStackTrace();
            mostrarMsg("Erro ao consultar cep");
        }
    }
}
