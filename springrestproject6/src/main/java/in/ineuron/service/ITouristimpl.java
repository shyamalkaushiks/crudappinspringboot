package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.Exception.TouristNotFoundException;
import in.ineuron.dao.ITouristRepo;
import in.ineuron.model.Tourist;
@Service
public class ITouristimpl implements ITouristMgmtService{
	@Autowired
	private ITouristRepo repo;
	@Override
	public String Adduser(Tourist tourist) {
		// TODO Auto-generated method stub
	Integer id=repo.save(tourist).getTid();
	return "value save in db with id is"+id;
		
	}
	@Override
	public List<Tourist> FetchAlldetails() {
		// TODO Auto-generated method stub
		List<Tourist> list=repo.findAll();
		list.sort((t1,t2)->t1.getTid().compareTo(t2.getTid()));
		return list;
	}
	@Override
	public Tourist fetchDetailsByid(Integer id) {
		// TODO Auto-generated method stub
		  Optional<Tourist> tourist=repo.findById(id);
		  if(tourist.isPresent())
		  {
			  return tourist.get();
		  }
		  else
		  {
			  throw new TouristNotFoundException("the following tourist details is  this id not found and id is "+id);
		  }
	}
	@Override
	public String updateTouristByDetails(Tourist tourist) {
		// TODO Auto-generated method stub
		Optional<Tourist> details=repo.findById(tourist.getTid());
		if(details.isPresent())
		{
			repo.save(tourist);
			return "Tourist with the id ::" + tourist.getTid() + " updated";
		}
		else
		{
			 throw new TouristNotFoundException("the following tourist details is  this id not found and id is "+tourist.getTid());
		}
	}
	@Override
	public String updateTouristById(Integer id, Float hikePercent) {

		Optional<Tourist> optional = repo.findById(id);
		if (optional.isPresent()) {
			Tourist tourist = optional.get();
			tourist.setBudget(tourist.getBudget() + (tourist.getBudget() * (hikePercent / 100)));
			repo.save(tourist);
			return "Tourist budget is updated for the id :: " + tourist.getTid();
		} else {
			throw new TouristNotFoundException("Tourist not found for the id " + id);
		}

	}
	@Override
	public String deleteTouristById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Tourist> d=repo.findById(id);
		if(d.isPresent())
		{
		repo.deleteById(id);
		return "Tourist with the id :: " + id + " deleted...";
		}
		else
		{
			throw new TouristNotFoundException("Tourist not found for the id " + id);
		}
	}

	

}
