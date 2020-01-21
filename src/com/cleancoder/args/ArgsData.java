package com.cleancoder.args;

import static com.cleancoder.args.ArgsException.ErrorCode.INVALID_ARGUMENT_FORMAT;
import static com.cleancoder.args.ArgsException.ErrorCode.INVALID_ARGUMENT_NAME;

import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class ArgsData {
	public Map<Character, ArgumentMarshaler> marshalers;
	public Set<Character> argsFound;
	public ListIterator<String> currentArgument;

	public ArgsData() {
	
	}
	  public void parseSchema(String schema) throws ArgsException {
		    for (String element : schema.split(","))
		      if (element.length() > 0)
		        parseSchemaElement(element.trim());
		  }
	  /*
	   * add schema definitions -- in all files
	   * */
	    private void parseSchemaElement(String element) throws ArgsException {
	      char elementId = element.charAt(0);
	      String elementTail = element.substring(1);
	      validateSchemaElementId(elementId);
	      if (elementTail.length() == 0)
	        marshalers.put(elementId, new BooleanArgumentMarshaler());
	      else if (elementTail.equals("*"))
	        marshalers.put(elementId, new StringArgumentMarshaler());
	      else if (elementTail.equals("#"))
	        marshalers.put(elementId, new IntegerArgumentMarshaler());
	      else if (elementTail.equals("##"))
	        marshalers.put(elementId, new DoubleArgumentMarshaler());
	      else if (elementTail.equals("[*]"))
	        marshalers.put(elementId, new StringArrayArgumentMarshaler());
	      else if (elementTail.equals("&"))
	        marshalers.put(elementId, new MapArgumentMarshaler());
	      else
	        throw new ArgsException(INVALID_ARGUMENT_FORMAT, elementId, elementTail);
	    }

	    private void validateSchemaElementId(char elementId) throws ArgsException {
	      if (!Character.isLetter(elementId))
	        throw new ArgsException(INVALID_ARGUMENT_NAME, elementId, null);
	    }
}