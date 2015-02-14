package com.mrjaffesclass.apcs.mvc.template;

/**
 * This is the message payload class.  Instantiate this class when sending
 * field / value message data for the up/down buttons
 * 
 * @author Roger Jaffe
 * @version 1.0
 */
public class MessagePayload {
  
  //private final int field;
  //private final int direction;
  private final float maxAge;
  private final String matchName;
  final String picture;
  final String hobbies;
  final boolean test;
  private final Double age;
  private final float matchAge;

  
  /**
   * Class constructor
   * @param _field Text field 1 or 2
     * @param _maxAge
     * @param _matchName
     * @param _matchAge
     * @param _picture
     * @param _hobbies
     * @param _test
   * @param _direction Direction (Constants.UP or Constants.DOWN)
     * @param _age age of person looking for a match
     * @param _name name of person who is looking for a date
   */
  public MessagePayload(Double _age, float _maxAge, String _matchName, float _matchAge, String _picture, String _hobbies, boolean _test) {
    //field = _field;
    //direction = _direction;
    maxAge = _maxAge;
    age = _age;
    test = _test;
    hobbies = _hobbies;
    picture = _picture;
    matchAge = _matchAge;
    matchName = _matchName;
  }


    
  
  /**
   * Getter method for the direction
   * @return Field value
   */

  public Double getAge(){
      return age;
  }
  
  public boolean getTest(){
      return test;
  }
  
  public String getHobbies(){
      return hobbies;
  }
  
  public String getPicture(){
      return picture;
  }
  
  public float getmaxAge(){
      return maxAge;
  }
  
   public String getmatchName(){
      return matchName;
  }
   
    public float getmatchAge(){
      return matchAge;
  }
  
  /**
   * Getter method for the 
   * @return 
   */

  
}

