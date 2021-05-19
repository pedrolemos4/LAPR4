package eapli.base.colaborador.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Data implements ValueObject {

    @Column(name="ANO")
    private final int ano;

    @Column(name="MES")
    private final int mes;

    @Column(name="DIA")
    private final int dia;

    public Data (final int ano, final int mes, final int dia){
        if( ano>0 && 2022>ano && 12>=mes && mes>0 && 32>dia && dia>0) {
            this.ano = ano;
            this.mes = mes;
            this.dia = dia;
        }else{
            throw new IllegalArgumentException("Data mal inserida");
        }
    }

    protected Data() {
        this.mes=0;
        this.ano=0;
        this.dia=0;
    }

    @Override
    public String toString() {
        return "Data{" +
                "ano=" + ano +
                ", mes=" + mes +
                ", dia=" + dia +
                '}';
    }
}
