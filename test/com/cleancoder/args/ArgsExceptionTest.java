package com.cleancoder.args;

import junit.framework.TestCase;

import static com.cleancoder.args.ArgsException.ErrorCode.*;

public class ArgsExceptionTest extends TestCase {
  public void testUnexpectedMessage() throws Exception {
    ArgsException e = new ArgsException(UNEXPECTED_ARGUMENT, 'x', null);
    assertEquals("Argument -x unexpected.", e.errorMessage());
  }

  public void testMissingStringMessage() throws Exception {
    ArgsException e = new ArgsException(MISSING_STRING, 'x', null);
    assertEquals("Could not find string parameter for -x.", e.errorMessage());
  }

  public void testInvalidIntegerMessage() throws Exception {
    ArgsException e = new ArgsException(INVALID_INTEGER, 'x', "Forty two");
    assertEquals("Argument -x expects an integer but was 'Forty two'.", e.errorMessage());
  }

  public void testMissingIntegerMessage() throws Exception {
    ArgsException e = new ArgsException(MISSING_INTEGER, 'x', null);
    assertEquals("Could not find integer parameter for -x.", e.errorMessage());
  }

  public void testInvalidDoubleMessage() throws Exception {
    ArgsException e = new ArgsException(INVALID_DOUBLE, 'x', "Forty two");
    assertEquals("Argument -x expects a double but was 'Forty two'.", e.errorMessage());
  }

  public void testMissingDoubleMessage() throws Exception {
    ArgsException e = new ArgsException(MISSING_DOUBLE, 'x', null);
    assertEquals("Could not find double parameter for -x.", e.errorMessage());
  }

  public void testMissingMapMessage() throws Exception {
    ArgsException e = new ArgsException(MISSING_MAP, 'x', null);
    assertEquals("Could not find map string for -x.", e.errorMessage());
  }

  public void testMalformedMapMessage() throws Exception {
    ArgsException e = new ArgsException(MALFORMED_MAP, 'x', null);
    assertEquals("Map string for -x is not of form k1:v1,k2:v2...", e.errorMessage());
  }

  public void testInvalidArgumentName() throws Exception {
    ArgsException e = new ArgsException(INVALID_ARGUMENT_NAME, '#', null);
    assertEquals("'#' is not a valid argument name.", e.errorMessage());
  }

  public void testInvalidFormat() throws Exception {
    ArgsException e = new ArgsException(INVALID_ARGUMENT_FORMAT, 'x', "$");
    assertEquals("'$' is not a valid argument format.", e.errorMessage());
  }
}