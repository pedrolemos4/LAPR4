package eapli.base.colaborador.domain;

import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class FuncaoSet implements Set<FuncaoAssignment>, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue // (strategy = GenerationType.IDENTITY)
    private Long pk;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private final Set<FuncaoAssignment> assignments = new HashSet<>();

    @Override
    public boolean add(final FuncaoAssignment arg0) {
        Preconditions.nonNull(arg0);

        // TODO validations are missing, e.g., no overlap in roles with the same
        // role type
        return assignments.add(arg0);
    }

    /**
     * Checks if a user currently has an assignment of a certain role.
     *
     * @param r
     * @return true if a user currently has an assignment of a certain role
     */
    public boolean hasAssignment(final FuncaoColaborador r) {
        for (final FuncaoAssignment assignment : assignments) {
            if (!assignment.isExpired() && assignment.isOf(r)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the user has or had in the past an assignment to a certain
     * role.
     *
     * @param r
     * @return true if the user has or had in the past an assignment to a
     *         certain role
     */
    public boolean hasOrHadAssignment(final FuncaoColaborador r) {
        for (final FuncaoAssignment assignment : assignments) {
            if (assignment.isOf(r)) {
                return true;
            }
        }
        return false;
    }

    public Collection<FuncaoColaborador> roleTypes() {
        final List<FuncaoColaborador> ret = new ArrayList<>();
        assignments.forEach(role -> ret.add(role.type()));
        return ret;
    }

    /**
     * Returns the first non-expired assignment to a role or an empty optional
     * if no assignment to that role exists.
     *
     * <p>
     * The implementation uses the java Stream API, but is conceptually
     * equivalent to the following more traditional java code:
     *
     * <pre>
     * <code>
     * for (final RoleAssignment assignment : data) {
     *     if (assignment.isOf(role)) {
     *         return Optional.of(assignment);
     *     }
     * }
     * return Optional.empty();
     * </code>
     * </pre>
     *
     * @param role
     * @return the first non-expired assignment to a role or an empty optional
     */
    public Optional<FuncaoAssignment> getAssignment(final FuncaoColaborador role) {
        return assignments.stream().filter(e -> !e.isExpired() && e.isOf(role)).findFirst();
    }

    @Override
    public boolean addAll(final Collection<? extends FuncaoAssignment> arg0) {
        return assignments.addAll(arg0);
    }

    @Override
    public void clear() {
        assignments.clear();
    }

    @Override
    public boolean contains(final Object arg0) {
        return assignments.contains(arg0);
    }

    @Override
    public boolean containsAll(final Collection<?> arg0) {

        return assignments.containsAll(arg0);
    }

    @Override
    public boolean isEmpty() {
        return assignments.isEmpty();
    }

    @Override
    public Iterator<FuncaoAssignment> iterator() {
        return assignments.iterator();
    }

    @Override
    public boolean remove(final Object arg0) {
        return assignments.remove(arg0);
    }

    @Override
    public boolean removeAll(final Collection<?> arg0) {
        return assignments.removeAll(arg0);
    }

    @Override
    public boolean retainAll(final Collection<?> arg0) {
        return assignments.retainAll(arg0);
    }

    @Override
    public int size() {
        return assignments.size();
    }

    @Override
    public Object[] toArray() {
        return assignments.toArray();
    }

    @Override
    public <T> T[] toArray(final T[] arg0) {
        return assignments.toArray(arg0);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FuncaoSet)) {
            return false;
        }

        final FuncaoSet roles = (FuncaoSet) o;

        // we need to perform a deep equals() as we want to compare values and
        // not object instances, so we cannot do this.data.equals(roles.data)
        for (final FuncaoAssignment r : assignments) {
            boolean found = false;
            for (final FuncaoAssignment or : roles.assignments) {
                if (r.equals(or)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(assignments).code();
    }

}
