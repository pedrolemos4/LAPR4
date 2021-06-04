/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.daemon.motor.protocol;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.*;

public class EstadoFluxoRequestTest extends AplicacoesRequestTest{

    private static final Logger LOGGER = LogManager.getLogger(EstadoFluxoRequestTest.class);

    // semantic error
    private static final String[] SEMANTIC_ERROR_FIXTURES = {
            // empty dados
            "0, 4, 0, ,",

    };

    public EstadoFluxoRequestTest() {
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

   /*@Test
    public void ensureOkReturnsEstadoFluxo() throws ParseException {
        setMockControllerNoData();

        final AplicacoesRequest req = AplicacoesMessageParser
                .parse("cod007",4);

        final byte[] result = req.execute();
        LOGGER.info("{} -> {}", 4, result);

        /*final String[] lines = result.split("\n");
        assertEquals(1, lines.length);

        final String[] tokens = CsvLineMarshaler.tokenize(lines[0]).toArray(new String[0]);
        assertEquals(2, tokens.length);
        assertEquals('\n', result.charAt(result.length() - 1));*/
   // }


    @Override
    protected String[] getSemanticErrorFixtures() {
        return SEMANTIC_ERROR_FIXTURES;
    }

}
