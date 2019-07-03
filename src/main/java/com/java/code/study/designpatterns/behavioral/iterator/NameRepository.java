package com.java.code.study.designpatterns.behavioral.iterator;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-03 10:43
 */
public class NameRepository implements Container {

  private String names[] = {"Robert" , "John" ,"Julie" , "Lora"};

  @Override
  public Iterator getIterator() {
    return new NameIterator();
  }

  private class NameIterator implements Iterator {
    int index;

    @Override
    public boolean haveNext() {
      if(index < names.length){
        return true;
      }
      return false;
    }

    @Override
    public Object next() {
      if(this.haveNext()){
        return names[index++];
      }

      return null;
    }
  }

}
