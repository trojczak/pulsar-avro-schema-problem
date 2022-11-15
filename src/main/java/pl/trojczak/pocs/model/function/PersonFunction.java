package pl.trojczak.pocs.model.function;

import org.apache.pulsar.functions.api.Context;
import org.apache.pulsar.functions.api.Function;
import pl.trojczak.pocs.model.Person;

public class PersonFunction implements Function<Person, Person> {

  public Person process(Person input, Context context) throws Exception {
    System.out.println(">>> " + input);
    return input;
  }
}
