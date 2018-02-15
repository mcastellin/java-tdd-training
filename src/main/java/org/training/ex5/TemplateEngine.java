package org.training.ex5;

import org.training.ex5.dto.Client;
import org.training.ex5.dto.Template;

public interface TemplateEngine {

    String prepareMessage(Template msgTemplate, Client msgClient);

}
