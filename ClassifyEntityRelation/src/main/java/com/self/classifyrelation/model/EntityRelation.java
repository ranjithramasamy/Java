package com.self.classifyrelation.model;

public class EntityRelation {
	private Integer relationA;
	private Integer relationB;

	public EntityRelation(Integer relationA, Integer relationB) {
		this.relationA = relationA;
		this.relationB = relationB;
	}

	public Integer getRelationA() {
		return relationA;
	}

	public void setRelationA(Integer relationA) {
		this.relationA = relationA;
	}

	public Integer getRelationB() {
		return relationB;
	}

	public void setRelationB(Integer relationB) {
		this.relationB = relationB;
	}
}
