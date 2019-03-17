package no.hvl.dat102.exception;

//********************************************************************
//  EmptyCollectionException.java   //
//  Representerer situasjonen når samlingen er tom.
//********************************************************************

public class EmptyCollectionException extends RuntimeException{
   	

/******************************************************************
     Setter opp dette unntaket med passende melding.
   ******************************************************************/
   public EmptyCollectionException (String samling){
      super (" Denne " + samling + " er tom.");
   }
}
