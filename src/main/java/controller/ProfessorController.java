package controller;

import java.util.List;
import static javafx.beans.binding.Bindings.select;
import static javafx.beans.binding.Bindings.select;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Hibernate.ProfessorHibernate;
import model.Professor;

/**
 *
 * @author BobaNote
 */
@ManagedBean(name = "professorController")
//@ViewScoped
@SessionScoped
public class ProfessorController {
    
     
    private List<Professor> repositorioProfessor = null;
    
    private Professor selectedProfessor;
    private ProfessorHibernate instance;

    public ProfessorController(){
        instance = ProfessorHibernate.getInstance();
        this.repositorioProfessor= instance.recuperarTodos();
       this.selectedProfessor = new Professor();
    }
   
    public String adicionar(){
            
            instance.adiciona(selectedProfessor);
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O Professor "+selectedProfessor.getNome()+" foi cadastrado com sucesso"));
        
            this.selectedProfessor = new Professor();
            
    return "indexlogar.xhtml";
    }
     public String alterar() {
         instance.alterar(selectedProfessor);
       this.selectedProfessor = new Professor();
         return  "apresentaprofessorlogado.xhtml";

     }
     
    
   public void deletar(Professor professor){
       instance.deletar(professor);
    this.selectedProfessor = new Professor();
   
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O Professor foi excluído com sucesso"));
        
   } 
    public Professor recuperar (int codigo){
        return instance.recuperar(codigo);
    }
    public Professor recuperarCpf(String cpf){
        return instance.recuperarCpf(cpf);
    }
    public List<Professor> recuperarTodos(){
        return instance.recuperarTodos();
    }

    public List<Professor> getRepositorioProfessor() {
        return repositorioProfessor;
    }

    public void setRepositorioProfessor(List<Professor> repositorioProfessor) {
        this.repositorioProfessor = repositorioProfessor;
    }

    public Professor getSelectedProfessor() {
        return selectedProfessor;
    }

    public void setSelectedProfessor(Professor selectedProfessor) {
        this.selectedProfessor = selectedProfessor;
    }

    public ProfessorHibernate getInstance() {
        return instance;
    }

    public void setInstance(ProfessorHibernate instance) {
        this.instance = instance;
    }

}
