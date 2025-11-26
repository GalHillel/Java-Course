package main;

/**
 * Saveable Interface
 * 
 * Defines the contract for objects that can be persisted to and loaded from
 * files.
 * Implementing classes must provide methods to serialize their state to a
 * string
 * and deserialize from a string.
 * 
 * @author University Assignment
 * @version 1.0
 */
public interface Saveable {

	/**
	 * Serializes this object's state to a string format for file storage.
	 * 
	 * @return String representation of this object suitable for file persistence
	 */
	public String getFileText();

	/**
	 * Deserializes this object's state from a string loaded from a file.
	 * 
	 * @param data String data to parse and load into this object
	 */
	public void loadFileText(String data);
}
