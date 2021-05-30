/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.daemon.motor.protocol;

import eapli.base.atividades.application.AplicacoesController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.*;


public class NumeroTarefasPendentesRequestTest extends AplicacoesRequestTest{

    private static final Logger LOGGER = LogManager.getLogger(NumeroTarefasPendentesRequestTest.class);

    // semantic error
    private static final String[] SEMANTIC_ERROR_FIXTURES = {
            // empty dados
            "0, 5, 0, ,",

    };
    
    public NumeroTarefasPendentesRequestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    @Before
    public void setup() {
        setMockControllerUnknowns();
    }

    @Test
    public void ensureOkReturnsNTarefasRequest() throws ParseException {
        setMockControllerNoData1();

        final AplicacoesRequest req = AplicacoesMessageParser
                .parse("119080",5);

        final String result = req.execute();
        LOGGER.info("{} -> {}", 5, result);

        /*final String[] lines = result.split("\n");
        assertEquals(1, lines.length);

        final String[] tokens = CsvLineMarshaler.tokenize(lines[0]).toArray(new String[0]);
        assertEquals(2, tokens.length);
        assertEquals('\n', result.charAt(result.length() - 1));*/
    }


    @Override
    protected String[] getSemanticErrorFixtures() {
        return SEMANTIC_ERROR_FIXTURES;
    }
    
}
