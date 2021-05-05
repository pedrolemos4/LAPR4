package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Cor implements ValueObject {
    private static final long serialVersionUID = 1L;

    private final int r;
    private final int g;
    private final int b;

    public Cor(final int red, final int green, final int blue) {
        Preconditions.ensure(red >= 0, "Red can't be negative");
        Preconditions.ensure(green >= 0, "Green can't be negative");
        Preconditions.ensure(blue >= 0, "Blue can't be negative");
        this.r = red;
        this.g = green;
        this.b = blue;
    }

    protected Cor() {
        this.r = -1;
        this.g = -1;
        this.b = -1;
    }

    public static Cor valueOf (final int red, final int green, final int blue) {
        return new Cor(red, green , blue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cor cor = (Cor) o;
        return r == cor.r && g == cor.g && b == cor.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, g, b);
    }

    @Override
    public String toString() {
        return "Cor: " + "r=" + r + ", g=" + g + ", b=" + b;
    }
}
