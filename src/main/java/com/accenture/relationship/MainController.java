package com.accenture.relationship;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accenture.relationship.entity.Person;
import com.accenture.relationship.entity.RelationshipsMap;
import com.accenture.relationship.service.PersonService;

@Controller
@RequestMapping(value = "/")
public class MainController {
	@Autowired
	PersonService personService;

	
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public  @ResponseBody List<Person> getPersons(Map<String, Object> model) {
	
		List<Person> personList = personService.getListOfPersons();
				
		return personList;
	}
	
	@RequestMapping(value = "/persons/relationship/{personId}", method = RequestMethod.GET)
	public  @ResponseBody RelationshipsMap getPersonrelationships(Map<String, Object> model, @PathVariable String personId) {
	
		RelationshipsMap map = personService.getRelationshipForPersonId(Long.parseLong(personId));
		return map;
	}
	
	@RequestMapping(value = "/persons/{personId}", method = RequestMethod.GET)
	public  @ResponseBody Person getPerson(Map<String, Object> model, @PathVariable String personId) {
	
		return personService.getPerson(Long.parseLong(personId));
	}
	
	@RequestMapping(value = "/**", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {

		System.out.println("index() is executed!");

		model.put("title", "This is title");
		model.put("msg", "This is descr");
		
		return "index.html";
	}
	
	private Person createPerson(Long id, String name, Long group, String href){
		Person person = new Person();
		
		person.setId(id);
		person.setName(name);
		person.setGroup(group);
		person.setHref(href);
		
		return person;
	}
}