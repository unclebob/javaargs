package com.objectmentor.utilities.args.fixtures;

import com.objectmentor.utilities.args.*;

public class ArgsFixture {
  private Args args;
  private ArgsException error = null;

  public void parseFormat(String arguments, String format) throws Exception {
    try {
      args = new Args(format, arguments.split(" "));
    } catch (ArgsException e) {
      error = e;
      throw e;
    }
  }

  public boolean getBoolean(char arg) throws Exception {
    return args.getBoolean(arg);
  }

  public String getMessage() throws Exception {
    return error.errorMessage();
  }

  public String getString(char arg) {
    return args.getString(arg);
  }

  public boolean has(char arg) {
    return args.has(arg);
  }

  public int getInt(char arg) {
    return args.getInt(arg);
  }

  public double getDouble(char arg) {
    return args.getDouble(arg);
  }

  public String[] getStringArray(char arg) {
    return args.getStringArray(arg);
  }

  public int getNextArgumentIndex() {
    return args.nextArgument();
  }
}
