package org.example;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Service;
import spark.template.freemarker.FreeMarkerEngine;

public class ArticleFreemarkerController implements Controller{
  private final Service service;
  private final ArticleService articleService;
  private final FreeMarkerEngine freeMarkerEngine;

  public ArticleFreemarkerController(
          Service service,
          ArticleService articleService,
          FreeMarkerEngine freeMarkerEngine
  ) {
    this.service = service;
    this.articleService = articleService;
    this.freeMarkerEngine = freeMarkerEngine;
  }



  @Override
  public void initializeEndpoints() {
    getAllArticle();
  }

  private void getAllArticle() {
    service.get(
            "/",
            (Request request, Response response) -> {
              response.type("text/html; charset=utf-8");
              List<Article> articles = articleService.findAll();
              List<Map<String, String>> articleMapList =
                      articles.stream()
                              .map(article -> Map.of("name", article.getName(), "tags",  String.join(", ",article.getTegs()), "comment", Integer.toString(article.getComment().size())))
                              .toList();

              Map<String, Object> model = new HashMap<>();
              model.put("articles", articleMapList);
              return freeMarkerEngine.render(new ModelAndView(model, "index.ftl"));
            }
    );
  }
}
