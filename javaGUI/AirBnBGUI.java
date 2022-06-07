/*
*AirBnB GUI Class
*Author: Niall o'Brien
*Date: 11th/04/22
*GUI Class to allow user to interact with AirBnBBooking class
*
*I have placed the opening brackets on the same line as the class, method and statement declaration lines to make it
*easier to tell when there may be an opening or closing bracket out of place as jGrasp will display the corresponding
*opening/closing bracket and the line it is on, across top of the window, once a bracket is highlighted with the cursor
*/

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.util.ArrayList;
//Code source: https://jenkov.com/tutorials/javafx/checkbox.html#:~:text=A%20JavaFX%20CheckBox%20is%20a,CheckBox%20.
import javafx.scene.control.CheckBox;
//Code source: https://docs.oracle.com/javase/8/javafx/api/javafx/geometry/NodeOrientation.html
import javafx.geometry.NodeOrientation;
//Code source: https://www.java67.com/2018/12/how-to-remove-objects-or-elements-while-iterating-Arraylist-java.html
import java.util.Iterator;

public class AirBnBGUI extends Application{

   //Create ArrayList for AirBnBBooking Objects
   ArrayList<AirBnBBooking> bookings = new ArrayList<>();
   
   /***** Main Menu shared decs *****/
   
   //Main Menu Scene dec.
   Scene sceneMainMenu;
   
   //Main Menu shared TextField decs.
   TextField txtDate;
   TextField txtAddress;
   TextField txtNoOfGuests;
   TextField txtNoOfNights;
   TextField txtCostPerNight;
   TextField txtBookingNumberCalcTotal;
   
   //Main Menu shared Button decs.
   Button btnAddBooking;
   Button btnViewBookings;
   Button btnEditBooking;
   Button btnCancelBooking;
   Button btnSearchAddress;
   Button btnCalculateBookingCost;
   
   //Main Menu TextArea dec.
   TextArea txtOutput;
   
   /***** Edit Menu shared decs *****/
   
   //Edit Menu Scene dec.
   Scene sceneEditMenu;
   
   //Edit Booking window shared TextField decs.
   TextField txtEnterBookingNumber;
   TextField txtEditDate;
   TextField txtEditAddress;
   TextField txtEditNoOfGuests;
   TextField txtEditNoOfNights;
   TextField txtEditCostPerNight;
   TextField txtEditPropertyType;
   
   //Edit Booking shared Buttons decs.
   Button btnSearchBooking;
   Button btnUpdateDetails;
   Button btnEditReturnToMain;
   
   Label lblEditMessage;
   
   //Code source https://jenkov.com/tutorials/javafx/checkbox.html#:~:text=A%20JavaFX%20CheckBox%20is%20a,CheckBox%20.
   CheckBox checkPetsAllowed;
   
   /***** Cancel Menu shared decs *****/
   Scene sceneCancelMenu;
   
   TextField txtCancelBookingNumber;
   
   TextArea txtCancelBookingOutput;
   
   Button btnRetrieveBooking;
   Button btnCancelBookingConfirm;
   Button btnCancelReturnToMain;
   
   final double SUMMER_SURCHARGE = 15;
   final double WINTER_SURCHARGE = 10;
   
   public void start(Stage stage){
      
      //Clear bookings ArrayList in order to check if any booking have been added to the ArrayList.
      //Code source: https://howtodoinjava.com/java/collections/arraylist/clear-empty-arraylist/#:~:text=ArrayList%20clear()%20syntax,size%20attribute%20to%20'0'%20.&text=Method%20parameter%20%E2%80%93%20none.,Method%20returns%20%E2%80%93%20void.
      bookings.clear();
      
      /***** Main Menu Scene decs and inits. *****/
      
      //Main Menu Labels decs + inits.
      Label lblWindowTitle = new Label("******************* Main Menu *********************");
      Label lblDate = new Label("Date");
      Label lblAddress = new Label("Address");
      Label lblNoOfGuests = new Label("No. of Guests");
      Label lblNoOfNights = new Label("No. of Nights");
      Label lblCostPerNight = new Label("Cost Per Night");
      Label lblBreak = new Label("*******************************************");
      Label lblCalcTotalPrice = new Label("********** Calculate Total Price **********");
      Label lblBookingNumber = new Label("Enter Booking No:");
      
      //Main Menu TextFields inits.
      txtDate = new TextField();
      txtDate.setMaxWidth(130);
      txtAddress = new TextField();
      txtAddress.setMaxWidth(200);
      txtNoOfGuests = new TextField();
      txtNoOfGuests.setMaxWidth(50);
      txtNoOfNights = new TextField();
      txtNoOfNights.setMaxWidth(50);
      txtCostPerNight = new TextField();
      txtCostPerNight.setMaxWidth(50);
      txtBookingNumberCalcTotal = new TextField();
      txtBookingNumberCalcTotal.setMaxWidth(50);
      
      //Main Menu Buttons Functions
      
      //Add Booking Button
      btnAddBooking = new Button("Add Booking");
      btnAddBooking.setOnAction(ev -> addBooking(ev));
      
      //View Bookings Button
      btnViewBookings = new Button("View All Bookings");
      btnViewBookings.setOnAction(ev -> viewBookings(ev));
      
      //Edit Booking Button
      btnEditBooking = new Button("Edit Booking");
      btnEditBooking.setOnAction(ev -> {stage.setScene(sceneEditMenu);
                                          lblEditMessage.setText("");});
      
      //Cancel Booking Button
      btnCancelBooking = new Button("Cancel Booking");
      btnCancelBooking.setOnAction(ev -> {stage.setScene(sceneCancelMenu);
                                          txtCancelBookingOutput.clear();});
      
      btnSearchAddress = new Button("Search by Address");
      btnSearchAddress.setOnAction(ev -> searchAddress(ev));
      
      btnCalculateBookingCost = new Button("Calculate Booking Cost");
      btnCalculateBookingCost.setOnAction (ev -> calculateBookingCost(ev));
      
      //Main Menu TextArea init.
      txtOutput = new TextArea();
      txtOutput.setMaxSize(500, 400);
      txtOutput.setEditable(false);
      
      //Main Menu HBoxes
      HBox input = new HBox(8);
      input.getChildren().addAll(lblDate, txtDate, lblAddress, txtAddress, lblNoOfGuests,
                                 txtNoOfGuests, lblNoOfNights, txtNoOfNights, lblCostPerNight,
                                 txtCostPerNight);
      input.setAlignment(Pos.CENTER);
                                 
      HBox buttons1 = new HBox(8);
      buttons1.getChildren().addAll(btnAddBooking, btnViewBookings, btnEditBooking);
      buttons1.setAlignment(Pos.CENTER);
      
      HBox buttons2 = new HBox(8);
      buttons2.getChildren().addAll(btnSearchAddress,btnCancelBooking);
      buttons2.setAlignment(Pos.CENTER);
      
      HBox calcTotalPrice = new HBox(8);
      calcTotalPrice.getChildren().addAll(lblBookingNumber, txtBookingNumberCalcTotal, btnCalculateBookingCost);
      calcTotalPrice.setAlignment(Pos.CENTER);
            
      //Main Menu VBox
      VBox rootMainMenu = new VBox(10);
      rootMainMenu.getChildren().addAll(lblWindowTitle, input, lblBreak, buttons1, buttons2, lblCalcTotalPrice,
                                          calcTotalPrice, txtOutput);
      rootMainMenu.setAlignment(Pos.CENTER);
      
      //Create Main Menu Scene, add VBox to scene and add scene to Stage
      sceneMainMenu = new Scene(rootMainMenu, 1100, 600);
      stage.setScene(sceneMainMenu);
      stage.setTitle("AirBnB Booking");
      stage.show();
      
      /***** Edit Booking Scene decs + inits. *****/
      
      //Edit Booking Labels dec + inits.
      Label lblEditMenuTitle = new Label("******************* Edit Booking Menu ********************");
      Label lblEnterBookingNumber = new Label("Enter Booking Number");
      Label lblEditDate = new Label("Date");
      Label lblEditAddress = new Label("Address");
      Label lblEditNoOfGuests = new Label("No. Of Guests");
      Label lblEditNoOfNights = new Label("No. of Nights");
      Label lblEditCostPerNight = new Label("Cost per Night");
      Label lblEditPropertyType = new Label("Property Type");
      lblEditMessage = new Label("");
      
      //Edit Booking TextField inits.
      txtEnterBookingNumber = new TextField();
      txtEnterBookingNumber.setMaxWidth(50);
      txtEditDate = new TextField();
      txtEditDate.setMaxWidth(130);
      txtEditAddress = new TextField();
      txtEditAddress.setMaxWidth(200);
      txtEditNoOfGuests = new TextField();
      txtEditNoOfGuests.setMaxWidth(50);
      txtEditNoOfNights = new TextField();
      txtEditNoOfNights.setMaxWidth(50);
      txtEditCostPerNight = new TextField();
      txtEditCostPerNight.setMaxWidth(50);
      txtEditPropertyType = new TextField();
      txtEditPropertyType.setMaxWidth(200);
      
      //Code source: https://jenkov.com/tutorials/javafx/checkbox.html#:~:text=A%20JavaFX%20CheckBox%20is%20a,CheckBox%20.
      checkPetsAllowed = new CheckBox("Pets Allowed");
      //Code source: https://stackoverflow.com/questions/45392828/label-to-the-left-of-checkbox-with-jfoenix-in-javafx
      checkPetsAllowed.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
      
      //Edit Menu Buttons functions
      
      //Search for Booking Button function
      btnSearchBooking = new Button("Search for Booking");
      btnSearchBooking.setOnAction(ev -> searchBooking(ev));
      
      //Update Details Button function
      btnUpdateDetails = new Button("Update Details");
      btnUpdateDetails.setOnAction(ev -> updateDetails(ev));
      
      //Return to Main Menu Button function
      btnEditReturnToMain = new Button("Return to Main Menu");
      btnEditReturnToMain.setOnAction(ev -> {stage.setScene(sceneMainMenu);
                                             txtOutput.clear();});
      
      //Edit Menu window HBoxes
      HBox editBookingNumber = new HBox(8);
      editBookingNumber.getChildren().addAll(lblEnterBookingNumber, txtEnterBookingNumber, btnSearchBooking);
      editBookingNumber.setAlignment(Pos.CENTER);
      
      HBox editBookingDetails1 = new HBox(8);
      editBookingDetails1.getChildren().addAll(lblEditDate, txtEditDate, lblEditAddress, txtEditAddress,
                                                lblEditNoOfGuests, txtEditNoOfGuests, lblEditNoOfNights,
                                                txtEditNoOfNights);
      editBookingDetails1.setAlignment(Pos.CENTER);
                                             
      HBox editBookingDetails2 = new HBox(8);
      editBookingDetails2.getChildren().addAll(lblEditCostPerNight, txtEditCostPerNight, lblEditPropertyType,
                                                txtEditPropertyType, checkPetsAllowed);
      editBookingDetails2.setAlignment(Pos.CENTER);
                                             
      HBox editActionButtons = new HBox(8);
      editActionButtons.getChildren().addAll(btnUpdateDetails, btnEditReturnToMain);
      editActionButtons.setAlignment(Pos.CENTER);
      
      //Edit Menu window VBox
      VBox rootEditMenu = new VBox(10);
      rootEditMenu.getChildren().addAll(lblEditMenuTitle, editBookingNumber, lblEditMessage, editBookingDetails1,
                                          editBookingDetails2, editActionButtons);
      rootEditMenu.setAlignment(Pos.CENTER);
      
      //Create Scene for Edit Menu window
      sceneEditMenu = new Scene(rootEditMenu, 1100, 600);
      
      /***** Cancel Menu decs + inits *****/
      
      Label lblCancelMenuTitle = new Label("******************** Cancel Booking Menu ********************");
      Label lblRetrieveBookingNumber = new Label("Enter Booking Number");
      
      txtCancelBookingNumber = new TextField();
      txtCancelBookingNumber.setMaxWidth(50);
     
      txtCancelBookingOutput = new TextArea();
      txtCancelBookingOutput.setMaxSize(500, 600);
      txtCancelBookingOutput.setEditable(false);
      
      //Cancel Menu Buttons functions
      btnRetrieveBooking = new Button("Retrieve Booking");
      btnRetrieveBooking.setOnAction(ev -> retrieveBooking(ev));
      
      btnCancelBookingConfirm = new Button("Confirm Cancellation");
      btnCancelBookingConfirm.setOnAction(ev -> confirmCancellation(ev));
      
      btnCancelReturnToMain = new Button("Return to Main Menu");
      btnCancelReturnToMain.setOnAction(ex -> {stage.setScene(sceneMainMenu);
                                                txtOutput.clear();});
      
      //Cancel Menu HBoxes and VBox
      HBox cancelInput = new HBox(8);
      cancelInput.getChildren().addAll(lblRetrieveBookingNumber, txtCancelBookingNumber, btnRetrieveBooking);
      cancelInput.setAlignment(Pos.CENTER);
      
      HBox cancelConfirm_Return = new HBox(8);
      cancelConfirm_Return.getChildren().addAll(btnCancelBookingConfirm, btnCancelReturnToMain);
      cancelConfirm_Return.setAlignment(Pos.CENTER);
      
      VBox rootCancelMenu = new VBox(10);
      rootCancelMenu.getChildren().addAll(lblCancelMenuTitle, cancelInput, txtCancelBookingOutput, cancelConfirm_Return);
      rootCancelMenu.setAlignment(Pos.CENTER);
      
      sceneCancelMenu = new Scene(rootCancelMenu, 600, 600);
      
   }//close start
   
   /***** Main Menu Button Methods *****/
   
   //Add Booking Button method
   public void addBooking(ActionEvent ev){
      
      txtOutput.clear();
      
      String date;
      String address;
      int guests;
      int noNights;
      double costNight;
      boolean validValueGuests = false, validValueNoNights = false, validValueCostNight = false;
      
      if(txtDate.getText().isEmpty() || txtAddress.getText().isEmpty() || txtNoOfGuests.getText().isEmpty() || 
         txtNoOfNights.getText().isEmpty() || txtCostPerNight.getText().isEmpty()){
         
         txtOutput.setText("You must enter values in all 5 fields.");
         
      }
      else{
      
         //Assign and parse values to method vars from TextFields
         date = txtDate.getText();
         address = txtAddress.getText();
         
         txtOutput.appendText(checkSurchargeDate(date));
         
         //parse methods contain NumberFormatException handling for each TextField
         guests = parseNoOfGuests(txtNoOfGuests.getText());
         noNights = parseNoOfNights(txtNoOfNights.getText());
         costNight = parseCostPerNight(txtCostPerNight.getText());
         
         /*If-else blocks used for checking negative values as this allows multiple error messages to be appended to
         TextArea, catch block will only add last exception thrown from Object file. Also allows for clearing of
         multiple negative value TextFields.*/
         
         if(guests > 0){//check valid No of Guests entered
            
            validValueGuests = true;
            
         }
         else{
         
            txtOutput.appendText("No. of Guests cannot be negative or zero.\n");
            txtNoOfGuests.clear();
            
         }
         
         if(noNights > 0){//check valid No of Nights entered
            
            validValueNoNights = true;
            
         }
         else{
         
            txtOutput.appendText("No. of Nights cannot be negative or zero.\n");
            txtNoOfNights.clear();
            
         }
         
         if(costNight > 0){
            
            validValueCostNight = true;
            
         }
         else{
         
            txtOutput.appendText("Cost per Night cannot be negative or zero.\n");
            txtCostPerNight.clear();
            
         }
         
         //Check all values have been validated, pass values to constructor and append message to TextArea
         if(validValueGuests && validValueNoNights && validValueCostNight){
            
            bookings.add(new AirBnBBooking(date, noNights, address, guests, costNight));
            txtOutput.appendText("Booking successfully added.");
            
            //Clear TextFields
            txtDate.clear();
            txtAddress.clear();
            txtNoOfGuests.clear();
            txtNoOfNights.clear();
            txtCostPerNight.clear();
            
         }
              
      }//close else
         
   }//close addBooking
   
   //View Bookings Button method
   public void viewBookings(ActionEvent ev){
   
      txtOutput.clear();
      
      if(bookings.size() == 0){
      
         txtOutput.setText("No bookings have been added.\n" +
                             "Please add a booking to be able to View Bookings.");
         
      }
      else{
      
         for(AirBnBBooking bk : bookings){
      
            txtOutput.appendText(bk.toString());
         
         }
         
      }//close if-else to check if any bookings have been added to ArrayList
      
   }//close viewBookings
   
   //Edit Booking Button invokes Scene change to Edit Booking Menu
   
   //Cancel Booking Button invokes Scene change to Cancel Booking Menu
   
   //Search Address Button method
   public void searchAddress(ActionEvent ev){
      
      boolean addressFound = false;
      txtOutput.clear();
      
      if(bookings.size() == 0){
      
         txtOutput.setText("No bookings have been added.\n" +
                             "Please add a booking to be able to Search Address.");
         
      }
      else{
   
         if(txtAddress.getText().isEmpty()){
         
            txtOutput.setText("Please enter an address to search in the Address field above.");
            
         }
         else{
         
            for(AirBnBBooking bk : bookings){
            
               if(bk.getAddress().toLowerCase().contains(txtAddress.getText().toLowerCase())){
               
                  txtOutput.appendText(bk.toString());
                  addressFound = true;
                  
               }
               
            }//close for
            
         }//close if-else to check if an address has been entered and if so search bookings ArrayList
         
      }//close if-else to check for bookings in ArrayList.
      
      if(addressFound){
         
         txtOutput.appendText("Above are the bookings for " + txtAddress.getText() + "\n");
         
      }
      else{
      
         txtOutput.appendText("No bookings for " + txtAddress.getText() + " were found.");
         
      }//close if-else to check if any bookings with entered address were found
   
   }//close searchAddress
   
   //Calculate Booking Cost Button  method
   public void calculateBookingCost(ActionEvent ev){
      
      boolean bookingFound = false;
      
      if(bookings.size() == 0){
      
         txtOutput.setText("No bookings have been added.\n" +
                             "Please add a booking to be able to Calculate Booking Cost.");
         
      }
      else{
      
         int bookingNumberCalcTotal = parseBookingNumber(txtBookingNumberCalcTotal.getText());
         
         for(AirBnBBooking bk : bookings){
         
            if(bk.getBookingNumber() == bookingNumberCalcTotal){
            
               txtOutput.setText("The total booking price for booking no. " + bk.getBookingNumber() + "\n" +
                                 "in " + bk.getAddress() + " for " + bk.getNoGuests() + " people, for " + bk.getNights() +
                                 "nights is: €" + bk.totalBookingPrice());
               bookingFound = true;
               
            }//close if for matching booking number
            
         }//close for to step through bookings ArrayList
         
         if(!bookingFound){
      
         txtOutput.setText("There was no booking with that booking number found.");
         
         }//close if
         
      }//close if-else to check if bookings is empty
      
   }//close calculateBookingCost
   
   /***** Edit Menu Buttons methods *****/
   
   //Search Booking Button method
   public void searchBooking(ActionEvent ev){
      
      if(bookings.size() == 0){
      
         txtOutput.setText("No bookings have been added.\n" +
                             "Please add a booking to be able to Search Bookings.");
         
      }
      else{
      
         //check booking number has been entered
         if(txtEnterBookingNumber.getText().isEmpty()){
         
            lblEditMessage.setText("Please enter a booking number to search.");
         
         }
         
         int bookingNumberSearch = parseBookingNumber(txtEnterBookingNumber.getText());
         
         if(bookingNumberSearch < 0){
         
            lblEditMessage.setText("Booking Number cannot be negative");
            
         }
         else{
         
            for(AirBnBBooking bk : bookings){
            
               if(bk.getBookingNumber() == bookingNumberSearch){
                  
                  txtEnterBookingNumber.setEditable(false);//stop user from changing booking to be edited
                  lblEditMessage.setText("");//remove any previous error messages
                  
                  txtEditDate.setText(bk.getDate());
                  txtEditAddress.setText(bk.getAddress());
                  txtEditNoOfGuests.setText(String.valueOf(bk.getNoGuests()));
                  txtEditNoOfNights.setText(String.valueOf(bk.getNights()));
                  txtEditCostPerNight.setText(String.valueOf(bk.getCostPerNight()));
                  txtEditPropertyType.setText(bk.getPropertyType());
                  if(bk.petsAllowed() == true){
                  
                     checkPetsAllowed.setSelected(true);
                     
                  }
                  else{
                  
                     checkPetsAllowed.setSelected(false);
                     
                  }//close if-else to set Pets Allowed CheckBox
               
               }
               else{
               
                  lblEditMessage.setText("No Booking with that number was found.");
                  
               }//close if-else to check if Booking Number can be found
               
            }//close for to find Booking related to Booking Number searched
            
         }//close if-else to check if Booking Number < 0
         
      }//close if-else to check if any bookings in ArrayList.
      
   }//close searchBooking
   
   //Update Details Button method
   public void updateDetails(ActionEvent ev) throws IllegalArgumentException{
   
      lblEditMessage.setText("");
      
      if(txtEditDate.getText().isEmpty() || txtEditAddress.getText().isEmpty() || txtEditNoOfGuests.getText().isEmpty() ||
            txtEditNoOfNights.getText().isEmpty() || txtEditCostPerNight.getText().isEmpty() ||
               txtEditPropertyType.getText().isEmpty()){
         
         lblEditMessage.setText("All fields must be filled to update details.");
         
      }//close if to check input in all fields.
      else{
         
         try{
         
            //parse method contains NumberFormatException handling
            int updateBookingNumber = parseBookingNumber(txtEnterBookingNumber.getText());
            
            if(updateBookingNumber < 0){
            
               lblEditMessage.setText("Booking Number cannot be negative.");
               
            }
            else{
               
               //parse methods contain NumberFormatException handling for numeric TextFields
               int updateNoOfGuests = parseNoOfGuests(txtEditNoOfGuests.getText());
               int updateNoOfNights = parseNoOfNights(txtEditNoOfNights.getText());
               double updateCostPerNight = parseCostPerNight(txtEditCostPerNight.getText());
               
               boolean updatePetsAllowed = checkPetsAllowed.isSelected();
               
               for(AirBnBBooking bk : bookings){
               
                  if(bk.getBookingNumber() == updateBookingNumber){
                     /*
                     //I was trying to stop surcharges from stacking when booking date is changed, did'nt get it to work
                     //Assign original Booking Date to String
                     String originalDate = bk.getDate().toLowerCase();
                     
                     //Strip out any surcharges associated with original booking date
                     if(originalDate.contains("june")||originalDate.contains("july")||originalDate.contains("aug")){
                        
                        bk.setDate("1st april");
                        double removeSummerSurcharge = bk.getCostPerNight() - SUMMER_SURCHARGE; 
                        bk.setCostPerNight(removeSummerSurcharge);
                        
                     }
                     if(originalDate.contains("dec")){
                        
                        bk.setDate("1st april");
                        double removeWinterSurcharge = bk.getCostPerNight() - WINTER_SURCHARGE;
                        bk.setCostPerNight(removeWinterSurcharge);
                        
                     }
                     */
                     
                     bk.setDate(txtEditDate.getText());
                     bk.setAddress(txtEditAddress.getText());
                     bk.setGuests(updateNoOfGuests);
                     bk.setNights(updateNoOfNights); 
                     bk.setCostPerNight(updateCostPerNight);
                     bk.setPropertyType(txtEditPropertyType.getText());
                     bk.setPetsAllowed(updatePetsAllowed);
                     
                     lblEditMessage.setText("Booking Updated successfully.");
                     
                     //Clear Booking Number Textfield and allow another Booking Number to be entered
                     txtEnterBookingNumber.clear();
                     txtEnterBookingNumber.setEditable(true);
                     
                     //Clear all Booking Details TextFields
                     txtEditDate.clear();
                     txtEditAddress.clear();
                     txtEditNoOfGuests.clear();
                     txtEditNoOfNights.clear();
                     txtEditCostPerNight.clear();
                     checkPetsAllowed.setSelected(false);
                     
                  
                  }//close if for booking found and updated
                  else{
                  
                     lblEditMessage.setText("There is no booking with that Booking Number.");
                     
                  }//close if-else to check if booking can be found
                  
               }//close find Booking for statement 
               
            }//close else
               
         }//close Update Details try block
         catch(IllegalArgumentException ex){
         
            //.getMessage() code source: https://stackoverflow.com/questions/26403008/how-to-remove-part-of-a-message-java-lang-illegalargumentexception-on-excpetion
            lblEditMessage.setText(ex.getMessage());
            
         }//close catch Illegal Arg
         
      }//close else
   
   }//close updateDetails
   
   /***** Cancel Booking Menu Buttons methods *****/
   
   //Retrieve Booking Button method
   public void retrieveBooking(ActionEvent ev){
      
      boolean validBookingNumber = false;
      
      if(bookings.size() == 0){
      
         txtOutput.setText("No bookings have been added.\n" +
                             "Please add a booking to be able to Retrieve Booking.");
         
      }
      else{
      
         if(txtCancelBookingNumber.getText().isEmpty()){
         
            txtCancelBookingOutput.setText("Please enter a Booking Number to retrieve details.");
            
         }
         else{
         
            //parse method contains NumberFormatException handling
            int bookingToRetrieve = parseBookingNumber(txtCancelBookingNumber.getText());
            
            if(bookingToRetrieve < 0){
            
               txtCancelBookingOutput.setText("Booking Number cannot be negative.");
               txtCancelBookingNumber.clear();
               
            }
            else{
            
               for(AirBnBBooking bk : bookings){
               
                  if(bk.getBookingNumber() == bookingToRetrieve){
                     
                     txtCancelBookingNumber.setEditable(false);
                     txtCancelBookingOutput.appendText(bk.toString());
                     validBookingNumber = true;
                  
                  }
                  
               }//close for
               
               if(validBookingNumber == true){
      
                  txtCancelBookingOutput.appendText("Do you wish to cancel the above booking?\n" +
                                             "Press Confirm Cancellation to cancel booking.");
        
               }
               else{
      
                  txtCancelBookingOutput.appendText("There was no Booking found with that Booking Number.");
         
               }//close if else to check valid booking number
               
            }//close if-else to check negative value has not been entered
            
         }//close if-else to check negative value
         
      }//close if-else to check bookings present in ArrayList
      
   }//close retrieveBooking
   
   //Confirm Cancellation Button method
   public void confirmCancellation(ActionEvent ev){
   
      int bookingToCancel = parseBookingNumber(txtCancelBookingNumber.getText());
      
      if(txtCancelBookingNumber.getText().isEmpty()){
      
         txtCancelBookingOutput.setText("Please enter a Booking Number to Retrieve Booking for Cancellation.");
         
      }
      else{
      
         //code source: https://www.java67.com/2018/12/how-to-remove-objects-or-elements-while-iterating-Arraylist-java.html
         Iterator<AirBnBBooking> itr = bookings.iterator();
      
         while(itr.hasNext()){
         
            AirBnBBooking bk = itr.next();
            
            if(bk.getBookingNumber() == bookingToCancel){
            
               itr.remove();
               txtCancelBookingOutput.setText("Booking was successfully cancelled.");
               txtCancelBookingNumber.setEditable(true);
               
            }
            
         }//close Iterator while
         
      }//close if-else to check if there is bookings in ArrayList.
      
   }//close confirmCancellation
   
   /***** parse methods to deal with NumberFormatException handling *****/
   
   public int parseNoOfGuests(String guestsTextFieldIn) throws NumberFormatException{
      
      int guestsIn = 0;
      
      try{//Check numeric value entered for No. of Guests
         
            guestsIn = Integer.parseInt(guestsTextFieldIn);
            
      }
      catch(NumberFormatException ex){
      
         txtOutput.appendText("Please enter a numeric value for No. of Guests.\n");
         lblEditMessage.setText("Please enter a numeric value for No. of Guests.\n");
         txtNoOfGuests.clear();
         txtEditNoOfGuests.clear();
         
      }
         
      return guestsIn;
   
   }//close parseNoOfGuests
   
   public int parseNoOfNights(String nightsTextFieldIn) throws NumberFormatException{
      
      int noNights = 0;
      
      try{//Check numeric value entered for No. of Nights
         
            noNights = Integer.parseInt(nightsTextFieldIn);
            
      }
      catch(NumberFormatException ex){
      
         txtOutput.appendText("Please enter a numeric value for No. of Nights.\n");
         lblEditMessage.setText("Please enter a numeric value for No of Nights.\n");
         txtNoOfNights.clear();
         txtEditNoOfNights.clear();
         
      }
         
      return noNights;
            
   }//close parseNoOfNights
   
   public double parseCostPerNight(String costTextFieldIn) throws NumberFormatException{
   
      double costNight = 0.0;
   
      try{//Check numeric value entered for Cost per Night
            
            costNight = Double.parseDouble(costTextFieldIn);
            
      }
      catch(NumberFormatException ex){
      
         txtOutput.appendText("Please enter a numeric value for Cost per Night.\n");
         lblEditMessage.setText("Please enter a numeric value for Cost per Night.\n");
         txtCostPerNight.clear();
         txtEditCostPerNight.clear();
         
      }
         
      return costNight;
         
   }//close parseCostPerNight
   
   public int parseBookingNumber(String bookingTextFieldIn) throws NumberFormatException{
   
      int bookingNo = 0;
      
      try{
      
         bookingNo = Integer.parseInt(bookingTextFieldIn);
         
      }
      catch(NumberFormatException ex){
      
         lblEditMessage.setText("Please enter a numeric value for Booking Number.\n");
         txtCancelBookingOutput.setText("Please enter a numeric value for Booking Number.\n");
         txtEnterBookingNumber.clear();
         txtCancelBookingNumber.clear();
         
      }
      
      return bookingNo;
      
   }
   
   //Check if date falls in surcharge months and inform user
   public String checkSurchargeDate(String dateIn){
   
      if(dateIn.toLowerCase().contains("june")||dateIn.toLowerCase().contains("july")||dateIn.toLowerCase().contains("aug")){
         
         return "There is a €15/night surcharge for bookings in this month.\n";
         
      }
      else if(dateIn.toLowerCase().contains("dec")){
         
         return "There is a €10/night surcharge for bookings in this month.\n";
      
      }
      else{
      
         return "";
         
      }
      
   }//close checkSurchargeDate
   
   public static void main(String[]args){
      
      launch(args);
      
   }//close main
   
}//close AirBnBGUI class