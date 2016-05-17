package common;

import lazy.test.ui.browser.BrowserEmulator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

@ContextConfiguration(locations = "classpath*:/spring/spring-test.xml")
public class BaseTestCase extends AbstractTestNGSpringContextTests {
    private static final Logger logger = LoggerFactory.getLogger(BaseTestCase.class);

    protected static BrowserEmulator be;

    @BeforeClass()
    public void doBeforeClassBase() {
        logger.info("Open BrowserEmulator");

        if(be == null){
            be = new BrowserEmulator();
        } else {
            logger.info("BrowserEmulator already opened");
        }
    }

    @AfterSuite(alwaysRun=true)
    public void tearDownBase() {
        logger.info("Close BrowserEmulator");

        if(be != null){
            be.quit();
            be = null;
        }
    }

}
