package cop4331.controller;

//necessary java and javax packages
import java.util.ArrayList;
import java.util.List;
import javax.faces.component.UICommand;
import javax.faces.component.UIForm;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

//connecting to model data
import cop4331.listModel.*;

/**
 *Controller main class
*/
public class TodoController {
  //domain model Objects List
  private List<Todo> todos;
  //List Object
  private Todo todo;

  //JavaServerFaces variables
  private UIForm form;
  private UIForm tableForm;
  private UICommand addCommand;

  /**
   *Controller Constructor
  */
  public TodoController() {
    todos = new ArrayList<Todo>();
    todos.add(new Todo("Finish Java Project", "Pass Object Oriented Design!", 3));
    todos.add(new Todo("Take a shower", "No stress, whenever I have time left...", 1));
    todos.add(new Todo("Cast Ring into the Fire", "Tame Gollum, he might be helpful", 2));
  }

  /**
   * addNew sets new object list to be rendered on html view
   * @pre no list is is currently set up
   * @post new object list is visible, with or or new list items
   * @return null String
   */
  public String addNew() {
    todo = new Todo("", "", 3);
    form.setRendered(true);
    addCommand.setRendered(false);
    return null;
  }

  /**
   * save adds list object to Objctes list
   * @pre user is still adding new item to list
   * @post item is saved to list model and rendered in view
   * @return null String
   */
  public String save() {
    todos.add(todo);
    form.setRendered(false);
    addCommand.setRendered(true);
    return null;
  }

  /**
   * cancel cancels user input of new List Object Item
   * @pre user has chosen to insert new List Item
   * @post insertion of new List Item has been cancelled
   * @return null String
   */
  public String cancel() {
    todo = null;
    form.setRendered(false);
    addCommand.setRendered(true);
    return null;
  }

  /**
   * delete deletes an object item from list
   * @pre there must be at least one object item in the list
   * @post user selected list item is deleted from list
   * @return null String
   */
  public String delete() {
    todos.remove(todo);
    return null;
  }

  /**
   * displayTable sets table to be visible or not
   * @pre table might be visible or not
   * @post if table is visible, it will be hidden; if hidden, it will be visible
   * @param event
   */
  public void displayTable(ActionEvent event) {
    if (event.getComponent().getId().equalsIgnoreCase("hide")) {
      tableForm.setRendered(false);
    } 
    else {
      tableForm.setRendered(true);
    }
  }

  /**
   * generate a priority list to be chosen when creating a list item
   * @pre no List of Priorities is generated
   * @post priority list is generated
   * @return list of priority options
   */
  public List<SelectItem> getPriorities() {
    List<SelectItem> list = new ArrayList<SelectItem>();
    list.add(new SelectItem(1, "High"));
    list.add(new SelectItem(2, "Medium"));
    list.add(new SelectItem(3, "Low"));
    return list;
  }

  /**
   * getTodos returns current list of to do objects
   * @pre list must be generated and valid
   * @post valid to do list is returned
   * @return current to do list
   */
  public List<Todo> getTodos() {
    return todos;
  }

  /**
   * setTodos sets the current list based on a parameterized list
   * @pre current list must be valid, as well as passed in list
   * @post passed in list is now the current to do list
   * @param todos
   */
  public void setTodos(List<Todo> todos) {
    this.todos = todos;
  }

  /**
   * getTodo returns a list object item
   * @pre list must be valid and contain at least one list item
   * @post valid list item is returned
   * @return todo list object item
   */
  public Todo getTodo() {
    return todo;
  }

  /**
   * copies parameter todo item into current todo item
   * @pre current todo item must be valid, as well as passed in item
   * @post passed in todo item is set to be current todo item
   * @param todo
   */
  public void setTodo(Todo todo) {
    this.todo = todo;
  }

  /**
   * acquires current UI form of JSF
   * @pre form must be valid
   * @post current UI form is returned
   * @return current form
   */
  public UIForm getForm() {
    return form;
  }

  /**
   * sets current form to parameterized form
   * @pre both current and passed in forms must be valid
   * @post current form is now the passed in parameterized form
   * @param form
   */
  public void setForm(UIForm form) {
    this.form = form;
  }

  /**
   * sets command to UI view
   * @pre command must be valid and recognized
   * @post desired command is added to UI view
   * @return desired command is set
   */
  public UICommand getAddCommand() {
    return addCommand;
  }

  /**
   * passes parameterized UI command to current UI command
   * @pre both current and parameterized commands must be valid
   * @post current UI command is now the passed in UI command
   * @param addCommand
   */
  public void setAddCommand(UICommand addCommand) {
    this.addCommand = addCommand;
  }

  /**
   * returns current jsf table form
   * @pre current table form must be valid
   * @post current table form is returned
   * @return tableForm
   */
  public UIForm getTableForm() {
    return tableForm;
  }

  /**
   * passes parameterized table form into current table form
   * @pre both parameterized and current table forms must be valid
   * @post current table form is now the passed in table form
   * @param tableForm
   */
  public void setTableForm(UIForm tableForm) {
    this.tableForm = tableForm;
  }
} 