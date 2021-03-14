package api.sujata.banking.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CardExpiry {
	@Id
	@GeneratedValue
	private int id;
	private String month;
	private String year;
	@OneToOne(mappedBy = "cardExpiry")
	@JsonIgnore
	private Card card;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public CardExpiry() {
		super();
	}
	public CardExpiry(int id, String month, String year) {
		super();
		this.id = id;
		this.month = month;
		this.year = year;
	}
}
