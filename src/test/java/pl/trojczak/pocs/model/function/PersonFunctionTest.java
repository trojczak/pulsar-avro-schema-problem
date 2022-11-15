package pl.trojczak.pocs.model.function;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import java.util.List;
import org.apache.pulsar.common.functions.FunctionConfig;
import org.apache.pulsar.common.functions.FunctionConfig.Runtime;
import org.apache.pulsar.functions.LocalRunner;
import org.slf4j.LoggerFactory;

public class PersonFunctionTest {

  public static void main(String[] args) throws Exception {
    Logger root = (Logger) LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
    root.setLevel(Level.INFO);

    FunctionConfig functionConfig = new FunctionConfig();
    functionConfig.setName(PersonFunction.class.getSimpleName());
    functionConfig.setInputs(List.of("persistent://public/default/person-input"));
    functionConfig.setSubName("person-input-sub");
    functionConfig.setOutput("persistent://public/default/person-output");
    functionConfig.setClassName(PersonFunction.class.getName());
    functionConfig.setRuntime(Runtime.JAVA);

    LocalRunner localRunner = LocalRunner.builder().functionConfig(functionConfig).build();
    localRunner.start(false);
  }
}