package IO;

import org.models.FullInfo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlWriter {
    private static final Logger logger = Logger.getLogger(XmlWriter.class.getName());
    private XmlWriter(){
    }

    public static void generateXmlReq(FullInfo fullinfo){

        try{
            logger.log(Level.INFO, "Xml marshalling started");
            JAXBContext jaxbContext = JAXBContext.newInstance(FullInfo.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            try{
                Files.createDirectories(Paths.get("xmlReqs"));
                logger.log(Level.INFO, "Directory created successfully");
            }catch (IOException ioException){
                logger.log(Level.FINE, "Directory already created", ioException);
            }
            File requestFile = new File("xmlReqs/infoReq" + new Date().getTime() +".xml");

            marshaller.marshal(fullinfo, requestFile);
        } catch (JAXBException jaxbException) {
            logger.log(Level.SEVERE, "XML marshalling failed", jaxbException);
            return;
        }

        logger.log(Level.INFO, "XML marshalling finished successfully");
    }
}
