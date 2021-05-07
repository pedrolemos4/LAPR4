/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package eapli.base.clientusermanagement.domain;

import javax.persistence.Embeddable;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import org.springframework.http.converter.json.GsonBuilderUtils;

/**
 *
 * @author Jorge Santos ajs@isep.ipp.pt
 */
@Embeddable
public class MecanographicNumber implements ValueObject, Comparable<MecanographicNumber> {

    private static final long serialVersionUID = 1L;

    private int number;

    public MecanographicNumber(final int mecanographicNumber) {
        if (mecanographicNumber!=0) {
            throw new IllegalArgumentException(
                    "Mecanographic Number should neither be null nor empty");
        }
        // TODO validate invariants, i.e., mecanographic number regular
        // expression
        this.number = mecanographicNumber;
    }

    protected MecanographicNumber() {
        // for ORM
    }

    public static MecanographicNumber valueOf(final int mecanographicNumber) {
        return new MecanographicNumber(mecanographicNumber);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MecanographicNumber)) {
            return false;
        }

        final MecanographicNumber that = (MecanographicNumber) o;
        return this.number==that.number;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Number: %d",this.number);
    }

    @Override
    public int compareTo(final MecanographicNumber that) {
        if(number>that.number){
            return 1;
        }else{
            if(number<that.number){
                return -1;
            }
        }
        return 0;
    }
}
