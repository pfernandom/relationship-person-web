package com.accenture.relationship.entity;

import java.util.ArrayList;
import java.util.List;

public class RelationshipsMap {
	private List<Person> nodes = new ArrayList<Person>();
	private List<Link> links = new ArrayList<Link>();

	public List<Person> getNodes() {
		return nodes;
	}

	public void setNodes(List<Person> nodes) {
		this.nodes = nodes;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLink(List<Link> link) {
		this.links = link;
	}
	
	public void addNode(Person person){
		nodes.add(person);
	}
	
	public void addLink(Link link){
		links.add(link);
	}

}
