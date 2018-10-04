package configsrv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {

    final String name = "test.prop1";

//	@Value("${test.prop1}")
//	private String myEnv;

    @Autowired
    ConfigurableEnvironment configurableEnvironment;

    @RequestMapping("/myenv")
    String getEnv() {
        StringBuilder result = new StringBuilder();
        configurableEnvironment.getPropertySources()
                .forEach(ps -> {
                    result.append(ps.getName())
                            .append("\t->\t")
                            .append(name)
                            .append(" = ")
                            .append(ps.getProperty(name))
                            .append("<br>");
                });
        // return this.myEnv+ " <BR>";//+ myProperties;

        result.append("======================")
                .append("<br>");
        result.append("Env: ")
                .append(configurableEnvironment.getProperty(name))
                .append("<br>");
//		result.append("Autowired: ")
//				.append(myEnv);
        return result.toString();
    }
}
