package com.accenture.relationship.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.accenture.relationship.entity.Link;
import com.accenture.relationship.entity.Person;
import com.accenture.relationship.entity.RelationshipsMap;

@Component
public class PersonServiceImpl implements PersonService {
	
	RelationshipsMap relMap;
	Map<Long, Person> personMap = new HashMap<Long,Person>();
	List<Person> personList = new ArrayList<Person>();

	public List<Person> getListOfPersons() {
		personList = new ArrayList<Person>();
		personList.add(this.createPerson(1L, "Donald Cruz", 1L, "rest/persons/1", "img/face1.jpg"));
		personList.add(this.createPerson(2L, "Maria Cruz", 2L, "rest/persons/2", "img/face1.jpg"));
		personList.add(this.createPerson(3L, "Carlos Cruz", 3L, "rest/persons/3", "img/face1.jpg"));
		personList.add(this.createPerson(4L, "Shieko Cruz", 4L, "rest/persons/4", "img/face1.jpg"));
		personList.add(this.createPerson(5L, "Minoda Cruz", 5L, "rest/persons/5", "img/face1.jpg"));
		personList.add(this.createPerson(6L, "Hillary Jay", 6L, "rest/persons/6", "img/face1.jpg"));
		personList.add(this.createPerson(7L, "Bernie Marsh", 7L, "rest/persons/7", "img/face1.jpg"));
		personList.add(this.createPerson(8L, "Marco Lopez", 8L, "rest/persons/8", "img/face1.jpg"));
		return personList;
	}

	public Person getPerson(Long id) {
		for(Person person : personList){
			if(person.getId().equals(id)){
				return person;
			}
		}
		return null;
	}

	public RelationshipsMap getRelationshipForPersonId(Long id) {
		RelationshipsMap map = new RelationshipsMap();
		
		switch(id.intValue()){
		case 1:
			map = new RelationshipsMap();
			map.addNode(this.createPerson(1L, "Donald Cruz", 1L, "#/personDetail", "img/face1.jpg"));
			map.addNode(this.createPerson(2L, "Maria Cruz", 2L, "#/personDetail", "img/face1.jpg"));
			map.addNode(this.createPerson(3L, "Carlos Cruz", 3L, "#/personDetail", "img/face1.jpg"));
			map.addNode(this.createPerson(4L, "Shieko Cruz", 4L, "#/personDetail", "img/face1.jpg"));
			map.addNode(this.createPerson(5L, "Minoda Cruz", 5L, "#/personDetail", "img/face1.jpg"));
			map.addNode(this.createPerson(6L, "Hillary Jay", 6L, "#/personDetail", "img/face1.jpg"));
			map.addNode(this.createPerson(7L, "Bernie Marsh", 7L, "#/personDetail", "img/face1.jpg"));
			map.addNode(this.createPerson(8L, "Marco Lopez", 8L, "#/personDetail", "img/face1.jpg"));
		
			map.addLink(this.createLink(1L, 0L, 1L, "ajax/caseCard1.json"));
			map.addLink(this.createLink(2L, 0L, 1L, "ajax/caseCard1.json"));
			map.addLink(this.createLink(3L, 0L, 2L, "ajax/caseCard1.json"));
			map.addLink(this.createLink(4L, 3L, 8L, "ajax/caseCard1.json"));
			map.addLink(this.createLink(4L, 0L, 4L, "ajax/caseCard1.json"));
			map.addLink(this.createLink(5L, 0L, 5L, "ajax/caseCard1.json"));
			map.addLink(this.createLink(6L, 0L, 6L, "ajax/caseCard1.json"));
			map.addLink(this.createLink(7L, 0L, 7L, "ajax/caseCard1.json"));
		}
		
		return map;
	}
	
	private Person createPerson(Long id, String name, Long group, String href, String thumbUrl){
		Person person = new Person();
		
		person.setId(id);
		person.setName(name);
		person.setGroup(group);
		person.setHref(href);
		person.setThumbUrl(thumbUrl);
		
		return person;
	}
	
	private Link createLink(Long source, Long target, Long value, String href ){
		Link link = new Link();
		link.setSource(source);
		link.setTarget(target);
		link.setValue(value);
		link.setHref(href);
		return link;
	}
	
	private RelationshipsMap getTestRelMap(){
		relMap = new RelationshipsMap();
		
		List<Person> personList = new ArrayList<Person>();
		
		personList.add(this.createPerson(1L, "Donald Cruz", 1L, "ajax/miserables.json", "img/face1.jpg"));
		personList.add(this.createPerson(2L, "Maria Cruz", 2L, "ajax/miserables.json", "img/face1.jpg"));
		personList.add(this.createPerson(3L, "Carlos Cruz", 3L, "ajax/miserables.json", "img/face1.jpg"));
		personList.add(this.createPerson(4L, "Shieko Cruz", 4L, "ajax/miserables.json", "img/face1.jpg"));
		personList.add(this.createPerson(5L, "Minoda Cruz", 5L, "ajax/miserables.json", "img/face1.jpg"));
		personList.add(this.createPerson(6L, "Hillary Jay", 6L, "ajax/miserables.json", "img/face1.jpg"));
		personList.add(this.createPerson(7L, "Bernie Marsh", 7L, "ajax/miserables.json", "img/face1.jpg"));
		personList.add(this.createPerson(8L, "Marco Lopez", 8L, "ajax/miserables.json", "img/face1.jpg"));

		
		//relMap.setNodes((Person[]) personList.toArray());
		
		return relMap;
	}

}
