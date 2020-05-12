package com.test.trading.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "transaction")
@EntityListeners(AuditingEntityListener.class)
public class Transaction {

	
	
	// starts  here 
	private long id;
	private String tradeID;
	private int versionID;
	private String counter_PartyID;
	private String bookID;
	private String maturityDT;
	private String createdDT;
	private boolean expired;
	private String prevVersion;
	private String prevTradeID;
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTradeID() {
		return tradeID;
	}
	public void setTradeID(String tradeID) {
		this.tradeID = tradeID;
	}
	public int getVersionID() {
		return versionID;
	}
	public void setVersionID(int versionID) {
		this.versionID = versionID;
	}
	public String getCounter_PartyID() {
		return counter_PartyID;
	}
	public void setCounter_PartyID(String counter_PartyID) {
		this.counter_PartyID = counter_PartyID;
	}
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	
	  public String getMaturityDT()
	  { return maturityDT; } 
	  public void setMaturityDT(String maturityDT) 
	  { this.maturityDT = maturityDT; } 
	  public String getCreatedDT() 
	  { return createdDT; } 
	  public void setCreatedDT(String createdDT)
	  { this.createdDT = createdDT; }
	 
	public boolean isExpired() {
		return expired;
	}
	public void setExpired(boolean expired) {
		this.expired = expired;
	}
	public String getPrevTradeID() {
		return prevTradeID;
	}
	public void setPrevTradeID(String prevTradeID) {
		this.prevTradeID = prevTradeID;
	}
	
	// ends here
}
