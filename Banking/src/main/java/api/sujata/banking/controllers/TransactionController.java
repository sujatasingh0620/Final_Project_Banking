package api.sujata.banking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.sujata.banking.Exceptions.TransactionNotFoundException;
import api.sujata.banking.beans.Transaction;
import api.sujata.banking.services.TransactionService;

@RestController
@RequestMapping(value="/api.test.paysafe.com/paymenthub/v1")
public class TransactionController {

	@Autowired
	TransactionService transactionService;
	
	@GetMapping("/paymenthandles")
	public List findAll() throws TransactionNotFoundException
	{
		List l= transactionService.findAll();
		if(l.size()<=0)
			throw new TransactionNotFoundException("No transaction in the database");
		else
			return l;
	}
	@GetMapping("/paymenthandles/{id}")
	public Transaction findById(@PathVariable String id) throws TransactionNotFoundException
	{
		
		return transactionService.findById(id);
	}
	@PostMapping("/paymenthandles")
	public Transaction saveTransaction(@RequestBody Transaction transaction)
	{
		return transactionService.save(transaction);
	}
}
