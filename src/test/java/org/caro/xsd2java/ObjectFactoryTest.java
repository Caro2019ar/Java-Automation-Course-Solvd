package org.caro.xsd2java;



import org.caro.xsd2java.Users.User;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ObjectFactoryTest {
    Logger logger = Logger.getLogger(ObjectFactoryTest.class);
    Users users = new ObjectFactory().createUsers();

    @BeforeTest
    public void createUsers() {
        User user = new Users.User();
        user.setId(1);
        user.setFirstname("Joao");
        user.setLastname("da Silva");

        users.getUser(); // creates arraylist if null
        users.user.add(user);

        User user2 = new Users.User();
        user2.setId(2);
        user2.setFirstname("Lucas");
        user2.setLastname("Lopez");

        users.user.add(user2);

        User user3 = new Users.User();
        user3.setId(3);
        user3.setFirstname("Veronica");
        user3.setLastname("Ramirez Lupita");

        users.user.add(user3);
    }

    @Test
    public void testMarshalUsers() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        //marshaller.marshal(users, System.out); //--to check in console
        marshaller.marshal(users, new File("src/main/resources/marshalling.xml"));
    }

    @Test(dependsOnMethods = "testMarshalUsers")
    public void testUnmarshalXML() throws JAXBException {
        File file = new File("src/main/resources/marshalling.xml");
        JAXBContext context = JAXBContext.newInstance(Users.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        if (unmarshaller.unmarshal(file) instanceof Users) {
            Users users = (Users) unmarshaller.unmarshal(file);
            for (Users.User user : users.user
            ) {
                logger.info("User id: " + user.id);
                logger.info("Firstname: " + user.firstname);
                logger.info("Lastname: " + user.lastname);
            }
        }

    }
}
