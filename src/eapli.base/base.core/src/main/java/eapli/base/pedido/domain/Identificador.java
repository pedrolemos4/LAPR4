
/*package eapli.base.pedido.domain;

import eapli.base.pedido.generators.IdentificadorGenerator;
import eapli.framework.domain.model.ValueObject;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Embeddable
public class Identificador  implements ValueObject,Comparable<Identificador> {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ano_seq")
    @GenericGenerator(name = "ano_seq",
            strategy = "eapli.base.pedido.generators.IdentificadorGenerator",parameters = {
            @org.hibernate.annotations.Parameter(name = IdentificadorGenerator.INCREMENT_PARAM, value = "1"),
            @org.hibernate.annotations.Parameter(name = IdentificadorGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
    })
    @Column(name = "identificador")
    private String id;

    @Override
    public String toString() {
        return "Id: " + id;
    }

    @Override
    public int compareTo(Identificador o) {
        return -1;
    }
}

 */
