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
        if(endereco.contains("@") && !endereco.isEmpty()) {
            this.endereco = endereco;
        }else{
            throw new IllegalArgumentException("Endereço mal introduzido");
        }
    }
}
