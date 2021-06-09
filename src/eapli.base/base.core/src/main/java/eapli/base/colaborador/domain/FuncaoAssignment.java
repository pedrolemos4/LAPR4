package eapli.base.colaborador.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.time.util.Calendars;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Optional;

@Entity
public class FuncaoAssignment implements ValueObject, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue // (strategy = GenerationType.IDENTITY)
    private Long pk;

    private final FuncaoColaborador type;

    @Temporal(TemporalType.DATE)
    private final Calendar assignedOn;

    @Temporal(TemporalType.DATE)
    private Calendar unassignedOn;

    private boolean expired;

    /**
     *
     * @param type
     */
    public FuncaoAssignment(final FuncaoColaborador type) {
        this(type, Calendars.now());
    }

    /**
     *
     * @param type
     * @param assignedOn
     */
    public FuncaoAssignment(final FuncaoColaborador type, final Calendar assignedOn) {
        Preconditions.noneNull(type, assignedOn);

        this.type = type;
        this.assignedOn = assignedOn;
        expired = false;
    }

    protected FuncaoAssignment() {
        // for ORM
        type = null;
        assignedOn = null;
    }

    /**
     *
     * @return
     */
    public boolean isExpired() {
        return expired;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FuncaoAssignment)) {
            return false;
        }

        final FuncaoAssignment other = (FuncaoAssignment) o;
        final boolean b = type == other.type && assignedOn.equals(other.assignedOn) && expired == other.expired;
        if (!b) {
            return false;
        }

        return ((unassignedOn != null && unassignedOn.equals(other.unassignedOn))
                || unassignedOn == null && other.unassignedOn == null);
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(type).with(assignedOn).with(expired).with(unassignedOn).code();
    }

    @Override
    public String toString() {
        return type + "@" + assignedOn;
    }

    /**
     *
     * @return
     */
    public FuncaoColaborador type() {
        return type;
    }

    /**
     *
     * @param r
     * @return
     */
    public boolean isOf(final FuncaoColaborador r) {
        return type.equals(r);
    }

    /**
     * Unassigns this role, marking it as expired.
     *
     * @return false if the role was already expired.
     */
    public boolean unassign() {
        if (expired) {
            return false;
        }

        expired = true;
        unassignedOn = Calendars.now();
        return true;
    }

    /**
     *
     * @return
     * @deprecated use {@link #unassignedOn}
     */
    @Deprecated(forRemoval = true)
    public Optional<Calendar> getUnassignedOn() {
        return unassignedOn();
    }

    /**
     *
     * @return
     */
    public Optional<Calendar> unassignedOn() {
        return Optional.ofNullable(unassignedOn);
    }

}
