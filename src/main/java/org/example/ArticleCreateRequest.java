package org.example;

import java.util.List;
import java.util.Set;

public record ArticleCreateRequest(String name, Set<String> tegs, List<Comment> comment) {
}
