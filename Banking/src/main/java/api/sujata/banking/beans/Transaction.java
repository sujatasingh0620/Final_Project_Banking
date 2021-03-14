package api.sujata.banking.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Transaction {
	@Id
	private String id;
	private int amount;
	private String merchantRefNum;
	private String action;
	private String currencyCode;
	private String usage;
	private String status;
	private int timeToLiveSeconds;
	private String transactionType;
	private String paymentType;
	private String executionMode;
	private String customerIp;
	private String paymentHandleToken;
	
	@OneToOne(cascade = CascadeType.ALL)
	private BillingDetails billingDetails;
	@OneToOne(cascade = CascadeType.ALL)
	private Card card;
	@OneToMany(cascade = {CascadeType.ALL})
	List<ReturnLinks> returnLinks=new ArrayList<>();
	


	public List<ReturnLinks> getReturnLinks() {
		return returnLinks;
	}

	public void setReturnLinks(List<ReturnLinks> returnLinks) {
		this.returnLinks = returnLinks;
	}

	public Card getCard() {
		
		return card;
	}
	
	public Transaction() {
		super();
		//this.returnLinks=new ArrayList<ReturnLinks>();
	}
 public Transaction(String id, int amount, String merchantRefNum, String action, String currencyCode, String usage,
			String status, int timeToLiveSeconds, String transactionType, String paymentType, String executionMode,
			String customerIp, String paymentHandleToken, BillingDetails billingDetails, Card card,
			List<ReturnLinks> returnLinks) {
		super();
		this.id = id;
		this.amount = amount;
		this.merchantRefNum = merchantRefNum;
		this.action = action;
		this.currencyCode = currencyCode;
		this.usage = usage;
		this.status = status;
		this.timeToLiveSeconds = timeToLiveSeconds;
		this.transactionType = transactionType;
		this.paymentType = paymentType;
		this.executionMode = executionMode;
		this.customerIp = customerIp;
		this.paymentHandleToken = paymentHandleToken;
		this.billingDetails = billingDetails;
		this.card = card;
	//	this.returnLinks = returnLinks;
	}

public void setCard(Card card) {
		this.card = card;
	}
	public BillingDetails getBillingDetails() {
		return billingDetails;
	}
	public void setBillingDetails(BillingDetails billingDetails) {
		this.billingDetails = billingDetails;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getMerchantRefNum() {
		return merchantRefNum;
	}
	public void setMerchantRefNum(String merchantRefNum) {
		this.merchantRefNum = merchantRefNum;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTimeToLiveSeconds() {
		return timeToLiveSeconds;
	}
	public void setTimeToLiveSeconds(int timeToLiveSeconds) {
		this.timeToLiveSeconds = timeToLiveSeconds;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getExecutionMode() {
		return executionMode;
	}
	public void setExecutionMode(String executionMode) {
		this.executionMode = executionMode;
	}
	public String getCustomerIp() {
		return customerIp;
	}
	public void setCustomerIp(String customerIp) {
		this.customerIp = customerIp;
	}
	public String getPaymentHandleToken() {
		return paymentHandleToken;
	}
	public void setPaymentHandleToken(String paymentHandleToken) {
		this.paymentHandleToken = paymentHandleToken;
	}
	
	
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", amount=" + amount + ", merchantRefNum=" + merchantRefNum + ", action="
				+ action + ", currencyCode=" + currencyCode + ", usage=" + usage + ", status=" + status
				+ ", timeToLiveSeconds=" + timeToLiveSeconds + ", transactionType=" + transactionType + ", paymentType="
				+ paymentType + ", executionMode=" + executionMode + ", customerIp=" + customerIp
				+ ", paymentHandleToken=" + paymentHandleToken + "]";
	}

}
