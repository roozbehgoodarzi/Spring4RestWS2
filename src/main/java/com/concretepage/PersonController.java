package com.concretepage;

import com.ocs.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Goodarzi on 02/28/2015.
 */
@RestController
@RequestMapping //("/service")
public class PersonController {
    @Autowired
    PersonServiceRunner personServiceRunner;


    //    @RequestMapping("/persons/savePerson")
    @RequestMapping(value = "/persons/savePerson", method = RequestMethod.POST)
    public void savePerson(
            @RequestParam(value = "personId", required = true) String personId,
            @RequestParam(value = "personName", required = false) String personName,
            @RequestParam(value = "personLastName", required = false) String personLastName,
            @RequestParam(value = "personNationalId", required = true) String personNationalId
    ) {
        Person person = new Person();
        person.setPersonId(personId);
        person.setNationalId(personNationalId);
        person.setFirstName(personName);
        person.setLastName(personLastName);
        personServiceRunner.savePerson(person);

    }


//    //    @RequestMapping("/persons/savePersonObject")
//    @RequestMapping(value = "/persons/savePersonObject", method = RequestMethod.GET)
//    public void savePersonObject(@RequestBody Person person) {
//        personServiceRunner.savePerson(person);
//    }

    @RequestMapping(value = "/persons", method = RequestMethod.POST, headers="Accept=application/json")
         public void savePersonObject(@RequestBody Person person) {
        System.out.println("hey hey hey");
//        personServiceRunner.savePerson(person);
        personServiceRunner.saveOrUpdate(person);
    }

//    //    @RequestMapping("/persons/getPersonByPersonID")
//    @RequestMapping("/persons/getPersonByPersonID")
//    public Person getPersonByPersonID(@RequestParam(value = "unitEmployCode", required = true) String unitEmployCode) {
//        return personServiceRunner.getPersonByPersonID(unitEmployCode);
//    }
//
//    //    @RequestMapping("/persons/getPersonByNationalId")
//    @RequestMapping("/persons/getPersonByNationalId")
//    public Person getPersonByNationalId(@RequestParam(value = "nationalId", required = true) String nationalId) {
//        return personServiceRunner.getPersonByNationalId(nationalId);
//    }
//
//    //    @RequestMapping("/persons/getPersonByAccountId")
//    @RequestMapping("/persons/getPersonByAccountId")
//    public Person getPersonByAccountId(@RequestParam(value = "accountId", required = true) String accountId) {
//        return personServiceRunner.getPersonByAccountId(accountId);
//    }

//    //    @RequestMapping("/persons/getPersonByParameter")
//    @RequestMapping(value = "/persons/getPersonByParameter", method = RequestMethod.POST)
//    public Person getPersonByParameter(
//            @RequestParam(value = "param1", required = true) String parameterType,
//            @RequestParam(value = "param2", required = true) String parameterValue) {
//        return personServiceRunner.getPersonByParameter(parameterType, parameterValue);
//    }

    @RequestMapping(value = "/persons/{param1}/{param2}", method = RequestMethod.GET)
    public Person getPersonByParameter(
            @PathVariable("param1") String param1,
            @PathVariable("param2") String param2) {
        return personServiceRunner.getPersonByParameter(param1, param2);
    }

//    @RequestMapping(value = "/persons/getPersonByParameter/param1/{param1}/param2/{param2}", method = RequestMethod.GET)
//    public Person getPersonByParameterGetService(@PathVariable("param1") String param1, @PathVariable("param2") String param2) {
//        return personServiceRunner.getPersonByParameter(param1, param2);
//    }

}
