package in.ineuron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import in.ineuron.model.Tourist;

public interface ITouristMgmtService {

	public String Adduser(Tourist tourist);
	public List<Tourist> FetchAlldetails();
	public Tourist fetchDetailsByid(Integer id);
	public String updateTouristByDetails(Tourist tourist);
	public String updateTouristById(Integer id,Float hikePercent);
	public String deleteTouristById(Integer id);

}
