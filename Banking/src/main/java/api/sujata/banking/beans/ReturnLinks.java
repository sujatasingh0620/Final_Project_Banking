package api.sujata.banking.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ReturnLinks {
	@Id
	@GeneratedValue
	private int id;
	private String rel;
	private String href;
	private String method;
	
	public Transaction getTransaction() {
		return transaction;
	}


	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	@ManyToOne
	@JsonIgnore
	private Transaction transaction;
	
	public ReturnLinks() {
		super();
	}
	
	
	public ReturnLinks(int id, String rel, String href, String method) {
		super();
		this.id = id;
		this.rel = rel;
		this.href = href;
		this.method = method;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	@Override
	public String toString() {
		return "ReturnLinks [id=" + id + ", rel=" + rel + ", href=" + href + ", method=" + method + "]";
	}


}
