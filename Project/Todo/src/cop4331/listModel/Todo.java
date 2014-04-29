package cop4331.listModel;

/**
 * to do list class for data model
 */
public class Todo {
	/**
	 * data model variables
	 */
  private String id;
  private String title;
  private String description;
  private int priority;

  /**
   * Constructor to initialize data for the model
   * @param title
   * @param description
   * @param priority
   */
  public Todo(String title, String description, int priority) {
    this.title = title;
    this.description = description;
    this.priority = priority;
  }
  
  /**
   * getter method to return list item ID
   * @pre there must be at least one valid item in list
   * @post list item id is returned
   * @return id
   */
  public String getId() {
    return id;
  }
  
  /**
   * setter method invoked when creating list item
   * @pre user started process to create a new list item
   * @post new list item's unique ID is set
   * @param id
   */
  public void setId(String id) {
    this.id = id;
  }
  
  /**
   * returns title string of list item
   * @pre item must be valid with initialized title String
   * @post item's title string is returned
   * @return title
   */
  public String getTitle() {
    return title;
  }
  
  /**
   * sets string title for list item
   * @pre current item is valid and being in creation process started by the user
   * @post current item's string title is set
   * @param title
   */
  public void setTitle(String title) {
    this.title = title;
  }
  
  /**
   * returns description string of current item
   * @pre current item must be valid and have description string initialized
   * @post item's description string is returned
   * @return description
   */
  public String getDescription() {
    return description;
  }
  
  /**
   * sets current item's description string
   * @pre current item must be valid and being in creation process started by user
   * @post current item's description string is set
   * @param description
   */
  public void setDescription(String description) {
    this.description = description;
  }
  
  /**
   * returns current item's priority level
   * @pre item must be valid and have priority level set
   * @post item's priority level is returned
   * @return priority
   */
  public int getPriority() {
    return priority;
  }

  /**
   * sets current item's priority level
   * @pre current item must be valid and being in creation process started by user
   * @post current item's priority level is set
   * @param priority
   */
  public void setPriority(int priority) {
    this.priority = priority;
  } 
} 
