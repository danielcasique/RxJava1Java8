package org.casique.ps.rxjava8.module1;

public class SideEffectIllustration {

  private int state = 0;

  /**
   * This is pure function because it's not modifying the object state in any way
   *there is no side effects
   */
  public int f1(int x){
    return x * 2;
  }

  //this is impure function it can get unpredictable result with threads
  public int f2(int x){
    state = (++state %3);
    return x * 2 + state;
  }

  public static void main(String[] args) {
    SideEffectIllustration v = new SideEffectIllustration();

    for (int i = 0; i < 100; i++){
      if(v.f1(5) != 10){
        throw new IllegalStateException();
      }
    }

    System.out.println("fi(5) = 10 for all calls");

    for(int i=0; i < 100; i++){
      System.out.println("f2(5) = " + v.f2(5));
    }
  }

}
