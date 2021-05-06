package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;

import java.util.HashSet;
import java.util.Set;

public class DraftServico implements AggregateRoot<String> {

    private final String codigoUnico;

    private String descricaoBreve;

    private String descricaoCompleta;

    private String titulo;

    private String tituloFormulario;

    private Set<Atributo> listaAtributos;

    //private Catalogo catalogo;

    public DraftServico(String codigoUnico,String descricaoBreve,String descricaoCompleta,String titulo,
                        String tituloFormulario,Set<Atributo> listaAtributos){
        Preconditions.nonEmpty(codigoUnico,"O código único tem de ser especificado.");
        Preconditions.nonEmpty(titulo,"O título tem de ser especificado.");
        Preconditions.nonEmpty(tituloFormulario,"O título do formulário tem de ser especificado.");
        Preconditions.ensure(titulo.length() <= 500, "O título de um serviço deve ter no máximo 500 caracteres.");
        Preconditions.ensure(tituloFormulario.length()<=500,"O título de um formulário deve ter no máximo 500 caracteres.");
        this.codigoUnico=codigoUnico;
        this.descricaoBreve=descricaoBreve;
        this.descricaoCompleta=descricaoCompleta;
        this.titulo=titulo;
        this.tituloFormulario=tituloFormulario;
        this.listaAtributos=new HashSet<>(listaAtributos);
    }

    public String codigoUnico(){
        return this.codigoUnico;
    }

    public String descricaoBreve() {
        return this.descricaoBreve;
    }

    public String descricaoCompleta(){
        return this.descricaoCompleta;
    }

    public String titulo(){
        return this.titulo;
    }

    public String tituloFormulario() {return this.tituloFormulario;}

    public Set<Atributo> listaAtributos() {return this.listaAtributos;}

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public String identity() {
        return null;
    }
}
