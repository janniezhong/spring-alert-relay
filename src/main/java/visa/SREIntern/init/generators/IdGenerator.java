package visa.SREIntern.init.generators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import visa.SREIntern.init.AlertRelayApplication;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Class to generate a unique BigInteger id based on the time
 */
public class IdGenerator {

    private AtomicLong idSerial = new AtomicLong();
    private static final String ID_FORMAT = "%012d%04d";
    private static final Logger LOGGER = LogManager.getLogger(IdGenerator.class);


    /**
     * The only instance of the IdGenerator to be accessed from outside the class.
     */
    public static final IdGenerator INSTANCE = new IdGenerator();

    private IdGenerator() {}

    /**
     * Method to generate a BigInteger id.
     * @return the generated id
     */
    public BigInteger generateNewId() {
        long serial = idSerial.getAndIncrement() % 10000;
        long milliseconds = System.currentTimeMillis() % 1000000000000L;
        String id = String.format(ID_FORMAT, milliseconds, serial);
        LOGGER.info("Unique id for alert generated: " + id);
        return new BigInteger(id);
    }

}