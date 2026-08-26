package owaspJuiceShop.configUtility.propertyReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static owaspJuiceShop.utility.constants.communConstants.CommunConstants.CONFIG_FILE;

public class PropertyReader {
    private static final Log log = LogFactory.getLog(PropertyReader.class);
    static Properties prop;

    static {
        prop = new Properties();
        try {
            FileInputStream file = new FileInputStream(CONFIG_FILE);
            prop.load(file);
            log.info("File is loaded succesfully");
            file.close();
        } catch (IOException e) {
            log.error("could not find the property file: !");
            throw new RuntimeException(e);
        }

    }


    public static String getPropertyFromConfigFile(String key) {

        return prop.getProperty(key);
    }


}
