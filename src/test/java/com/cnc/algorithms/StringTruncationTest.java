package com.cnc.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringTruncationTest {

  
  @Test
  public void EmptyGoogleResult() {
    assertEquals("", StringTruncation.getGoogleSeachTitle("", 100));
  }
  
  
  @Test
  public void TruncateInString() {
    assertEquals("abs abc", StringTruncation.getGoogleSeachTitle("abs abc abc", 8));
    assertEquals("abs abc", StringTruncation.getGoogleSeachTitle("abs abc abc", 7));
    
  }
  

  @Test
  public void NullGoogleResult() {
    assertEquals(null, StringTruncation.getGoogleSeachTitle(null, 100));
  }

  @Test
  public void SingalLenGoogleResult() {
    assertEquals("G", StringTruncation.getGoogleSeachTitle("G", 100));
  }
  

  @Test
  public void TruncateNoSpaces() {
    assertEquals("GOOOOOLLLG", StringTruncation.getGoogleSeachTitle("GOOOOOLLLGGE", 10));
  }
  

  @Test
  public void TruncateWithSpaces() {
    assertEquals("GOOO", StringTruncation.getGoogleSeachTitle("GOOO OOLLLGGE", 10));
  }
}
