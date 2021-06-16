/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.daemon.executor.protocol;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.*;

/**
 *
 * @author pedro
 */
public class ExecutorTarefaAutomaticaTest {

    public ExecutorTarefaAutomaticaTest() {
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

    private static final Logger LOGGER = LogManager.getLogger(ExecutorTarefaAutomaticaTest.class);

    // semantic error
    private static final String[] SEMANTIC_ERROR_FIXTURES = {
            // empty dados
            "0, 9, 0, ,",

    };

    /*@Test
    public void ensureOkReturnsEstadoFluxo() throws ParseException {

        final ExecutorProtocolRequest request = ExecutorProtocolMessageParser
                .parse("cod007",9);

        final byte[] result = request.execute();
        LOGGER.info("{} -> {}", 9, result);

        /*final String[] lines = result.split("\n");
        assertEquals(1, lines.length);

        final String[] tokens = CsvLineMarshaler.tokenize(lines[0]).toArray(new String[0]);
        assertEquals(2, tokens.length);
        assertEquals('\n', result.charAt(result.length() - 1));*/
    //}

}
