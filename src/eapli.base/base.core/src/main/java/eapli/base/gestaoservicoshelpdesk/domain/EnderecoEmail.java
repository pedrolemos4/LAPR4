package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EnderecoEmail implements ValueObject {

    @Column(name="EMAIL")
    private final String endereco;

    public EnderecoEmail(){
        this.endereco=null;
    }

    public EnderecoEmail(String endereco){
        this.endereco=endereco;
    }
}
