package eapli.base.pedido.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;
import java.io.File;

@Embeddable
public class Ficheiro implements ValueObject {

    @Lob
    @Basic(fetch = FetchType.LAZY)
    File annexedFiles;

    public Ficheiro() {

    }

}
