package Dao;

import java.util.List;

import Model.Offer;
import Model.OfferLines;

public interface IOfferDAO  {
	
	
	public void InsertOffer(Offer o);
	
	public void InsertOffer(Offer o,List <OfferLines> ol);
	
	public void UpdateOffer(Offer o);
	
	
	public List<Offer> getListOffers(int pcustomerid) throws Exception;
	
	public List<Offer> getApprovedOffers(int pcustomerid) throws Exception;
	
	public List<Offer> getListOfferType(String type);
	
	public Offer getOffer(int offerId);


}
