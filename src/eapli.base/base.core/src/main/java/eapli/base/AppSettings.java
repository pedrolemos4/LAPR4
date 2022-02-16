package eapli.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * the eapli.base.gestaoservicosrh.application settings.
 *
 * @author Paulo Gandra Sousa
 */
public class AppSettings {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppSettings.class);

    /*private static final String MOTOR_IP = "ip.motor.ssh2";
    private static final String MOTOR_PORT = "port.motor";
    private static final String EXECUTOR_IP = "ip.executor.ssh3";
    private static final String EXECUTOR_PORT = "port.executor";*/
    private static final String FCFS = "FCFS";
    private static final String WORKLOAD = "WORKLOAD";
    private static final String ATM = "ATM";
    private static final String ALGORITMO_ATRIBUIR_COLABORADORES = "algoritmo.atribuir.colaboradores";
    private static final String ALGORITMO_ATRIBUIR_TAREFA_AUTOMATICA = "algoritmo.atribuir.tarefa.automatica";
    private static final String METODO_VERIFICACAO_GRAMATICA = "metodo.verificacao.gramatica";
    private static final String PROPERTIES_RESOURCE = "application.properties";
    private static final String REPOSITORY_FACTORY_KEY = "persistence.repositoryFactory";
    private static final String UI_MENU_LAYOUT_KEY = "ui.menu.layout";
    private static final String PERSISTENCE_UNIT_KEY = "persistence.persistenceUnit";
    private static final String SCHEMA_GENERATION_KEY = "javax.persistence.schema-generation.database.action";
    private static final String HIGH_CALORIES_DISH_LIMIT = "HighCaloriesDishLimit";

    private final Properties applicationProperties = new Properties();

    public AppSettings() {
        loadProperties();
    }

    private void loadProperties() {
        try (InputStream propertiesStream = this.getClass().getClassLoader()
                .getResourceAsStream(PROPERTIES_RESOURCE)) {
            if (propertiesStream != null) {
                this.applicationProperties.load(propertiesStream);
            } else {
                throw new FileNotFoundException(
                        "property file '" + PROPERTIES_RESOURCE + "' not found in the classpath");
            }
        } catch (final IOException exio) {
            setDefaultProperties();

            LOGGER.warn("Loading default properties", exio);
        }
    }

    private void setDefaultProperties() {
        this.applicationProperties.setProperty(REPOSITORY_FACTORY_KEY,
                "eapli.base.persistence.jpa.JpaRepositoryFactory");
        this.applicationProperties.setProperty(UI_MENU_LAYOUT_KEY, "horizontal");
        this.applicationProperties.setProperty(PERSISTENCE_UNIT_KEY, "eapli"
                + ".base");
        this.applicationProperties.setProperty(HIGH_CALORIES_DISH_LIMIT, "300");
        this.applicationProperties.setProperty(ALGORITMO_ATRIBUIR_COLABORADORES,FCFS);
        this.applicationProperties.setProperty(ALGORITMO_ATRIBUIR_TAREFA_AUTOMATICA,FCFS);
        this.applicationProperties.setProperty(METODO_VERIFICACAO_GRAMATICA,"listener");
        /*this.applicationProperties.setProperty(EXECUTOR_IP,"10.8.0.82");
        this.applicationProperties.setProperty(MOTOR_IP,"10.8.0.81");*/
    }

    public Boolean isMenuLayoutHorizontal() {
        return "horizontal"
                .equalsIgnoreCase(this.applicationProperties.getProperty(UI_MENU_LAYOUT_KEY));
    }

    public String getPersistenceUnitName() {
        return this.applicationProperties.getProperty(PERSISTENCE_UNIT_KEY);
    }

    public String getRepositoryFactory() {
        return this.applicationProperties.getProperty(REPOSITORY_FACTORY_KEY);
    }

    public Integer getHighCaloriesDishLimit() {
        return Integer.valueOf(this.applicationProperties.getProperty(HIGH_CALORIES_DISH_LIMIT));
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Map getExtendedPersistenceProperties() {
        final Map ret = new HashMap();
        ret.put(SCHEMA_GENERATION_KEY,
                this.applicationProperties.getProperty(SCHEMA_GENERATION_KEY));
        return ret;
    }

    public String getProperty(String prop) {
        return this.applicationProperties.getProperty(prop);
    }

    public String getAlgoritmoAtribuirColaboradores(){
        return this.applicationProperties.getProperty(ALGORITMO_ATRIBUIR_COLABORADORES);
    }

    public String getAlgoritmoAtribuirTarefaAutomatica(){
        return this.applicationProperties.getProperty(ALGORITMO_ATRIBUIR_TAREFA_AUTOMATICA);
    }

    public String getMetodoVerificacaoGramatica(){
        return this.applicationProperties.getProperty(METODO_VERIFICACAO_GRAMATICA);
    }
    /*public String getIpExecutor(){
        return this.applicationProperties.getProperty(EXECUTOR_IP);
    }

    public String getIpMotor(){
        return this.applicationProperties.getProperty(MOTOR_IP);
    }

    public int getPortMotor(){
        return Integer.parseInt(this.applicationProperties.getProperty(MOTOR_PORT));
    }

    public int getPortExecutor(){
        return Integer.parseInt(this.applicationProperties.getProperty(EXECUTOR_PORT));
    }*/
}
