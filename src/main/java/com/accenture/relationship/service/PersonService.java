package com.accenture.relationship.service;

import java.util.List;

import com.accenture.relationship.entity.Person;
import com.accenture.relationship.entity.RelationshipsMap;

public interface PersonService {
	List<Person> getListOfPersons();

	Person getPerson(Long id);

	RelationshipsMap getRelationshipForPersonId(Long id);
}
