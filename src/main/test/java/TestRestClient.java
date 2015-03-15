import com.ocs.entity.Person;
import junit.framework.TestCase;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Goodarzi on 03/03/2015.
 */
public class TestRestClient extends TestCase {
    public static final String SERVER_URI = "http://localhost:8080/service/savePersonObject";
    public void testCreatePerson(){
        RestTemplate restTemplate = new RestTemplate();
        Person person = new Person();
        person.setPersonId("65454545");
        person.setNationalId("8796464");
        person.setFirstName("Hamed");
        person.setLastName("Mirzaei");
        restTemplate.postForLocation(SERVER_URI,person);
        System.out.println("********");

    }

    public void testPersonFetchByEmployeeId(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/service/getPersonByPersonID";
        Person person = restTemplate.getForObject(url, Person.class, "132");
        System.out.println("person.getFirstName() = " + person.getFirstName());

    }
}
