package api.sujata.banking.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.sujata.banking.beans.Transaction;
import api.sujata.banking.Exceptions.TransactionNotFoundException;
import api.sujata.banking.beans.BillingDetails;
import api.sujata.banking.beans.Card;
import api.sujata.banking.beans.CardExpiry;
import api.sujata.banking.beans.ReturnLinks;
import api.sujata.banking.repositories.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepo;
	@Autowired
	ReturnLinksService retLinkService;
	@PostConstruct
	public void setup()
	{
		Transaction t=new Transaction();
		t.setId("26359efd-7cfb-4014-a13d-1724e3ff17fa");
		t.setAmount(1900);
		t.setMerchantRefNum("ref1");
		t.setAction("nonoe");
		t.setCurrencyCode("gbh");
		t.setUsage("single");
		t.setStatus("expire");
		t.setTimeToLiveSeconds(0);
		t.setTransactionType("paymetn");
		t.setPaymentType("card");
		t.setPaymentHandleToken("12345");
		t.setExecutionMode("synchronous");
		t.setCustomerIp("127.0.0.1");
		BillingDetails b=new BillingDetails();
		b.setCity("ca");
		b.setCountry("torootl");
		b.setId(23);
		b.setStreet1("streat 1");
		b.setStreet2("streat 32");
		b.setZip("mh");
		
		t.setBillingDetails(b);
		Card cd=new Card();
		CardExpiry ce=new CardExpiry();
		ce.setCard(cd);
		ce.setMonth("jul");
		ce.setYear("3442");
		cd.setCardBin("visa");
		cd.setCardExpiry(ce);
		cd.setCardType("Master");
		cd.setHolderName("Sujata");
		cd.setLastDigits("567");

		cd.setTransaction(t);
		t.setCard(cd);
		ArrayList<ReturnLinks> li=new ArrayList<>();
		ReturnLinks re=new ReturnLinks();
		re.setHref("abcd");
		re.setMethod("post");
		re.setRel("xyz");
		re.setTransaction(t);
		li.add(re);
		t.setReturnLinks(li);
		transactionRepo.save(t);
		System.out.println("One data inserted succesfully");
			
	}
	/*
	 * { "id": "26359efd-7cfb-4014-a13d-1724e3ff17fa", "amount": 1900,
	 * "merchantRefNum": "merchantRefNum-115", "action": "NONE", "currencyCode":
	 * "GBP", "usage": "SINGLE_USE", "status": "EXPIRED", "timeToLiveSeconds": 0,
	 * "transactionType": "PAYMENT", "paymentType": "CARD", "executionMode":
	 * "SYNCHRONOUS", "customerIp": "172.0.0.1", "paymentHandleToken":
	 * "SC0YsGIIgFksiOsQ", "billingDetails": { "street": "100 Queen", "street2":
	 * "Unit 201", "city": "Toronto", "country": "CA", "zip": "M5H 2N2" }, "card": {
	 * "cardExpiry": { "month": "12", "year": "2034" }, "holderName": "poorna",
	 * "cardType": "MC", "cardin": "519133", "lastDigits": "4415" }, "returnLinks":
	 * [{ "rel": "on_completed", "href":
	 * "https://US_commerce_site/payment/return/success" "method": "GET" }, { "rel":
	 * "on_failed", "href": "https://US_commerce_site/payment/return/failed"
	 * "method": "GET" } ] }
	 */
	
	public List<Transaction> findAll()
	{
		Iterable data=transactionRepo.findAll();
		Iterator dataloop=data.iterator();
		List<Transaction> newData=new ArrayList<Transaction>();
		while(dataloop.hasNext())
		{
			newData.add((Transaction)dataloop.next());
		}
		return newData;
	}
	public Transaction findById(String id) throws TransactionNotFoundException
	{
		Optional<Transaction> opt=transactionRepo.findById(id);
		Transaction tr=null;
		if(opt.isPresent())
			return opt.get();
		else throw new  TransactionNotFoundException("No transaction with given id found");
		
	}
	public Transaction save(Transaction transaction)
	{
		
		
		return transactionRepo.save(transaction);
	}
}
