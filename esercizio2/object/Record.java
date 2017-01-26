package src.esercizio2.object;


public class Record<S, I, F> {

  S field1;
  I field2;
  F field3;

  public Record(S field1, I field2, F field3) {
    this.field1 = field1;
    this.field2 = field2;
    this.field3 = field3;
  }

  public S getField1() {
    return field1;
  }

  public void setField1(S field1) {
    this.field1 = field1;
  }

  public I getField2() {
    return field2;
  }

  public void setField2(I field2) {
    this.field2 = field2;
  }

  public F getField3() {
    return field3;
  }

  public void setField3(F field3) {
    this.field3 = field3;
  }
}
