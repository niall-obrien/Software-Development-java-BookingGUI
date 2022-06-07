/*
Class to represent AirBnB Booking
Author: Clare Doherty
*/

public class AirBnBBooking{

   //Instance variables
   private int bookingNumber;
   private String date;
   private int numberOfNights; 
   private String address; 
   private int numberOfGuests; 
   private double costPerNight;
   private String propertyType; 
   private boolean petsAllowed;
   private static int nextBookingNumber = 100;
     
   //Constructors
   public AirBnBBooking(String dateIn, int nights, String add, int noGuests, double cost) throws IllegalArgumentException{
   
      bookingNumber = nextBookingNumber++;
      date = dateIn;
      address = add;
      costPerNight = calcCostPerNight(dateIn, cost); //Call method calcCostPerNight which will check date and return cost
      numberOfNights = nights;
      if(noGuests > 20){
      
         noGuests = 20;  //Set maximum number to 20
         
      }
      else{
      
         numberOfGuests = noGuests;
         
      }
      
      propertyType = "Apartment";
      petsAllowed = false;
      
   }//close 5 arg constructor 
   
   public AirBnBBooking(String dateIn, int nights, String add, int noGuests, double cost, String type, boolean pets) throws IllegalArgumentException{
   
      bookingNumber = nextBookingNumber++;
      date = dateIn;
      address = add;
      costPerNight = calcCostPerNight(dateIn, cost); //Call method calcCostPerNight which will check date and return cost
      numberOfNights = nights;
      if(noGuests > 20){
      
         noGuests = 20;  //Set maximum number to 20
         
      }
      else{
      
         numberOfGuests = noGuests;
         
      }
      
      propertyType = type;
      petsAllowed = pets;
      
   }//close 7 arg constructor
   
   /***** Mutator Methods *****/
   
   //Set Date
   public void setDate(String dateIn){
   
      date = dateIn;
      
   }
   
   //Set Address
   public void setAddress(String add){
   
      address = add;
       
   }
   
   //Set number of nights
   public void setNights(int nights) throws IllegalArgumentException{
   
      if(nights < 0){
      
         throw new IllegalArgumentException("No. Of Nights cannot be negative");
      
      }
      else{
      
         numberOfNights = nights;
         
      }//close if-else
      
   }//close setNights
   
   //Set  number of guests
   public void setGuests(int guests) throws IllegalArgumentException{
      
      if(guests < 0){
      
         throw new IllegalArgumentException("No. of Guests cannot be negative");
         
      }    
      else if(guests > 20){
      
         numberOfGuests = 20;
         
      }
      else{
      
         numberOfGuests = guests;
         
      }
      
   }//close setGuests
   
   //Set cost per night
   public void setCostPerNight(double cost) throws IllegalArgumentException{
   
      if(cost < 0){
      
         throw new IllegalArgumentException("Cost per Night cannot be negative");
         
      }
      else{
      
         costPerNight = calcCostPerNight(date, cost);
         
      }
   
   }//close setCostPerNight
   
   //Set Property type
   public void setPropertyType(String type){
   
      propertyType = type;
       
   }
   
   //Set pets allowed
   public void setPetsAllowed(boolean allowPets){
   
      petsAllowed = allowPets;
       
   }
   
   /**** Accessor Methods ****/
   //Get date
   public String getDate(){
   
      return date;
      
   }
   
   //Get booking number
   public int getBookingNumber(){
   
      return bookingNumber;
      
   }
   
   //Get number of nights
   public int getNights(){
   
      return numberOfNights;
      
   }
   
   //Get address
   public String getAddress(){
   
      return address;
       
   }

   //Get number of guests
   public int getNoGuests(){
   
      return numberOfGuests;
       
   }//close getNoGuests
   
   //Get cost per night
   public double getCostPerNight(){
   
      return costPerNight;
       
   }//close getCostPerNight
   
   //Get property type
   public String getPropertyType(){
   
      return propertyType;
       
   }//close getPropertyType
   
   //Get pets allowed
   public boolean petsAllowed(){
   
      if(petsAllowed){
      
         return true;
         
      }
      else{
      
         return false;
         
      }
      
   }//close petsAllowed
   
   //Calculate total booking price
   public double totalBookingPrice(){
   
      return costPerNight * numberOfNights;
      
   }//close totalBookingPrice
   
   //Calculate price per guest
   
   public double pricePerGuest(){ // return cost per guest
   
      return costPerNight * numberOfNights / numberOfGuests;
      //Could also call method totalBookingPrice as code is same
      //return totalBookingPrice() / numberOfGuests; 
      
   }//close pricePerGuest
   
   //Return all booking details
   public String toString(){
   
      return "***** BOOKING DETAILS *****\n" +
            "Booking No:\t\t" + bookingNumber + "\n" +
            "Address:\t\t\t" + address + "\n" +
            "Date:\t\t\t\t" + date + "\n" +
            "Number of Nights:\t" + numberOfNights + "\n" +
            "Cost Per Night:\t\t€" + costPerNight + "\n" +
            "Guests:\t\t\t\t" + numberOfGuests + "\n" +
            "Property Type:\t\t" + propertyType + "\n" +
            "Pets Allowed:\t\t" + (petsAllowed ? "Yes" : "No") + "\n";
            
   }//close toString
   
   //Check date to calculate costPerNight
   public double calcCostPerNight(String dateIn, double costIn) throws IllegalArgumentException{
   
      double cost;
      
      if(costIn < 0){
      
         throw new IllegalArgumentException("Cost per Night cannot be negative");
         
      }
      else{
      
         if(dateIn.toLowerCase().contains("june")||dateIn.toLowerCase().contains("july")||dateIn.toLowerCase().contains("aug")){
         
            cost = costIn + 15;
            
         }
         else if(dateIn.toLowerCase().contains("dec")){
         
            cost = costIn + 10;
            
         }
         else{
         
            cost = costIn;
            
         }
         
         return cost;
         
      }
      
   }//close calcCostPerNight
   
}//close AirBnBBooking class