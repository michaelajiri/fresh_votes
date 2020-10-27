package com.freshvotes.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Vote {
	
	private VoteId pk;
	private Boolean upVote;
	
	@EmbeddedId
	public VoteId getPk() {
		return pk;
	}
	
	public void setPk(VoteId pk) {
		this.pk = pk;
	}
	
	public Boolean getUpVote() {
		return upVote;
	}
	
	public void setUpVote(Boolean upVote) {
		this.upVote = upVote;
	}
}