package api.sujata.banking.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.sujata.banking.beans.ReturnLinks;
import api.sujata.banking.beans.Transaction;
import api.sujata.banking.repositories.ReturnLinksRepository;

@Service
public class ReturnLinksService {
	@Autowired
	ReturnLinksRepository retRepo;
	public ReturnLinks save(ReturnLinks retLink)
	{
		return retRepo.save(retLink);
	}
	public List<ReturnLinks> findAll()
	{
		Iterable data=retRepo.findAll();
		Iterator dataloop=data.iterator();
		List<ReturnLinks> newData=new ArrayList<ReturnLinks>();
		while(dataloop.hasNext())
		{
			newData.add((ReturnLinks)dataloop.next());
		}
		return newData;
	}

}
