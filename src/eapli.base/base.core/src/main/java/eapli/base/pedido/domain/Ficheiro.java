package eapli.base.pedido.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;
import java.io.File;

@Embeddable
public class Ficheiro implements ValueObject {

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "Ficheiro")
    File annexedFile;

    public Ficheiro() {
        //for ORM
    }

    public Ficheiro(File annexedFile) {
        this.annexedFile = annexedFile;
    }

    @Override
    public String toString() {
        return "Ficheiro{" +
                "annexedFile=" + annexedFile +
                '}';
    }
}
