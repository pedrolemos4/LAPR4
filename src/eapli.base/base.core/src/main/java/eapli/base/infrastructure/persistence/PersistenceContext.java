/**
 *
 */
package eapli.base.infrastructure.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eapli.base.Application;
import eapli.framework.util.Utility;

import java.lang.reflect.InvocationTargetException;

/**
 * provides easy access to the persistence layer. works as a factory of
 * factories
 *
 * @author Paulo Gandra Sousa
 */
@Utility
public final class PersistenceContext {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersistenceContext.class);

    private static RepositoryFactory theFactory;

    private PersistenceContext() {
        // ensure utility
    }

    public static RepositoryFactory repositories() {
        if (theFactory == null) {
            final String factoryClassName = Application.settings().getRepositoryFactory();
            try {
                theFactory = (RepositoryFactory) Class.forName(factoryClassName).getDeclaredConstructor().newInstance();
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | IllegalArgumentException
                    | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
                LOGGER.error("Unable to dynamically load the Repository Factory", ex);
                throw new IllegalStateException(
                        "Unable to dynamically load the Repository Factory: " + factoryClassName, ex);
            }
        }
        return theFactory;
    }
}
