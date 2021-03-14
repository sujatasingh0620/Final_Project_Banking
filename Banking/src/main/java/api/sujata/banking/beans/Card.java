package api.sujata.banking.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Card {
	@Id
	@GeneratedValue
	private int id;
	@OneToOne(cascade = CascadeType.ALL)
	private CardExpiry cardExpiry;
	public Card() {
		super();
	}
	@Override
	public String toString() {
		return "Card [id=" + id + ", cardExpiry=" + cardExpiry + ", holderName=" + holderName + ", cardType=" + cardType
				+ ", cardBin=" + cardBin + ", lastDigits=" + lastDigits + ", transaction=" + transaction + ", getId()="
				+ getId() + ", getCardExpiry()=" + getCardExpiry() + ", getHolderName()=" + getHolderName()
				+ ", getCardType()=" + getCardType() + ", getCardBin()=" + getCardBin() + ", getLastDigits()="
				+ getLastDigits() + ", getTransaction()=" + getTransaction() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CardExpiry getCardExpiry() {
		return cardExpiry;
	}
	public void setCardExpiry(CardExpiry cardExpiry) {
		this.cardExpiry = cardExpiry;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardBin() {
		return cardBin;
	}
	public void setCardBin(String cardBin) {
		this.cardBin = cardBin;
	}
	public String getLastDigits() {
		return lastDigits;
	}
	public void setLastDigits(String lastDigits) {
		this.lastDigits = lastDigits;
	}
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	public Card(int id, String holderName, String cardType, String cardBin, String lastDigits,
			Transaction transaction) {
		super();
		this.id = id;
		this.holderName = holderName;
		this.cardType = cardType;
		this.cardBin = cardBin;
		this.lastDigits = lastDigits;
		this.transaction = transaction;
	}
	private String holderName;
	private String cardType;
	private String cardBin;
	private String lastDigits;
	@OneToOne(mappedBy = "card")
	@JsonIgnore
	private Transaction transaction;
	
}
